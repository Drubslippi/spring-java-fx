package com.example.springjavafx.domain;

import java.util.List;
import java.util.Map;

public interface MappedUrls {

    static List<UrlEntity> getObservedEntities() {
        return List.of(
                new UrlEntity("Google", "https://www.google.com/", null),
                new UrlEntity("Globoesporte", "https://ge.globo.com/", null),
                new UrlEntity("StackOverflow", "https://stackoverflow.com/", null),
                new UrlEntity("Chess.com", "https://www.chess.com/", null),
                new UrlEntity("G1", "https://g1.globo.com/", null)
        );
    }

    static Map<EnvironmentsEnum, UrlEntity> getMappedUrls() {
        var listOfUrlEntities = getObservedEntities();

        return Map.of(
                EnvironmentsEnum.DEV, listOfUrlEntities.get(0),
                EnvironmentsEnum.DEV, listOfUrlEntities.get(1),
                EnvironmentsEnum.QA, listOfUrlEntities.get(2),
                EnvironmentsEnum.UAT, listOfUrlEntities.get(3),
                EnvironmentsEnum.PRD, listOfUrlEntities.get(4)
        );
    }

}
