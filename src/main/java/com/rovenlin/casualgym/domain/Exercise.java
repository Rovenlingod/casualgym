package com.rovenlin.casualgym.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercise")
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "exercise_id", nullable = false, unique = true)
    private Long exerciseId;

    @Column(name = "title")
    private String title;

    @Column(name = "gif_name")
    private String gifName;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "countdown")
    private Long countdownInSeconds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User creator;

    @ManyToMany(mappedBy = "exercises")
    private List<Round> rounds;

}
