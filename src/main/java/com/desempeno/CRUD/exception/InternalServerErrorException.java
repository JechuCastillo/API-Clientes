package com.desempeno.CRUD.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends ApiException {
    public InternalServerErrorException(String code,String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR,code,message);;
    }
}
