package com.example.VictimRegistration.service;

import com.example.VictimRegistration.model.Victim;
import com.example.VictimRegistration.repository.VictimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VictimService {

    private final VictimRepository victimRepository;

    @Autowired
    public VictimService(VictimRepository victimRepository) {
        this.victimRepository = victimRepository;
    }

    public void registerVictim(Victim victim) {
        try {
            victimRepository.save(victim);  // Salvează datele victimei în baza de date
        } catch (Exception e) {

            System.err.println("Error occurred while registering the victim: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("An error occurred while registering the victim: " + e.getMessage());
        }
    }
}

