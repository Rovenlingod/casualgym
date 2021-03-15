package com.rovenlin.casualgym.controller;

import com.rovenlin.casualgym.dtos.WorkoutDTO;
import com.rovenlin.casualgym.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/workouts")
public class WorkoutController {

    private WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @PostMapping
    public ResponseEntity createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutService.createWorkout(workoutDTO));
    }
}
