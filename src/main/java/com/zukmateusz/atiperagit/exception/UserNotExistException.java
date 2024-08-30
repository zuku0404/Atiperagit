package com.zukmateusz.atiperagit.exception;

public record UserNotExistException(
        int staus,
        String message
) {
}
