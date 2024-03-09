package com.errors.demoerrors.exeptions;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption() {
    }

    public UserNotFoundExeption(String message) {
        super(message);
    }
}
