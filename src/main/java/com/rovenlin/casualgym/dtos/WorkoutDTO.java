package com.rovenlin.casualgym.dtos;

import lombok.Data;

import java.util.List;

@Data
public class WorkoutDTO {
    private Long creatorId;
    private List<RoundDTO> rounds;
}
