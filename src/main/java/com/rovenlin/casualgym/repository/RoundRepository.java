package com.rovenlin.casualgym.repository;

import com.rovenlin.casualgym.domain.Round;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundRepository extends JpaRepository<Round, Long> {
    Round findByRoundId(Long id);
}
