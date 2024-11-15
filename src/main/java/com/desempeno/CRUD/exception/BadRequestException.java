package com.desempeno.CRUD.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {
    public BadRequestException(String code,String message) {

        super(HttpStatus.BAD_REQUEST,code,message);
    }
}
