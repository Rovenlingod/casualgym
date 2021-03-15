package com.rovenlin.casualgym.mappers;

import com.rovenlin.casualgym.domain.Round;
import com.rovenlin.casualgym.dtos.RoundDTO;
import com.rovenlin.casualgym.repository.WorkoutRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoundMapper {

    private ExerciseMapper exerciseMapper;
    private WorkoutRepository workoutRepository;

    public RoundMapper(ExerciseMapper exerciseMapper, WorkoutRepository workoutRepository) {
        this.exerciseMapper = exerciseMapper;
        this.workoutRepository = workoutRepository;
    }

    public RoundDTO toDTO(Round round){
        RoundDTO result = new RoundDTO();
        result.setRoundType(round.getRoundType());
        result.setExercises(exerciseMapper.toDTOs(round.getExercises()));
        result.setWorkoutId(round.getWorkout().getWorkoutId());
        return result;
    }

    public Round toEntity(RoundDTO roundDTO){
        Round result = new Round();
        result.setExercises(exerciseMapper.toEntities(roundDTO.getExercises()));
        result.setRoundType(roundDTO.getRoundType());
        result.setWorkout(workoutRepository.findByWorkoutId(roundDTO.getWorkoutId()));
        return result;
    }

    public List<RoundDTO> toDTOs(List<Round> rounds){
        List<RoundDTO> result = new ArrayList<>();
        for (Round round:
                rounds) {
            result.add(toDTO(round));
        }
        return result;
    }

    public List<Round> toEntities(List<RoundDTO> rounds){
        List<Round> result = new ArrayList<>();
        for (RoundDTO roundDTO:
                rounds) {
            result.add(toEntity(roundDTO));
        }
        return result;
    }
}
