package com.example.petclinic.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OwnerExceptionController {

    @ExceptionHandler(value = {OwnerExceptionHandler.class})
    public ResponseEntity<Object> handleOwnerNotFoundException(OwnerExceptionHandler ownerExceptionHandler){
        OwnerException ownerException = new OwnerException(
                ownerExceptionHandler.getMessage(),
                ownerExceptionHandler.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<Object>(ownerException,HttpStatus.NOT_FOUND);
    }
}
