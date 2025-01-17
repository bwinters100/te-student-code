package com.techelevator.services;

import com.techelevator.model.Game;
import com.techelevator.model.UserGame;
import com.techelevator.utils.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GameService is a class for managing requests made to the server REST API for games.
 *
 * By encapsulating this logic into a separate class, it becomes easier to manage, maintain, and
 * test the interactions with the server REST API separate from the other application logic.
 **/
public class GameService {

    private final String API_BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();

    // credential token for the currently logged-in user
    private String authToken = null;

    /**
     * Constructor - The only outside dependency is for the base url used to access the server. Using dependency injection
     * for this value allows it to be more easily changed. It is common for this URL to change for development, testing,
     * and for live deployment.
     *
     * @param url Base URL for the server REST API
     */
    public GameService(String url) {
        this.API_BASE_URL = url;
    }

    /**
     * This method is used by the controller to update the authToken following the user login.
     *
     * @param authToken - credential token for the currently logged-in user.
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * Gets all games from the server REST API.
     * @return the list of games, or null if an error occurred
     */
    public List<Game> getAllGames() {
        try {
            List<Game> games = new ArrayList<Game>();
            ResponseEntity<Game[]> response = restTemplate.exchange(API_BASE_URL + "games", HttpMethod.GET,
                    makeAuthEntity(), Game[].class);
            games = new ArrayList<>(Arrays.asList(response.getBody()));
            return games;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public Game getTodaysGame() {
        try {
            ResponseEntity<Game> response = restTemplate.exchange(API_BASE_URL + "games/today", HttpMethod.GET,
                    makeAuthEntity(), Game.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    /**
     * Creates a new game using the server REST API.
     * @param newGame the information for the new game
     * @return the newly created game, or null if an error occurred
     */
    public Game add(Game newGame) {
        try {
            HttpEntity<Game> entity = makeGameEntity(newGame);
            return restTemplate.postForObject(API_BASE_URL + "games", entity, Game.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    /**
     * Saves updates to a game to the server REST API.
     * @param updatedGame the updated game information to save
     * @return The updated game, or null if an error occurred
     */
    public Game update(Game updatedGame) {
        try {
            HttpEntity<Game> entity = makeGameEntity(updatedGame);
            ResponseEntity<Game> response = restTemplate.exchange(String.format("%s/games/%d", API_BASE_URL, updatedGame.getGameId()), HttpMethod.PUT,
                    entity, Game.class);
            return response.getBody();
        }  catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    /**
     * Deletes a game from the server REST API.
     * @param id the id of the game to delete
     * @return true if successful, false if an error occurred
     */
    public boolean delete(int id) {
        try {
            restTemplate.exchange(String.format("%s/games/%d", API_BASE_URL, id), HttpMethod.DELETE, makeAuthEntity(), Void.class);
            return true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return false;
        }
    }

    public UserGame getUserGame(int userId, int gameId) {
        try {
            ResponseEntity<UserGame> response = restTemplate.exchange(
                    API_BASE_URL + "users/" + userId + "/games/" + gameId,
                    HttpMethod.GET, makeAuthEntity(), UserGame.class);
            return response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public UserGame getOrCreateUserGame(int userId, Game game) {
        try {
            UserGame userGame = getUserGame(userId, game.getGameId());
            return userGame == null ? createUserGame(new UserGame(userId, game)) : userGame;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public List<UserGame> getUserGames(int userId) {

        // TODO!
        return null;
    }

    /**
     * Creates a new game using the server REST API.
     * @param userGame the information for the new game
     * @return the newly created game, or null if an error occurred
     */
    public UserGame createUserGame(UserGame userGame) {
        try {
            return restTemplate.postForObject(
                    API_BASE_URL + "users/" + userGame.getUserId() + "/games",
                    makeUserGameEntity(userGame), UserGame.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
            return null;
        }
    }

    public boolean updateGame(UserGame userGame) {
        try {
            restTemplate.put(
                    API_BASE_URL + "users/" + userGame.getUserId() + "/games/" + userGame.getGameId(),
                    makeUserGameEntity(userGame), UserGame.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getResponseBodyAsString());
            return false;
        }
        return true;
    }

    /**
     * Helper method to create the HTTP Entity that bundles the game data and the auth information together
     * to send to the server REST API.
     *
     * This is used when the request needs to have a body containing the game data, for example a POST or PUT.
     *
     * @param game the game information
     * @return HttpEntity containing the game data and auth information
     */
    private HttpEntity<Game> makeGameEntity(Game game) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(game, headers);
    }

    /**
     * Helper method to create the HTTP Entity that bundles the game data and the auth information together
     * to send to the server REST API.
     *
     * This is used when the request needs to have a body containing the game data, for example a POST or PUT.
     *
     * @param game the game information
     * @return HttpEntity containing the game data and auth information
     */
    private HttpEntity<UserGame> makeUserGameEntity(UserGame game) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(game, headers);
    }

    /**
     * Helper method to create the HTTP Entity containing the auth information to send to the server REST API.
     *
     * This is used when the request does not have a body or payload, for example a GET or DELETE.
     *
     * @return HttpEntity containing the auth information (with no request body data).
     */
    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);
    }
}
