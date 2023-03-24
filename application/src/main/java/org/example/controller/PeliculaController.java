package org.example.controller;

import org.exemple.data.PeliculaDTO;
import org.exemple.data.PeliculaDTO;
import org.exemple.data.response.Message;
import org.exemple.data.response.PeliculaDtoResponse;
import org.exemple.data.response.PeliculaDtoResponse;
import org.exemple.ports.api.EstadoServicePort;
import org.exemple.ports.api.PeliculaServicePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {
    @Autowired
    private PeliculaServicePort peliculaServicePort;
    @Autowired
    private EstadoServicePort estadoServicePort;
    @PostMapping("/add")
    public ResponseEntity<PeliculaDtoResponse> addPelicula(@RequestBody PeliculaDTO asientoDto) {
        PeliculaDtoResponse peliculaDtoResponse = new PeliculaDtoResponse();
        if(estadoServicePort.getEstadoDtoById(asientoDto.getIdestado().getId())== null
                || asientoDto.getIdestado().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            peliculaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(peliculaDtoResponse, HttpStatus.BAD_REQUEST);
        }
        peliculaDtoResponse = peliculaServicePort.addPelicula(asientoDto);
        if (peliculaDtoResponse != null)
            return  new ResponseEntity<PeliculaDtoResponse>(peliculaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<PeliculaDtoResponse>(peliculaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/update")
    public ResponseEntity<PeliculaDtoResponse> updatePelicula(@RequestBody PeliculaDTO asientoDto) {
        PeliculaDtoResponse peliculaDtoResponse = new PeliculaDtoResponse();
        if(estadoServicePort.getEstadoDtoById(asientoDto.getIdestado().getId())== null
                || asientoDto.getIdestado().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            peliculaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(peliculaDtoResponse, HttpStatus.BAD_REQUEST);
        }
        peliculaDtoResponse = peliculaServicePort.updatePelicula(asientoDto);
        if (peliculaDtoResponse != null)
            return  new ResponseEntity<PeliculaDtoResponse>(peliculaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<PeliculaDtoResponse>(peliculaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get")
    public ResponseEntity<List<PeliculaDTO>> getPeliculaDto() {
        List<PeliculaDTO> peliculaDTOS = new ArrayList<>();
        peliculaDTOS = peliculaServicePort.getPeliculas();
        if (peliculaDTOS != null)
            return  new ResponseEntity<List<PeliculaDTO>>(peliculaDTOS, HttpStatus.OK);
        else
            return   new ResponseEntity<List<PeliculaDTO>>(peliculaDTOS, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<PeliculaDtoResponse> getPeliculaByID(@PathVariable Integer id)  {
        PeliculaDtoResponse peliculaDtoResponse = new PeliculaDtoResponse();
        peliculaDtoResponse = peliculaServicePort.getPeliculaDtoById(id);
        if (peliculaDtoResponse != null)
            return  new ResponseEntity<PeliculaDtoResponse>(peliculaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<PeliculaDtoResponse>(peliculaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete/{id}")
    public void deletePeliculaByID(@PathVariable Integer id) {
        peliculaServicePort.deletePelicula(id);
    }

}
