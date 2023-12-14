package com.example.aftas.service;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.RankId;
import com.example.aftas.domain.Ranking;
import com.example.aftas.dto.ranking.RankingRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface RankingService {
    public Ranking save(RankingRequestDto rankingRequestDto);
    public Ranking findByRankId(Long id);
    public Ranking findByCompetitionCodeAndMemberNumber(String code, Integer number);
    public Ranking findByCompetitionAndMember(Competition competition, Member member);

    void changeRankingScore(Competition competition, Member member, Integer fishScore);
}
