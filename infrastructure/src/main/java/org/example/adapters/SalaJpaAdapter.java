package org.example.adapters;

import org.example.entity.Sala;
import org.example.mappers.SalaMapper;
import org.example.repository.SalaRepository;
import org.exemple.data.SalaDTO;
import org.exemple.ports.spi.SalaPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Primary
@Service
public class SalaJpaAdapter implements SalaPersistencePort {
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public SalaDTO addSala(SalaDTO salaDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Sala postRequest = SalaMapper.INSTANCE.INSTANCE.salaToSalaDto(salaDto);
        Sala clienteSave = salaRepository.save(postRequest);
        SalaDTO retornSalaDto = SalaMapper.INSTANCE.salaDTOToSala(clienteSave);
        return retornSalaDto;
    }

    @Override
    public SalaDTO updateSala(SalaDTO salaDto) {
        ModelMapper modelMapper = null;
        Sala postRequest = SalaMapper.INSTANCE.INSTANCE.salaToSalaDto(salaDto);
        Sala clienteSave = salaRepository.save(postRequest);
        SalaDTO retornSalaDto = SalaMapper.INSTANCE.salaDTOToSala(clienteSave);
        return retornSalaDto;
    }

    @Override
    public void deleteSala(Integer id) {
        salaRepository.deleteById(id);
    }

    @Override
    public List<SalaDTO> getSalas() {
        List<Sala> listSalas = salaRepository.findAll();
        return SalaMapper.INSTANCE.salaDtoListToSalaList(listSalas);
    }

    @Override
    public SalaDTO getSalaDTOById(Integer id) {
        Optional<Sala> salaId = salaRepository.findById(id);
        if (salaId.isPresent()) {
            return SalaMapper.INSTANCE.salaDTOToSala(salaId.get());
        }
        return null;
    }
}
