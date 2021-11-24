package com.rovenlin.casualgym.service;

import com.rovenlin.casualgym.dtos.WorkoutDTO;

public interface WorkoutService {

    WorkoutDTO createWorkout(WorkoutDTO workoutDTO);
    WorkoutDTO findWorkoutById(Long id);
}
