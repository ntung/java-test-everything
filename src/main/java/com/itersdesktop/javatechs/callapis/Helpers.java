package com.itersdesktop.javatechs.callapis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helpers {
    public static final String API_URL = "https://www.ebi.ac.uk/biostudies/api/v1/arrayexpress/search?page=10&pageSize=20";

    public static void extracted(String response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node =  objectMapper.readTree(response);
            JsonNode hits = node.get("hits");
            // Arrays.stream(node.get("hits")).forEach(System.out::println);
            // is this an array?
            if (node.get("hits").isArray()) {
                // yes, loop the JsonNode and display one by one
                for (JsonNode n : hits) {
                    System.out.println("Accession: " + n.get("accession").asText());
                    System.out.println("\tTitle: " + n.get("title").asText());
                    System.out.println("\tAuthor: " + n.get("author").asText());
                    System.out.println("\tLinks: " + n.get("links").asInt() + "\tFiles: " + n.get("files").asInt());
                    System.out.println("\tRelease Date: " + n.get("release_date").asText());
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
