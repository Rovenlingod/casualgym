package com.rovenlin.casualgym.repository;

import com.rovenlin.casualgym.domain.Exercise;
import com.rovenlin.casualgym.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise findByExerciseId(Long id);
    List<Exercise> findAllByIsPublic(Boolean isPublic);
    List<Exercise> findAllByCreatorAndIsPublic(User creator, Boolean isPublic);
}
