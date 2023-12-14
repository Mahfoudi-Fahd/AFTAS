package com.example.aftas.service.impl;

import com.example.aftas.domain.Fish;
import com.example.aftas.repository.FishRepository;
import com.example.aftas.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {
    private final FishRepository fishRepository;

    @Override
    public void saveFish() {

    }

    @Override
    public void updateFish() {

    }

    @Override
    public void deleteFish() {

    }

    @Override
    public Fish getFishById(Long fishId) {
        return fishRepository.findById(fishId).orElseThrow(() -> new IllegalArgumentException("Fish not found"));
    }
}
