package org.example.mappers;

import org.example.entity.Cartelera;
import org.exemple.data.CarteleraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CarteleraMapper {
    CarteleraMapper INSTANCE = Mappers.getMapper(CarteleraMapper.class);
    CarteleraDTO carteleraDTOToCartelera(Cartelera cartelera);
    Cartelera carteleraToCarteleraDto(CarteleraDTO carteleraDto);
    //listado
    List<CarteleraDTO> carteleraDtoListToCarteleraList(List<Cartelera> carteleraList);
    List<Cartelera> carteleraListToCarteleraDtoList(List<CarteleraDTO> carteleraDtoList);

}
