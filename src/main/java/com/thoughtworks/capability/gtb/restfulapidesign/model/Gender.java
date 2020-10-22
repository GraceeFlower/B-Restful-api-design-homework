package com.thoughtworks.capability.gtb.restfulapidesign.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Gender {
    MALE("male"), FEMALE("female");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
}
