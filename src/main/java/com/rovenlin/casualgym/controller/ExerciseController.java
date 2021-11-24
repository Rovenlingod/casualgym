package com.rovenlin.casualgym.controller;

import com.rovenlin.casualgym.dtos.ExerciseCreationFormDTO;
import com.rovenlin.casualgym.security.jwt.JwtUser;
import com.rovenlin.casualgym.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/exercises")
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity createExercise(ExerciseCreationFormDTO creationFormDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseService.createExercise(creationFormDTO));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(exerciseService.findById(id));
    }

    @GetMapping
    public ResponseEntity getAvailableExercises(@AuthenticationPrincipal JwtUser user) {
        return ResponseEntity.status(HttpStatus.OK).body(exerciseService.getAvailableExercisesForCurrentUser(user));
    }

}
