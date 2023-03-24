package org.exemple.ports.api;

import org.exemple.data.SalaDTO;
import org.exemple.data.response.SalaDtoResponse;

import java.util.List;

public interface SalaServicePort {
    SalaDtoResponse addSala(SalaDTO clienteDto);
    SalaDtoResponse updateSala(SalaDTO clienteDto);
    void deleteSala(Integer id);
    List<SalaDTO> getSalas();
    SalaDtoResponse getSalaDtoById(Integer id);
}
