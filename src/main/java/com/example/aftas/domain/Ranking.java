package com.example.aftas.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Ranking {

    @EmbeddedId
    private RankId id;

    @ManyToOne
    @MapsId("memberId")
    private Member member;

    @ManyToOne
    @MapsId("competitionId")
    private Competition competition;

    private Integer rank;

    private Integer score;

}
