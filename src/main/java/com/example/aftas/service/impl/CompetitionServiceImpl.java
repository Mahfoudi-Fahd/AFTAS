package com.example.aftas.service.impl;

import com.example.aftas.domain.Competition;
import com.example.aftas.repository.CompetitionRepository;
import com.example.aftas.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

   private final CompetitionRepository competitionRepository;

    @Override
    public Competition save(Competition competition) {

        String code = generateCode(competition.getLocation(), competition.getDate());
        competition.setCompetitionCode(code);
        return competitionRepository.save(competition);
    }

    @Override
    public Competition findById(Long id) {
        return null;
    }

    @Override
    public Competition findByCode(String code) {
        return null;
    }

    @Override
    public List<Competition> findAll() {
        return null;
    }


    public static String generateCode(String location, LocalDate date) {
        String locationCode = location.substring(0, 3).toLowerCase();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yy-MM-dd");
        String formattedDate = dateFormatter.format(date);

        return locationCode + "-" + formattedDate;
    }
}
