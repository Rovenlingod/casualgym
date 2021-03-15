package com.rovenlin.casualgym.mappers;

import com.rovenlin.casualgym.domain.Workout;
import com.rovenlin.casualgym.dtos.WorkoutDTO;
import com.rovenlin.casualgym.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkoutMapper {

    private RoundMapper roundMapper;
    private UserRepository userRepository;

    public WorkoutMapper(RoundMapper roundMapper, UserRepository userRepository) {
        this.roundMapper = roundMapper;
        this.userRepository = userRepository;
    }

    public WorkoutDTO toDTO(Workout workout){
        WorkoutDTO result = new WorkoutDTO();
        result.setCreatorId(workout.getCreator().getUserId());
        result.setRounds(roundMapper.toDTOs(workout.getRounds()));
        return result;
    }

    public Workout toEntity(WorkoutDTO workoutDTO){
        Workout result = new Workout();
        result.setCreator(userRepository.findByUserId(workoutDTO.getCreatorId()));
        result.setRounds(roundMapper.toEntities(workoutDTO.getRounds()));
        return result;
    }

    public List<WorkoutDTO> toDTOs(List<Workout> workouts){
        List<WorkoutDTO> result = new ArrayList<>();
        for (Workout workout:
                workouts) {
            result.add(toDTO(workout));
        }
        return result;
    }

    public List<Workout> toEntities(List<WorkoutDTO> workouts){
        List<Workout> result = new ArrayList<>();
        for (WorkoutDTO workoutDTO:
                workouts) {
            result.add(toEntity(workoutDTO));
        }
        return result;
    }
}
