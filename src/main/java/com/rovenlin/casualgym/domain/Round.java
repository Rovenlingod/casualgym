package com.rovenlin.casualgym.domain;

import com.rovenlin.casualgym.enums.RoundType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "round")
@Data
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "round_id", nullable = false, unique = true)
    private Long roundId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Enumerated(EnumType.STRING)
    @Column(name = "round_type")
    private RoundType roundType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Round_Exercise",
            joinColumns = { @JoinColumn(name = "round_id") },
            inverseJoinColumns = { @JoinColumn(name = "exercise_id") }
    )
    private List<Exercise> exercises;

}
