package com.desempeno.CRUD.validation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;

import static java.lang.String.format;

@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CodigoError {
    //Modelo clave valor para enviar mensajes personalizados en los Exceptions por la consola.
    CLIENTE_NO_ENCONTRADO("Cliente con id %d no encontrado"),
    CLIENTE_ACTIVO_POR_ID_NO_ENCONTRADO("No se encontro usuario activo con id: %d"),
    CLIENTE_NO_PUDO_SER_ACTUALIZADO("El cliente con el id %d no puedo ser actualizado"),
    CATEGORIA_DE_CLIENTE_NO_PUDO_SER_ACTUALIZADO("No se pudo actualizar la categoria del cliente con id: %d"),
    CLIENTE_NO_PUDO_SER_CREADO("El cliente con email %e no pudo ser creado "),
    CLIENTE_NO_PUDO_SER_BORRADO("El cliente con id %d no pudo ser borrado");
    private final String description;
    public String getCode(){
        return this.name();
    }
    public String getDescription(Object... params){
        return format(description,params);
    }
}
