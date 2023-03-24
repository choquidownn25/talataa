package org.exemple.ports.spi;

import org.exemple.data.EstadoDTO;

import java.util.List;

public interface EstadoPersistencePort {
    EstadoDTO addEstado(EstadoDTO estadoDto);
    EstadoDTO updateEstado(EstadoDTO estadoDto);
    void deleteEstado(Integer id);
    List<EstadoDTO> getEstados();
    EstadoDTO getEstadoDTOById(Integer id);
}
