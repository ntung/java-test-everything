package com.itersdesktop.javatechs.callapis;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.itersdesktop.javatechs.callapis.Helpers.extracted;

public class HttpClientDemo {

    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                //.uri(URI.create("https://jokes-by-api-ninjas.p.rapidapi.com/v1/jokes"))
                .uri(URI.create(Helpers.API_URL))
                //.header("X-RapidAPI-Host", "jokes-by-api-ninjas.p.rapidapi.com")
                //.header("X-RapidAPI-Key", "e8c2beb634mshdf12449a1ab6679p1eabccjsn26b34f640e2b")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        doWithStringHandler(request);
        doWithInputStreamHandler(request);
    }

    private static void doWithStringHandler(final HttpRequest request) {
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            extracted(response.body());
        }
    }

    private static void doWithInputStreamHandler(final HttpRequest request) {
        HttpResponse<InputStream> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofInputStream());
            int statusCode = response.statusCode();
            System.out.println("HTTP status: " + statusCode);
            System.out.println("Headers:");
            /*System.out.println("Users returned in request: ");
            List<User> users = ExampleUtils.toList(response.body());
            users.forEach(System.out::println);*/
            response.headers().map().forEach((header, value) ->
                System.out.println(header + " = " + String.join(", ", value)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(response.body());
        }
    }


}
