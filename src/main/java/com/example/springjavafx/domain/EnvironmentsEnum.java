package com.example.springjavafx.domain;

public enum EnvironmentsEnum {

    DEV("DEV"),
    QA("QA"),
    UAT("UAT"),
    PRD("PRD");

    private String label;

    EnvironmentsEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
