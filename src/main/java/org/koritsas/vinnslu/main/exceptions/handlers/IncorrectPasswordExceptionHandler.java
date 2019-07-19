package org.koritsas.vinnslu.main.exceptions.handlers;

import org.hibernate.exception.ConstraintViolationException;
import org.koritsas.vinnslu.main.exceptions.IncorrectPasswordException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class IncorrectPasswordExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IncorrectPasswordException.class})
    public ResponseEntity<Object> handleConstraintViolation(
            IncorrectPasswordException ex, WebRequest request) {

        String bodyOfResponse = "Incorrect password" + ex.getCause();


        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }
}
