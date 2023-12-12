package com.example.aftas.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String numberOfFish;

    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "hunting")
    private List<Fish> fishList;


}
