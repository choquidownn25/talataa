package org.example.mappers;

import org.example.entity.Asiento;
import org.exemple.data.AsientoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AsientoMapper {
    AsientoMapper INSTANCE = Mappers.getMapper(AsientoMapper.class);
    AsientoDTO asientoDTOToAsiento(Asiento asiento);
    Asiento asientoToAsientoDto(AsientoDTO asientoDto);
    //listado
    List<AsientoDTO> asientoDtoListToAsientoList(List<Asiento> asientoList);
    List<Asiento> asientoListToAsientoDtoList(List<AsientoDTO> asientoDtoList);

}
