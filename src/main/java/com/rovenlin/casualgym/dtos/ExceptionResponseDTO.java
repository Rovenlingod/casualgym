package com.rovenlin.casualgym.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionResponseDTO {
    private String exceptionName;
    private String message;
}
