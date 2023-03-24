package org.example.adapters;

import org.example.entity.Estado;
import org.example.entity.Pelicula;
import org.example.entity.Pelicula;
import org.example.mappers.EstadoMapper;
import org.example.mappers.PeliculaMapper;
import org.example.mappers.PeliculaMapper;
import org.example.repository.PeliculaRepository;
import org.exemple.data.PeliculaDTO;
import org.exemple.data.PeliculaDTO;
import org.exemple.ports.spi.PeliculaPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PeliculaJpaAdapter implements PeliculaPersistencePort {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public PeliculaDTO addPelicula(PeliculaDTO peliculaDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Pelicula postRequest = PeliculaMapper.INSTANCE.peliculaToPeliculaDto(peliculaDto);
        Pelicula clienteSave = peliculaRepository.save(postRequest);
        PeliculaDTO retornPeliculaDto = PeliculaMapper.INSTANCE.peliculaDTOToPelicula(clienteSave);
        return retornPeliculaDto;
    }

    @Override
    public PeliculaDTO updatePelicula(PeliculaDTO peliculaDto) {
        ModelMapper modelMapper = null;
        Pelicula postRequest = PeliculaMapper.INSTANCE.peliculaToPeliculaDto(peliculaDto);
        Pelicula clienteSave = peliculaRepository.save(postRequest);
        PeliculaDTO retornPeliculaDto = PeliculaMapper.INSTANCE.peliculaDTOToPelicula(clienteSave);
        return retornPeliculaDto;
    }

    @Override
    public void deletePelicula(Integer id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public List<PeliculaDTO> getPeliculas() {
        List<Pelicula> listPeliculas = peliculaRepository.findAll();
        return PeliculaMapper.INSTANCE.peliculaDtoListToPeliculaList(listPeliculas);
    }

    @Override
    public PeliculaDTO getPeliculaDTOById(Integer id) {
        Optional<Pelicula> estadoId = peliculaRepository.findById(id);
        if (estadoId.isPresent()) {
            return PeliculaMapper.INSTANCE.peliculaDTOToPelicula(estadoId.get());
        }
        return null;
    }
}
