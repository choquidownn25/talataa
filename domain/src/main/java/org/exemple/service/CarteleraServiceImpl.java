package org.exemple.service;

import org.exemple.data.CarteleraDTO;
import org.exemple.data.response.CarteleraDtoResponse;
import org.exemple.data.response.Message;
import org.exemple.ports.api.CarteleraServicePort;
import org.exemple.ports.spi.CarteleraPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarteleraServiceImpl implements CarteleraServicePort {

    private CarteleraPersistencePort carteleraPersistencePort;
    @Autowired
    public CarteleraServiceImpl(CarteleraPersistencePort carteleraPersistencePort) {
        this.carteleraPersistencePort = carteleraPersistencePort;
    }
    
    @Override
    public CarteleraDtoResponse addCartelera(CarteleraDTO carteleraDto) {
        CarteleraDtoResponse response = new CarteleraDtoResponse();
        CarteleraDTO asiento = null;
        List<CarteleraDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = carteleraPersistencePort.addCartelera(carteleraDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVECartelera.getName());
            message.setCode( StringResponse.ErrorSAVECartelera.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListCarteleraDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public CarteleraDtoResponse updateCartelera(CarteleraDTO carteleraDto) {
        CarteleraDtoResponse response = new CarteleraDtoResponse();
        CarteleraDTO asiento = null;
        List<CarteleraDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = carteleraPersistencePort.updateCartelera(carteleraDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVECartelera.getName());
            message.setCode( StringResponse.ErrorSAVECartelera.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListCarteleraDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public void deleteCartelera(Integer id) {
        carteleraPersistencePort.deleteCartelera(id);
    }

    @Override
    public List<CarteleraDTO> getCarteleras() {
        return carteleraPersistencePort.getCarteleras();
    }

    @Override
    public CarteleraDtoResponse getCarteleraDtoById(Integer id) {
        CarteleraDtoResponse response = new CarteleraDtoResponse();
        CarteleraDTO asiento = null;
        List<CarteleraDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = carteleraPersistencePort.getCarteleraDtoById(id);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorNOHAYASIENTO.getName());
            message.setCode( StringResponse.ErrorNOHAYASIENTO.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListCarteleraDTO(listPrestamoDTO);
        }
        return response;
    }
}
