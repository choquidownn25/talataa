package org.exemple.ports.spi;

import org.exemple.data.CarteleraDTO;

import java.util.List;

public interface CarteleraPersistencePort {
    CarteleraDTO addCartelera(CarteleraDTO asientoDto);
    CarteleraDTO updateCartelera(CarteleraDTO asientoDto);
    void deleteCartelera(Integer id);
    List<CarteleraDTO> getCarteleras();
    CarteleraDTO getCarteleraDtoById(Integer id);
}
