package com.rovenlin.casualgym.dtos;

import com.rovenlin.casualgym.enums.RoundType;
import lombok.Data;

import java.util.List;

@Data
public class RoundDTO {
    private Long workoutId;
    private RoundType roundType;
    private List<ExerciseDTO> exercises;
}
