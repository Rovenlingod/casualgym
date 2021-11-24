package com.rovenlin.casualgym.service;

import com.rovenlin.casualgym.domain.Exercise;
import com.rovenlin.casualgym.domain.User;
import com.rovenlin.casualgym.dtos.ExerciseCreationFormDTO;
import com.rovenlin.casualgym.dtos.ExerciseDTO;
import com.rovenlin.casualgym.mappers.ExerciseMapper;
import com.rovenlin.casualgym.repository.ExerciseRepository;
import com.rovenlin.casualgym.security.jwt.JwtUser;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseMapper exerciseMapper;
    private ExerciseRepository exerciseRepository;
    private StorageService storageService;
    private UserService userService;

    public ExerciseServiceImpl(ExerciseMapper exerciseMapper, ExerciseRepository exerciseRepository, StorageService storageService, UserService userService) {
        this.exerciseMapper = exerciseMapper;
        this.exerciseRepository = exerciseRepository;
        this.storageService = storageService;
        this.userService = userService;
    }

    @Override
    public ExerciseDTO createExercise(ExerciseCreationFormDTO creationFormDTO) {
        storageService.store(creationFormDTO.getGif());
        Exercise createdExercise = exerciseRepository.save(exerciseMapper.toEntity(creationFormDTO));
        return exerciseMapper.toDTO(createdExercise);
    }

    @Override
    public ExerciseDTO findById(Long exerciseId) {
        return exerciseMapper.toDTO(exerciseRepository.findByExerciseId(exerciseId));
    }


    @Override
    public List<ExerciseDTO> getAvailableExercisesForCurrentUser(JwtUser user) {
        User currentUser = userService.findByLogin(user.getUsername());
        List<ExerciseDTO> publicExercises = getPublicExercises();
        List<ExerciseDTO> currentUserExercises = exerciseMapper.toDTOs(exerciseRepository.findAllByCreatorAndIsPublic(currentUser, false));
        currentUserExercises.addAll(publicExercises);
        return currentUserExercises;
    }

    @Override
    public List<ExerciseDTO> getPublicExercises() {
        List<Exercise> publicExercises = exerciseRepository.findAllByIsPublic(true);
        return exerciseMapper.toDTOs(publicExercises);
    }
}
