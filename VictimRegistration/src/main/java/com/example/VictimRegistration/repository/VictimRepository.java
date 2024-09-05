package com.example.VictimRegistration.repository;

import com.example.VictimRegistration.model.Victim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VictimRepository extends JpaRepository<Victim, Long> {
}


