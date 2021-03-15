package com.rovenlin.casualgym.repository;

import com.rovenlin.casualgym.domain.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
