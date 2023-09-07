package com.app.product.productcatalog.controllers.advice;

import com.app.product.productcatalog.exceptions.NotFoundException;
import com.app.product.productcatalog.models.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleConflict(
            RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> handleExceptionInternal(RuntimeException exception,
                                                                  HttpStatus status) {
        ErrorResponse errorResponse = new ErrorResponse(status, exception.getMessage());
        return new ResponseEntity<>(errorResponse, status);
    }

}
