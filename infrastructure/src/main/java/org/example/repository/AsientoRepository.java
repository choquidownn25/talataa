package org.example.repository;

import org.example.entity.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsientoRepository extends JpaRepository<Asiento, Integer> {
}