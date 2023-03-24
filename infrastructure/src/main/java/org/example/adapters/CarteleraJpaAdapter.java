package org.example.adapters;

import org.example.entity.Cartelera;
import org.example.mappers.CarteleraMapper;
import org.example.repository.CarteleraRepository;
import org.exemple.data.CarteleraDTO;
import org.exemple.ports.spi.CarteleraPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CarteleraJpaAdapter implements CarteleraPersistencePort {
    @Autowired
    private CarteleraRepository carteleraRepository;
    
    @Override
    public CarteleraDTO addCartelera(CarteleraDTO asientoDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Cartelera postRequest = CarteleraMapper.INSTANCE.carteleraToCarteleraDto(asientoDto);
        Cartelera productoSave = carteleraRepository.save(postRequest);
        CarteleraDTO retornCarteleraDto = CarteleraMapper.INSTANCE.carteleraDTOToCartelera(productoSave);
        return retornCarteleraDto;
    }

    @Override
    public CarteleraDTO updateCartelera(CarteleraDTO asientoDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Cartelera postRequest = CarteleraMapper.INSTANCE.carteleraToCarteleraDto(asientoDto);
        Cartelera productoSave = carteleraRepository.save(postRequest);
        CarteleraDTO retornCarteleraDto = CarteleraMapper.INSTANCE.carteleraDTOToCartelera(productoSave);
        return retornCarteleraDto;

    }

    @Override
    public void deleteCartelera(Integer id) {
            carteleraRepository.deleteById(id);
    }

    @Override
    public List<CarteleraDTO> getCarteleras() {
        List<Cartelera> listCarteleras = carteleraRepository.findAll();
        return CarteleraMapper.INSTANCE.carteleraDtoListToCarteleraList(listCarteleras);

    }

    @Override
    public CarteleraDTO getCarteleraDtoById(Integer id) {
        Optional<Cartelera> carteleraId = carteleraRepository.findById(id);
        if (carteleraId.isPresent()) {
            return CarteleraMapper.INSTANCE.carteleraDTOToCartelera(carteleraId.get());
        }
        return null;
    }
}
