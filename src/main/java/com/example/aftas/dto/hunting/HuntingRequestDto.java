package com.example.aftas.dto.hunting;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Getter
@Component
public class HuntingRequestDto {

    private Integer memberNumber;

    private String competitionCode;





}
