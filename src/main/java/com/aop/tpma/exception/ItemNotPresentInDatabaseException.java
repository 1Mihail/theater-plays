package com.aop.tpma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ItemNotPresentInDatabaseException extends RuntimeException {
    public ItemNotPresentInDatabaseException(String message) {
        super(message);
    }
}
