package com.rovenlin.casualgym.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ExerciseCreationFormDTO {
    private String title;
    private MultipartFile gif;
    private Long creatorId;
    private Boolean isPublic;
}
