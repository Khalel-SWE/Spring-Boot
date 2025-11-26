package com.example.Spring_Boot_Start_Project.config;

import com.example.Spring_Boot_Start_Project.controller.vm.ExceptionResponse;
import com.example.Spring_Boot_Start_Project.helper.BundleMessage;
import com.example.Spring_Boot_Start_Project.service.bundlemessage.BundleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionConfig {

    private BundleMessageService bundleMessageService;

    @Autowired
    public ExceptionConfig(BundleMessageService bundleMessageService) {
        this.bundleMessageService = bundleMessageService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<BundleMessage>> handleRuntimeException(MethodArgumentNotValidException exception) {

        List<BundleMessage> bundleMessages = new ArrayList<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            //user name must not be null
//            exceptionResponses.add(new ExceptionResponse(fieldError.getDefaultMessage()));
            String key = fieldError.getDefaultMessage();
            BundleMessage bundleMessage = new BundleMessage();
            bundleMessage.setMessage(bundleMessageService.getMessage(key));
            bundleMessages.add(bundleMessage);
        });

        return ResponseEntity.badRequest().body(bundleMessages);
    }
}
