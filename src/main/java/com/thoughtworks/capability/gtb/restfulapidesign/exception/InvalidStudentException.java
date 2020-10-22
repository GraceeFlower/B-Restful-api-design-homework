package com.thoughtworks.capability.gtb.restfulapidesign.exception;

public class InvalidStudentException extends RuntimeException {

    public InvalidStudentException() {
    }

    public InvalidStudentException(String message) {
        super(message);
    }
}
