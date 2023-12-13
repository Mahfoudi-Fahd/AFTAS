package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetitionService {

    public Competition save(Competition competition);
    public Competition findById(Long id);
    public Competition findByCode(String code);
    public List<Competition> findAll();
    Competition findCompetitionByCode(String code);
}
