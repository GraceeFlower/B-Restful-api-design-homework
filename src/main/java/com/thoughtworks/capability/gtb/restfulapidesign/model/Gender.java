package com.thoughtworks.capability.gtb.restfulapidesign.model;

public enum Gender {
    MALE("male"), FEMALE("female");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
