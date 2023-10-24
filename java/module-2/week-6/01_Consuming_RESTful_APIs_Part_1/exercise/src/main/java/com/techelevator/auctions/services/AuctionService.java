package com.techelevator.auctions.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction[] getAllAuctions() {
        Auction[] allAuctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        return allAuctions;
    }

    public Auction getAuction(int id) {
        ResponseEntity<Auction> response = restTemplate.getForEntity(API_BASE_URL + "/" + id, Auction.class);
        return response.getBody();
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] response = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        return response;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] response = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        return response;
    }
}
