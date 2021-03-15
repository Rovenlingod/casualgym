package com.rovenlin.casualgym.mappers;

import com.rovenlin.casualgym.domain.Exercise;
import com.rovenlin.casualgym.dtos.ExerciseDTO;
import com.rovenlin.casualgym.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseMapper {

    private UserRepository userRepository;

    public ExerciseMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ExerciseDTO toDTO(Exercise exercise){
        ExerciseDTO result = new ExerciseDTO();
        result.setCreatorId(exercise.getCreator().getUserId());
        result.setGifName(exercise.getGifName());
        result.setTitle(exercise.getTitle());
        return result;
    }

    public Exercise toEntity(ExerciseDTO exerciseDTO){
        Exercise result = new Exercise();
        result.setCreator(userRepository.findByUserId(exerciseDTO.getCreatorId()));
        result.setGifName(exerciseDTO.getGifName());
        result.setTitle(exerciseDTO.getTitle());
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
