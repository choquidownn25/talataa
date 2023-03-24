package org.example.controller;

import org.exemple.data.CarteleraDTO;
import org.exemple.data.response.CarteleraDtoResponse;
import org.exemple.data.response.Message;
import org.exemple.ports.api.CarteleraServicePort;
import org.exemple.ports.api.EstadoServicePort;
import org.exemple.ports.api.PeliculaServicePort;
import org.exemple.ports.api.SalaServicePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cartelera")
public class CarteleraController {
    @Autowired
    private CarteleraServicePort carteleraServicePort;
    @Autowired
    private PeliculaServicePort peliculaServicePort;
    @Autowired
    private SalaServicePort salaServicePort;
    @Autowired
    private EstadoServicePort estadoServicePort;

    @PostMapping("/add")
    public ResponseEntity<CarteleraDtoResponse> addCartelera(@RequestBody CarteleraDTO carteleraDto) {
        CarteleraDtoResponse carteleraDtoResponse = new CarteleraDtoResponse();
        if(estadoServicePort.getEstadoDtoById(carteleraDto.getIdestado().getId())== null
                || carteleraDto.getIdestado().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            carteleraDtoResponse.setMessage(message);
            return   new ResponseEntity<>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(salaServicePort.getSalaDtoById(carteleraDto.getIdsala().getId())== null
                || carteleraDto.getIdsala().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYSala.getName());
            message.setCode( StringResponse.ErrorNOHAYSala.getCode());
            carteleraDtoResponse.setMessage(message);
            return   new ResponseEntity<>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(peliculaServicePort.getPeliculaDtoById(carteleraDto.getIdpelicula().getId()) == null
                || carteleraDto.getIdsala().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYPelicula.getName());
            message.setCode( StringResponse.ErrorNOHAYPelicula.getCode());
            carteleraDtoResponse.setMessage(message);
            return   new ResponseEntity<>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);
        }

        carteleraDtoResponse = carteleraServicePort.addCartelera(carteleraDto);
        if (carteleraDtoResponse != null)
            return  new ResponseEntity<CarteleraDtoResponse>(carteleraDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<CarteleraDtoResponse>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @PostMapping("/update")
    public ResponseEntity<CarteleraDtoResponse> updateCartelera(@RequestBody CarteleraDTO carteleraDto) {
        CarteleraDtoResponse carteleraDtoResponse = new CarteleraDtoResponse();
        if(estadoServicePort.getEstadoDtoById(carteleraDto.getIdestado().getId())== null
                || carteleraDto.getIdestado().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            carteleraDtoResponse.setMessage(message);
            return   new ResponseEntity<>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(salaServicePort.getSalaDtoById(carteleraDto.getIdsala().getId())== null
                || carteleraDto.getIdsala().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYSala.getName());
            message.setCode( StringResponse.ErrorNOHAYSala.getCode());
            carteleraDtoResponse.setMessage(message);
            return   new ResponseEntity<>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(peliculaServicePort.getPeliculaDtoById(carteleraDto.getIdpelicula().getId()) == null
                || carteleraDto.getIdsala().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYPelicula.getName());
            message.setCode( StringResponse.ErrorNOHAYPelicula.getCode());
            carteleraDtoResponse.setMessage(message);
            return   new ResponseEntity<>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);
        }
        carteleraDtoResponse = carteleraServicePort.updateCartelera(carteleraDto);
        if (carteleraDtoResponse != null)
            return  new ResponseEntity<CarteleraDtoResponse>(carteleraDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<CarteleraDtoResponse>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/get")
    public ResponseEntity<List<CarteleraDTO>> getCarteleraDto() {
        List<CarteleraDTO> carteleraDTOResponse = new ArrayList<>();
        carteleraDTOResponse = carteleraServicePort.getCarteleras();
        if (carteleraDTOResponse != null)
            return  new ResponseEntity<List<CarteleraDTO>>(carteleraDTOResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<List<CarteleraDTO>>(carteleraDTOResponse, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CarteleraDtoResponse> getCarteleraByID(@PathVariable Integer id)  {
        CarteleraDtoResponse carteleraDtoResponse = new CarteleraDtoResponse();
        carteleraDtoResponse = carteleraServicePort.getCarteleraDtoById(id);
        if (carteleraDtoResponse != null)
            return  new ResponseEntity<CarteleraDtoResponse>(carteleraDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<CarteleraDtoResponse>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteCarteleraByID(@PathVariable Integer id) {
        carteleraServicePort.deleteCartelera(id);
    }

}
