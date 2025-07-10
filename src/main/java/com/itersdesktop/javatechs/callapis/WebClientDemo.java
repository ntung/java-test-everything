package com.itersdesktop.javatechs.callapis;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import static com.itersdesktop.javatechs.callapis.Helpers.API_URL;
import static com.itersdesktop.javatechs.callapis.Helpers.extracted;

public class WebClientDemo {

    public static void main(String[] args) throws Exception {
        searchWithWebClient();
        searchWithRestTemplate();
    }

    public static void searchWithWebClient() throws JsonProcessingException {
        System.out.println("\nListing all search hits using Spring WebFlux:");

        WebClient webClient = WebClient.create(API_URL);
        String response = webClient.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();

        extracted(response);
    }


    public static void searchWithRestTemplate() {
        System.out.println("\nListing all search hits using Spring RestTemplate:");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(API_URL, String.class);
        extracted(response.getBody());
    }
}
