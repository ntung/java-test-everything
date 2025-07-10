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
                .uri(URI.create(Helpers.API_URL))
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
            assert response != null;
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
            response.headers().map().forEach((header, value) ->
                System.out.println(header + " = " + String.join(", ", value)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            assert response != null;
            System.out.println(response.body());
        }
    }


}
