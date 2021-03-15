package com.rovenlin.casualgym.repository;

import com.rovenlin.casualgym.domain.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Workout findByWorkoutId(Long id);
}
