package com.desempeno.CRUD.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException {
    public BadRequestException(String code,String message) {
        //Utiliza el constructor de ApiException mandando el codigo de badrequest y el mensaje de codigoError o runtime
        super(HttpStatus.BAD_REQUEST,code,message);
    }
}
