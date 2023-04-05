package com.example.petclinic.Handler;


public class OwnerExceptionHandler extends RuntimeException {

    public OwnerExceptionHandler(String message){
        super(message);
    }

    public OwnerExceptionHandler(String message , Throwable cause){
        super(message,cause);
    }





}
