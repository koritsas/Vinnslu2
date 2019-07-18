package org.koritsas.vinnslu.main.exceptions.handlers;

import org.koritsas.vinnslu.main.exceptions.UserExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExistsExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<Object> handleUserExistsException(UserExistsException ex, WebRequest request) {

        String bodyOfResponse= " VinnsluUser with email "+ex.getVinnsluUser().getEmail()+" already exists!";

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
