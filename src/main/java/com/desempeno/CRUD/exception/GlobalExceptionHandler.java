package com.desempeno.CRUD.exception;

import com.desempeno.CRUD.models.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //Atrapa los errores NotFounException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GenericResponse>handleClientNotFoundException(NotFoundException e, WebRequest request){ //NotFound creado por mi y Request para obtener la uri
        //Log para la consola que hubo un error
        log.error("NotFoundException: {}",e.getMessage());
        GenericResponse errorDetails = new GenericResponse(HttpStatus.NOT_FOUND.value(),new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GenericResponse>handleBadRequestException(BadRequestException e, WebRequest request){
        log.error("BadRequestException: {}",e.getMessage());
        GenericResponse errorDetails = new GenericResponse(HttpStatus.BAD_REQUEST.value(), new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse>handleGlobalException(Exception e, WebRequest request){
        log.error("InternalServerError: {}",e.getMessage());
        GenericResponse errorDetails= new GenericResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
