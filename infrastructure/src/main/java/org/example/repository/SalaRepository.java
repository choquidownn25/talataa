package org.example.repository;

import org.example.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
}