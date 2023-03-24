package org.example.mappers;

import org.example.entity.Sala;
import org.exemple.data.SalaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalaMapper {
    SalaMapper INSTANCE = Mappers.getMapper(SalaMapper.class);
    SalaDTO salaDTOToSala(Sala sala);
    Sala salaToSalaDto(SalaDTO salaDto);
    //listado
    List<SalaDTO> salaDtoListToSalaList(List<Sala> SalaList);
    List<Sala> salaListToSalaDtoList(List<SalaDTO> SalaDtoList);

}
