package com.example.user.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ApiExceptionPayload {

    private final String message;
    private final HttpStatus httpStatus;
    private final Timestamp timestamp;

    public ApiExceptionPayload(String message, HttpStatus httpStatus, Timestamp timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
