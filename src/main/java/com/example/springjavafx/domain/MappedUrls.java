package com.example.springjavafx.domain;

import java.util.List;
import java.util.Map;

public interface MappedUrls {

    static List<UrlEntity> getObservedEntities() {
        return List.of(
                new UrlEntity("Google", "https://www.google.com/", null, "DEV"),
                new UrlEntity("Globoesporte", "https://ge.globo.com/", null, "DEV"),
                new UrlEntity("StackOverflow", "https://stackoverflow.com/", null, "QA"),
                new UrlEntity("Chess.com", "https://www.chess.com/", null, "UAT"),
                new UrlEntity("G1", "https://g1.globo.com/", null, "PRD")
        );
    }

    static Map<String, UrlEntity> getMappedUrls() {
        var listOfUrlEntities = getObservedEntities();

        return Map.of(
                listOfUrlEntities.get(0).getApplicationName(), listOfUrlEntities.get(0),
                listOfUrlEntities.get(1).getApplicationName(), listOfUrlEntities.get(1),
                listOfUrlEntities.get(2).getApplicationName(), listOfUrlEntities.get(2),
                listOfUrlEntities.get(3).getApplicationName(), listOfUrlEntities.get(3),
                listOfUrlEntities.get(4).getApplicationName(), listOfUrlEntities.get(4)
        );
    }

}
