package org.exemple.ports.api;

import org.exemple.data.PeliculaDTO;
import org.exemple.data.response.PeliculaDtoResponse;

import java.util.List;

public interface PeliculaServicePort {
    PeliculaDtoResponse addPelicula(PeliculaDTO clienteDto);
    PeliculaDtoResponse updatePelicula(PeliculaDTO clienteDto);
    void deletePelicula(Integer id);
    List<PeliculaDTO> getPeliculas();
    PeliculaDtoResponse getPeliculaDtoById(Integer id);
}
