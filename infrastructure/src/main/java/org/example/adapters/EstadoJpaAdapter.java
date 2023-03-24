package org.example.adapters;

import org.example.entity.Estado;
import org.example.mappers.EstadoMapper;
import org.example.repository.EstadoRepository;
import org.exemple.data.EstadoDTO;
import org.exemple.ports.spi.EstadoPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoJpaAdapter implements EstadoPersistencePort {
    @Autowired
    private EstadoRepository estadoRepository;
    @Override
    public EstadoDTO addEstado(EstadoDTO estadoDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Estado postRequest = EstadoMapper.INSTANCE.estadoToEstadoDto(estadoDto);
        Estado clienteSave = estadoRepository.save(postRequest);
        EstadoDTO retornEstadoDto = EstadoMapper.INSTANCE.estadoDTOToEstado(clienteSave);
        return retornEstadoDto;
    }

    @Override
    public EstadoDTO updateEstado(EstadoDTO estadoDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Estado postRequest = EstadoMapper.INSTANCE.estadoToEstadoDto(estadoDto);
        Estado clienteSave = estadoRepository.save(postRequest);
        EstadoDTO retornEstadoDto = EstadoMapper.INSTANCE.estadoDTOToEstado(clienteSave);
        return retornEstadoDto;

    }

    @Override
    public void deleteEstado(Integer id) {
        estadoRepository.deleteById(id);
    }

    @Override
    public List<EstadoDTO> getEstados() {
        List<Estado> listEstados = estadoRepository.findAll();
        return EstadoMapper.INSTANCE.estadoDtoListToEstadoList(listEstados);

    }

    @Override
    public EstadoDTO getEstadoDTOById(Integer id) {
        //Encuentra un registro
        Optional<Estado> estadoId = estadoRepository.findById(id);
        if (estadoId.isPresent()) {
            return EstadoMapper.INSTANCE.estadoDTOToEstado(estadoId.get());
        }
        return null;
    }
}
