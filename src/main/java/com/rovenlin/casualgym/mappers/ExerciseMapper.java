package com.rovenlin.casualgym.mappers;

import com.rovenlin.casualgym.domain.Exercise;
import com.rovenlin.casualgym.dtos.ExerciseCreationFormDTO;
import com.rovenlin.casualgym.dtos.ExerciseDTO;
import com.rovenlin.casualgym.repository.ExerciseRepository;
import com.rovenlin.casualgym.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseMapper {

    private UserRepository userRepository;
    private ExerciseRepository exerciseRepository;

    public ExerciseMapper(UserRepository userRepository, ExerciseRepository exerciseRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public ExerciseDTO toDTO(Exercise exercise){
        ExerciseDTO result = new ExerciseDTO();
        if (exercise.getCreator() != null) {
            result.setCreatorId(exercise.getCreator().getUserId());
        }
        result.setGifName(exercise.getGifName());
        result.setTitle(exercise.getTitle());
        result.setIsPublic(exercise.getIsPublic());
        result.setExerciseId(exercise.getExerciseId());
        result.setExerciseId(exercise.getCountdownInSeconds());
        return result;
    }

    public Exercise toEntity(ExerciseDTO exerciseDTO){
        Exercise result = exerciseRepository.findByExerciseId(exerciseDTO.getExerciseId());
        if (result == null) {
            throw new IllegalArgumentException("There is no exercise with id = " + exerciseDTO.getExerciseId());
        }
        if (!result.getCreator().getUserId().equals(exerciseDTO.getCreatorId())
                || !result.getIsPublic().equals(exerciseDTO.getIsPublic())
                || !result.getGifName().equals(exerciseDTO.getGifName())
                || !result.getTitle().equals(exerciseDTO.getTitle())
                /*|| !result.getCountdownInSeconds().equals(exerciseDTO.getCountdownInSeconds())*/) {
            throw new IllegalArgumentException("Given information doesn't match existing information (Exercise with id " + exerciseDTO.getExerciseId() + ")");
        }
        return result;
    }

    public Exercise toEntity(ExerciseCreationFormDTO creationFormDTO){
        Exercise result = new Exercise();
        result.setCreator(userRepository.findByUserId(creationFormDTO.getCreatorId()));
        result.setGifName(StringUtils.cleanPath(creationFormDTO.getGif().getOriginalFilename()));
        result.setTitle(creationFormDTO.getTitle());
        result.setIsPublic(creationFormDTO.getIsPublic());
        return result;
    }

    public List<ExerciseDTO> toDTOs(List<Exercise> exercises){
        List<ExerciseDTO> result = new ArrayList<>();
        for (Exercise exercise:
                exercises) {
            result.add(toDTO(exercise));
        }
        return result;
    }

    public List<Exercise> toEntities(List<ExerciseDTO> exercises){
        List<Exercise> result = new ArrayList<>();
        for (ExerciseDTO exerciseDTO:
                exercises) {
            result.add(toEntity(exerciseDTO));
        }
        return result;
    }
}
