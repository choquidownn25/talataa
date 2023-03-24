package org.exemple.ports.api;

import org.exemple.data.EstadoDTO;
import org.exemple.data.response.EstadoDtoResponse;

import java.util.List;

public interface EstadoServicePort {
    EstadoDtoResponse addEstado(EstadoDTO clienteDto);
    EstadoDtoResponse updateEstado(EstadoDTO clienteDto);
    void deleteEstado(Integer id);
    List<EstadoDTO> getEstados();
    EstadoDtoResponse getEstadoDtoById(Integer id);
}
