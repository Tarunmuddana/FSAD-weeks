package com.hospital.exception;

public class InvalidFeeException extends RuntimeException {
    public InvalidFeeException(String message) {
        super(message);
    }
}
