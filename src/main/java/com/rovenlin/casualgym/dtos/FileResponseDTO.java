package com.rovenlin.casualgym.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponseDTO {
    private String name;
    private String uri;
    private String type;
    private long size;
}
