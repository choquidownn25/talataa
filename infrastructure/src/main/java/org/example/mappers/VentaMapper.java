package org.example.mappers;

import org.example.entity.Venta;
import org.exemple.data.VentaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VentaMapper {
    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);
    VentaDTO ventaDTOToVenta(Venta venta);
    Venta ventaToVentaDto(VentaDTO ventaDto);
    //listado
    List<VentaDTO> ventaDtoListToVentaList(List<Venta> VentaList);
    List<Venta> ventaListToVentaDtoList(List<VentaDTO> VentaDtoList);

}
