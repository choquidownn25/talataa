package org.example.controller;
/*
import org.exemple.utils.XOAuthEmailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@RestController
@RequestMapping("/api")
public class FintocController {

    //XOAuthEmailSender
    @GetMapping("/createLinkIntent")
    public String createLinkIntent() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.fintoc.com/v1/link_intents"))
                .header("accept", "application/json")
                .header("Authorization", "sk_live_YaEcAb8Aj_nTwncZi8yceNmyEgeekChF")
                .header("content-type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString("{\"product\":\"movements\",\"country\":\"cl\",\"holder_type\":\"business\"}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    @GetMapping("/listLinks")
    public String listLinks() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.fintoc.com/v1/links/"))
                .header("accept", "application/json")
                .header("Authorization", "sk_live_YaEcAb8Aj_nTwncZi8yceNmyEgeekChF")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();
    }

    @GetMapping("/retrieveLink")
    public String retrieveLink() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.fintoc.com/v1/links/li_4lK0a8H68glazn2k_sec_twQ3qfYuyAdYNxxq3zGqjsY1"))
                .header("accept", "application/json")
                .header("Authorization", "sk_live_YaEcAb8Aj_nTwncZi8yceNmyEgeekChF")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();
    }

    @PatchMapping("/updateLink")
    public String updateLink() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.fintoc.com/v1/links/link_Q0xVGPvijElLRMwE_token_FhsFVurz5q5FycHA5xxhTpzX"))
                .header("accept", "application/json")
                .header("Authorization", "sk_live_YaEcAb8Aj_nTwncZi8yceNmyEgeekChF")
                .header("content-type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString("{\"active\":true}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();
    }
}
*/