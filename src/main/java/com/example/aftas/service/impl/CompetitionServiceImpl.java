package com.example.aftas.service.impl;

import com.example.aftas.domain.Competition;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

   private final CompetitionRepository competitionRepository;

    @Override
    public Competition save(Competition competition) {

        // Check if a competition with the same date already exists
        if ( competitionExistsWithSameDate(competition.getDate())) {

            throw new IllegalArgumentException("A competition with the same date already exists");
        }

        String code = generateCode(competition.getLocation(), competition.getDate());
        competition.setCompetitionCode(code);
        return competitionRepository.save(competition);
    }


    @Override
    public Competition findByCode(String code) {
        return null;
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition findCompetitionByCode(String code) {
        return competitionRepository.searchCompetitionByCompetitionCode(code);
    }

    @Override
    public Competition getCompetitionById(Long competitionId) {
        return competitionRepository.findById(competitionId).orElseThrow(() -> new IllegalArgumentException("Competition with id " + competitionId + " not found"));
    }


    public static String generateCode(String location, LocalDate date) {
        String locationCode = location.substring(0, Math.min(location.length(), 3)).toLowerCase();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        String formattedDate = date.format(dateFormatter);

        return locationCode + "-" + formattedDate;
    }


    private boolean competitionExistsWithSameDate(LocalDate date) {
        List<Competition> competitionsWithSameDate = competitionRepository.findByDate(date);

        return !competitionsWithSameDate.isEmpty();
    }
}
