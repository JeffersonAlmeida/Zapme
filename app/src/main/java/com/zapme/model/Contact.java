package com.zapme.model;

/**
 * Created by jalmei14 on 3/21/17.
 */

public class Contact {

    private String number;
    private String name;
    private String shortDescription;
    private String imageUrl;

    public Contact(String name) {
        this.name = name;
    }

    public Contact(String name, String shortDescription, String imageUrl) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
