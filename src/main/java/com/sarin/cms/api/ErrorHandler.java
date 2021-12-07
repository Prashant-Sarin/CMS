package com.sarin.cms.api;

import com.sarin.cms.exception.ApplicationError;
import com.sarin.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${error_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFoundException(
            CustomerNotFoundException customerNotFoundException,
            WebRequest webRequest){
        ApplicationError error = new ApplicationError();
        error.setCode(101);
        error.setMessage(customerNotFoundException.getMessage());
        error.setDetails(details);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
