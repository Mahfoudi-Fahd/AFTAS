package com.example.aftas.service;

import com.example.aftas.domain.Fish;
import org.springframework.stereotype.Service;

@Service
public interface FishService {
    public void saveFish();
    public void updateFish();
    public void deleteFish();
    public Fish getFishById(Long fishId);
}
