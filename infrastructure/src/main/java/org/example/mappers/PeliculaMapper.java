package org.example.mappers;

import org.example.entity.Pelicula;
import org.exemple.data.PeliculaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeliculaMapper {
    PeliculaMapper INSTANCE = Mappers.getMapper(PeliculaMapper.class);
    PeliculaDTO peliculaDTOToPelicula(Pelicula product);
    Pelicula peliculaToPeliculaDto(PeliculaDTO productoDto);
    //listado
    List<PeliculaDTO> peliculaDtoListToPeliculaList(List<Pelicula> PeliculaList);
    List<Pelicula> peliculaListToPeliculaDtoList(List<PeliculaDTO> PeliculaDtoList);

}
