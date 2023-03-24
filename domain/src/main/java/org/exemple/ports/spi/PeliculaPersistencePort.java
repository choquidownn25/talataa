package org.exemple.ports.spi;

import org.exemple.data.PeliculaDTO;

import java.util.List;

public interface PeliculaPersistencePort {
    PeliculaDTO addPelicula(PeliculaDTO peliculaDto);
    PeliculaDTO updatePelicula(PeliculaDTO peliculaDto);
    void deletePelicula(Integer id);
    List<PeliculaDTO> getPeliculas();
    PeliculaDTO getPeliculaDTOById(Integer id);
}
