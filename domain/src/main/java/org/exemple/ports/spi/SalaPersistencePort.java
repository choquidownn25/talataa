package org.exemple.ports.spi;

import org.exemple.data.SalaDTO;

import java.util.List;

public interface SalaPersistencePort {
    SalaDTO addSala(SalaDTO salaDto);
    SalaDTO updateSala(SalaDTO salaDto);
    void deleteSala(Integer id);
    List<SalaDTO> getSalas();
    SalaDTO getSalaDTOById(Integer id);
}
