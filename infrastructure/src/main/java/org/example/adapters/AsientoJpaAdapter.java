package org.example.adapters;

import org.example.entity.Asiento;
import org.example.mappers.AsientoMapper;
import org.example.repository.AsientoRepository;
import org.exemple.data.AsientoDTO;
import org.exemple.ports.spi.AsientoPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsientoJpaAdapter implements AsientoPersistencePort {
    @Autowired
    private AsientoRepository asientoRepository;
    @Override
    public AsientoDTO addAsiento(AsientoDTO asientoDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Asiento postRequest = AsientoMapper.INSTANCE.asientoToAsientoDto(asientoDto);
        Asiento productoSave = asientoRepository.save(postRequest);
        AsientoDTO retornAsientoDto = AsientoMapper.INSTANCE.asientoDTOToAsiento(productoSave);
        return retornAsientoDto;
    }

    @Override
    public AsientoDTO updateAsiento(AsientoDTO asientoDto) {
        ModelMapper modelMapper = null;
        Asiento postRequest = AsientoMapper.INSTANCE.asientoToAsientoDto(asientoDto);
        Asiento productoSave = asientoRepository.save(postRequest);
        AsientoDTO retornAsientoDto = AsientoMapper.INSTANCE.asientoDTOToAsiento(productoSave);
        return retornAsientoDto;
    }

    @Override
    public void deleteAsiento(Integer id) {
        asientoRepository.deleteById(id);
    }

    @Override
    public List<AsientoDTO> getAsientos() {
        List<Asiento> listAsientos = asientoRepository.findAll();
        return AsientoMapper.INSTANCE.asientoDtoListToAsientoList(listAsientos);

    }

    @Override
    public AsientoDTO getAsientoDtoById(Integer id) {
        //Encuentra un registro
        Optional<Asiento> productoId = asientoRepository.findById(id);
        if (productoId.isPresent()) {
            return AsientoMapper.INSTANCE.asientoDTOToAsiento(productoId.get());
        }
        return null;
    }
}
