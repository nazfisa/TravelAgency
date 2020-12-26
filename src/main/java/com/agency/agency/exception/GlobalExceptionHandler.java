package com.agency.agency.exception;

import com.agency.agency.exception.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler()
    public final String handleResourceNotFountException(ResourceNotFoundException ex,
                                                        WebRequest request, Model model){

        ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(ex.getMessage());
        model.addAttribute("error_message", resourceNotFoundException.getMessage());
        return "errors/404";
    }
}
