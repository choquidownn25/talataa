package org.example.controller;

import org.exemple.data.AsientoDTO;
import org.exemple.data.response.AsientoDtoResponse;
import org.exemple.data.response.Message;
import org.exemple.ports.api.AsientoServicePort;
import org.exemple.ports.api.EstadoServicePort;
import org.exemple.ports.api.SalaServicePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asiento")
public class AsientoController {
    @Autowired
    private AsientoServicePort asientoServicePort;
    @Autowired
    private SalaServicePort salaServicePort;
    @Autowired
    private EstadoServicePort estadoServicePort;
    @PostMapping("/add")
    public ResponseEntity<AsientoDtoResponse> addAsiento(@RequestBody AsientoDTO asientoDto) {
        AsientoDtoResponse asientoDtoDtoResponse = new AsientoDtoResponse();
        asientoDtoDtoResponse = asientoServicePort.addAsiento(asientoDto);
        if (asientoDtoDtoResponse != null)
            return  new ResponseEntity<AsientoDtoResponse>(asientoDtoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<AsientoDtoResponse>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @PostMapping("/update")
    public ResponseEntity<AsientoDtoResponse> updateAsiento(@RequestBody AsientoDTO asientoDto) {
        AsientoDtoResponse asientoDtoDtoResponse = new AsientoDtoResponse();

        if(salaServicePort.getSalaDtoById(asientoDto.getIdsala().getId())== null
                || asientoDto.getIdsala().getId()<=0){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYASIENTO.getName());
            message.setCode( StringResponse.ErrorNOHAYASIENTO.getCode());
            asientoDtoDtoResponse.setMessage(message);
            return   new ResponseEntity<>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);
        }

        if(estadoServicePort.getEstadoDtoById(asientoDto.getIdestado().getId())== null
                || asientoDto.getIdestado().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            asientoDtoDtoResponse.setMessage(message);
            return   new ResponseEntity<>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);
        }

        asientoDtoDtoResponse = asientoServicePort.updateAsiento(asientoDto);
        if (asientoDtoDtoResponse != null)
            return  new ResponseEntity<AsientoDtoResponse>(asientoDtoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<AsientoDtoResponse>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/get")
    public  ResponseEntity<List<AsientoDTO>> getAsientos() {
        List<AsientoDTO> productoDtoResponse = new ArrayList<>();
        productoDtoResponse = asientoServicePort.getAsientos();
        if (productoDtoResponse != null)
            return  new ResponseEntity<List<AsientoDTO>>(productoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<List<AsientoDTO>>(productoDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<AsientoDtoResponse> getAsientoByID(@PathVariable Integer id)  {
        AsientoDtoResponse asientoDtoDtoResponse = new AsientoDtoResponse();
        asientoDtoDtoResponse = asientoServicePort.getAsientoDtoById(id);
        if (asientoDtoDtoResponse != null)
            return  new ResponseEntity<AsientoDtoResponse>(asientoDtoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<AsientoDtoResponse>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteAsientoByID(@PathVariable Integer id) {
        asientoServicePort.deleteAsiento(id);
    }

}
