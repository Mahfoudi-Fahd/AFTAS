package com.example.aftas.dto.competition;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Ranking;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompetitionResponseDto {

        private String competitionCode;

        private LocalDate date;

        private LocalDateTime startTime;

        private LocalDateTime endTime;

        private Integer numberOfParticipants;

        private  String Location;

        private Double amount;

        private List<Ranking> ranking;


      public static CompetitionResponseDto fromCompetition(Competition competition){

          return new CompetitionResponseDto(
                  competition.getCompetitionCode(),
                  competition.getDate(),
                  competition.getStartTime(),
                  competition.getEndTime(),
                  competition.getNumberOfParticipants(),
                  competition.getLocation(),
                  competition.getAmount(),
                  competition.getRanking()
          );

      }






    }


