package com.example.springjavafx.domain;

import java.util.Map;

public interface MappedUrls {

    static Map<String, String> getMappedUrls() {
        return Map.of(
                "Google", "https://www.google.com/",
                "Globoesporte", "https://ge.globo.com/",
                "StackOverflow", "https://stackoverflow.com/"
        );
    }
}
