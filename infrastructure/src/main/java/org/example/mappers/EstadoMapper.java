package org.example.mappers;

import org.example.entity.Estado;
import org.exemple.data.EstadoDTO;
import org.exemple.data.EstadoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EstadoMapper {
    EstadoMapper INSTANCE = Mappers.getMapper(EstadoMapper.class);
    EstadoDTO estadoDTOToEstado(Estado product);
    Estado estadoToEstadoDto(EstadoDTO productoDto);
    //listado
    List<EstadoDTO> estadoDtoListToEstadoList(List<Estado> estadoList);
    List<Estado> estadoListToEstadoDtoList(List<EstadoDTO> estadoDtoList);

}
