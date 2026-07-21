package com.microservices.orderservice.shared.domain.exception;
//Atrapa errores del capa 8
public class NotFoundException extends RuntimeException{
    protected NotFoundException(String message){
        super(message);
    }
}
