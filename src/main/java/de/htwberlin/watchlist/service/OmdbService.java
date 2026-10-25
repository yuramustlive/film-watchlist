package de.htwberlin.watchlist.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class OmdbService {

    private final RestClient restClient =
            RestClient.create("http://www.omdbapi.com/");
    private final String apiKey;

    public OmdbService(@Value("${omdb.api-key}") String apiKey) {
        this.apiKey = apiKey;
        System.out.println("OMDb-Key gesetzt: " + (apiKey != null && !apiKey.isBlank()));
    }

    public String findImdbRating(String title, int year) {
        if (apiKey == null || apiKey.isBlank()) {
            return null; // no key - no rating
        }
        try {
            Map<?, ?> response = restClient.get()
                    .uri(uri -> uri.path("/")
                            .queryParam("apiKey", apiKey)
                            .queryParam("t", title)
                            .queryParam("y", year)
                            .build())
                    .retrieve()
                    .body(Map.class);
            System.out.println("OMDb-Antwort: " + response);
            if (response == null ||
                    !"True".equals(response.get("Response"))) {
                return null;
            }
            return (String) response.get("imdbRating");
        } catch (Exception e) {
            System.out.println("OMDb-Fehler: " + e.getMessage());
            return null;
            // api is not available - app would anyway work
            }
        }
    }