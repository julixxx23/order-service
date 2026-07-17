package com.microservices.orderservice.shared.domain.exception;
//Atrapa
public class NotFoundException extends RuntimeException{
    protected NotFoundException(String message){
        super(message);
    }
}
