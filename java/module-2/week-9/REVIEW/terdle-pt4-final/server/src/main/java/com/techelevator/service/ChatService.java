package com.techelevator.service;

import com.techelevator.model.UserGame;
import com.techelevator.model.ai.ChatCompletionDto;
import com.techelevator.model.ai.ChatRequestDto;
import com.techelevator.model.ai.Message;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ChatService {

    private static final String OPENAI_ENDPOINT = "https://api.openai.com/v1/chat/completions";
    private static final String OPENAI_KEY = "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";
    public static final String OPENAI_MODEL = "gpt-3.5-turbo";



    private RestTemplate restTemplate = new RestTemplate();


    public String getUserGameAnalysis(List<UserGame> games) {

        String question = String.format("If I play the following Wordle games where 'word' is the secret word, 'guesses' " +
                "are the attempts at guessing the secret word and 'success' is if the game was won, could you analyze " +
                "the game play and rate me as a Wordle player?  %s", games);

        // Set the token in the auth header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + OPENAI_KEY);

        // Create the input for ChatGPT
        ChatRequestDto request = new ChatRequestDto(OPENAI_MODEL, 0.2);
        request.setModel(OPENAI_MODEL);
        request.setTemperature(1.2);
        request.addMessage(new Message("user", question));

        // Package the body and headers in an entity
        HttpEntity<ChatRequestDto> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<ChatCompletionDto> responseEntity =restTemplate.exchange(OPENAI_ENDPOINT, HttpMethod.POST, requestEntity, ChatCompletionDto.class );

        ChatCompletionDto chatCompletion = responseEntity.getBody();

        return chatCompletion.getChoices().get(0).getMessage().getContent();
    }
}
