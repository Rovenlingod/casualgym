package com.rovenlin.casualgym.exceptions;

import com.rovenlin.casualgym.dtos.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(StorageException.class)
    public ExceptionResponseDTO handleStorageExceptions(
            StorageException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO();
        responseDTO.setExceptionName(ex.getClass().getSimpleName());
        responseDTO.setMessage(ex.getMessage());
        return responseDTO;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ExceptionResponseDTO handleIllegalArgumentException(
            IllegalArgumentException ex) {
        ExceptionResponseDTO responseDTO = new ExceptionResponseDTO();
        responseDTO.setExceptionName(ex.getClass().getSimpleName());
        responseDTO.setMessage(ex.getMessage());
        return responseDTO;
    }
}
