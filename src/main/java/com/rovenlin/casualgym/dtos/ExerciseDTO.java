package com.rovenlin.casualgym.dtos;

import lombok.Data;

@Data
public class ExerciseDTO {
    private Long exerciseId;
    private String title;
    private String gifName;
    private Long creatorId;
    private Long countdownInSeconds;
    private Boolean isPublic;
}
