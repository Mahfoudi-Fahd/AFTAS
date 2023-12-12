package com.example.aftas.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Double averageWeight;

    @ManyToOne
    private Level level;

    @ManyToOne
    @JoinColumn(name = "hunting_id")
    private Hunting hunting;

}
