package com.rovenlin.casualgym.service;

import com.rovenlin.casualgym.dtos.ExerciseCreationFormDTO;
import com.rovenlin.casualgym.dtos.ExerciseDTO;
import com.rovenlin.casualgym.security.jwt.JwtUser;

import java.util.List;

public interface ExerciseService {

    ExerciseDTO createExercise(ExerciseCreationFormDTO exerciseDTO);
    ExerciseDTO findById(Long exerciseId);
    List<ExerciseDTO> getAvailableExercisesForCurrentUser(JwtUser user);
    List<ExerciseDTO> getPublicExercises();
}
