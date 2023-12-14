package com.example.aftas.service.impl;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.RankId;
import com.example.aftas.domain.Ranking;
import com.example.aftas.dto.ranking.RankingRequestDto;
import com.example.aftas.repository.RankingRepository;
import com.example.aftas.service.CompetitionService;
import com.example.aftas.service.MemberService;
import com.example.aftas.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RankingServiceImpl implements RankingService {

    private final RankingRepository rankingRepository;
    private final MemberService memberService;
    private final CompetitionService competitionService;

    @Override
    public Ranking save(RankingRequestDto rankingRequestDto) {
        Member member = memberService.findMemberByNumber(rankingRequestDto.getMemberNumber());
        Competition competition = competitionService.findCompetitionByCode(rankingRequestDto.getCompetitionCode());
        if (findByCompetitionAndMember(competition, member) != null) {
            throw new IllegalArgumentException("Ranking already exists");
        }
        Ranking ranking = Ranking.builder()
                .id(RankId.builder()
                        .memberId(member.getId())
                        .competitionId(competition.getId())
                        .build())
                .member(member)
                .competition(competition)
                .score(0)
                .rank(0)
                .build();
        return rankingRepository.save(ranking);
    }

    @Override
    public Ranking findByRankId(Long id) {
        return null;
    }

    @Override
    public Ranking findByCompetitionCodeAndMemberNumber(String code, Integer number) {
        return null;
    }

    @Override
    public Ranking findByCompetitionAndMember(Competition competition, Member member) {
        return rankingRepository.findByCompetitionAndMember(competition, member);
    }
    @Override
    public void changeRankingScore(Competition competition, Member member, Integer fishScore) {
        Ranking ranking = rankingRepository.findByCompetitionAndMember(competition,member);
        ranking.setScore(ranking.getScore() + fishScore);
        rankingRepository.save(ranking);
    }
}
