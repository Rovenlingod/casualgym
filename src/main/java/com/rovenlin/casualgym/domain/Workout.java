package com.rovenlin.casualgym.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "workout")
@Data
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "workout_id", nullable = false, unique = true)
    private Long workoutId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToMany(mappedBy = "subscribedTo")
    private Set<User> subscribers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Round> rounds;
}
