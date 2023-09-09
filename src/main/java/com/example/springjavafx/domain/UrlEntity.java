package com.example.springjavafx.domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UrlEntity {

    private final StringProperty applicationName = new SimpleStringProperty();
    private final StringProperty urlValue = new SimpleStringProperty();
    private final StringProperty urlStatus = new SimpleStringProperty();

    public UrlEntity(String applicationName, String urlValue, String urlStatus) {
        this.applicationName.setValue(applicationName);
        this.urlValue.setValue(urlValue);
        this.urlStatus.setValue(urlStatus);
    }

    public String getApplicationName() {
        return applicationName.get();
    }

    public StringProperty applicationNameProperty() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName.set(applicationName);
    }

    public String getUrlValue() {
        return urlValue.get();
    }

    public StringProperty urlValueProperty() {
        return urlValue;
    }

    public void setUrlValue(String urlValue) {
        this.urlValue.set(urlValue);
    }

    public String getUrlStatus() {
        return urlStatus.get();
    }

    public StringProperty urlStatusProperty() {
        return urlStatus;
    }

    public void setUrlStatus(String urlStatus) {
        this.urlStatus.set(urlStatus);
    }
}
