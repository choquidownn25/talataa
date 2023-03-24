package org.exemple.ports.api;

import org.exemple.data.CarteleraDTO;
import org.exemple.data.response.CarteleraDtoResponse;

import java.util.List;

public interface CarteleraServicePort {
    CarteleraDtoResponse addCartelera(CarteleraDTO carteleraDto);
    CarteleraDtoResponse updateCartelera(CarteleraDTO carteleraDto);
    void deleteCartelera(Integer id);
    List<CarteleraDTO> getCarteleras();
    CarteleraDtoResponse getCarteleraDtoById(Integer id);
}
