package com.rovenlin.casualgym.service;

import com.rovenlin.casualgym.domain.Round;
import com.rovenlin.casualgym.domain.Workout;
import com.rovenlin.casualgym.dtos.RoundDTO;
import com.rovenlin.casualgym.dtos.WorkoutDTO;
import com.rovenlin.casualgym.mappers.WorkoutMapper;
import com.rovenlin.casualgym.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    private WorkoutRepository workoutRepository;
    private WorkoutMapper workoutMapper;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, WorkoutMapper workoutMapper) {
        this.workoutRepository = workoutRepository;
        this.workoutMapper = workoutMapper;
    }

    @Override
    public WorkoutDTO createWorkout(WorkoutDTO workoutDTO) {
        Workout workoutEntity = workoutMapper.toEntity(workoutDTO);
        for (Round round :
                workoutEntity.getRounds()) {
            round.setWorkout(workoutEntity);
        }
        Workout createdWorkout = workoutRepository.save(workoutEntity);
        return workoutMapper.toDTO(createdWorkout);
    }

    @Override
    public WorkoutDTO findWorkoutById(Long id) {
        return workoutMapper.toDTO(workoutRepository.findByWorkoutId(id));
    }
}
