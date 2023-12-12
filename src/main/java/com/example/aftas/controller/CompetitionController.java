package com.example.aftas.controller;

import com.example.aftas.domain.Competition;
import com.example.aftas.dto.competition.CompetitionRequestDto;
import com.example.aftas.dto.competition.CompetitionResponseDto;
import com.example.aftas.response.ResponseMessage;
import com.example.aftas.service.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competitions")
@RequiredArgsConstructor
public class CompetitionController {

  private final   CompetitionService competitionService;

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> save(@Valid @RequestBody CompetitionRequestDto competitionRequestDto) {

        Competition competition = competitionRequestDto.toCompetition();

          competitionService.save(competition);
        CompetitionResponseDto competitionResponseDto = CompetitionResponseDto.fromCompetition(competition);

        return ResponseMessage.created(     competitionResponseDto, "Competition created successfully");

    }

    @GetMapping("/{id}")
    public Competition findById(Long id) {
        return competitionService.findById(id);
    }

    @GetMapping("/{code}")
    public Competition findByCode(String code) {
        return competitionService.findByCode(code);
    }

    @GetMapping("/all")
    public List<Competition> findAll() {
        return competitionService.findAll();
    }
}
