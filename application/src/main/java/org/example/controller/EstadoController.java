package org.example.controller;

import org.exemple.data.EstadoDTO;
import org.exemple.data.response.EstadoDtoResponse;
import org.exemple.ports.api.EstadoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {
    @Autowired
    private EstadoServicePort estadoServicePort;
    @PostMapping("/add")
    public ResponseEntity<EstadoDtoResponse> addEstado(@RequestBody EstadoDTO asientoDto) {
        EstadoDtoResponse asientoDtoDtoResponse = new EstadoDtoResponse();
        asientoDtoDtoResponse = estadoServicePort.addEstado(asientoDto);
        if (asientoDtoDtoResponse != null)
            return  new ResponseEntity<EstadoDtoResponse>(asientoDtoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<EstadoDtoResponse>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/update")
    public ResponseEntity<EstadoDtoResponse> updateEstado(@RequestBody EstadoDTO asientoDto) {
        EstadoDtoResponse asientoDtoDtoResponse = new EstadoDtoResponse();
        asientoDtoDtoResponse = estadoServicePort.updateEstado(asientoDto);
        if (asientoDtoDtoResponse != null)
            return  new ResponseEntity<EstadoDtoResponse>(asientoDtoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<EstadoDtoResponse>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get")
    public ResponseEntity<List<EstadoDTO>> getEstadoDto() {
        List<EstadoDTO> carteleraDTOResponse = new ArrayList<>();
        carteleraDTOResponse = estadoServicePort.getEstados();
        if (carteleraDTOResponse != null)
            return  new ResponseEntity<List<EstadoDTO>>(carteleraDTOResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<List<EstadoDTO>>(carteleraDTOResponse, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<EstadoDtoResponse> getEstadoByID(@PathVariable Integer id)  {
        EstadoDtoResponse carteleraDtoResponse = new EstadoDtoResponse();
        carteleraDtoResponse = estadoServicePort.getEstadoDtoById(id);
        if (carteleraDtoResponse != null)
            return  new ResponseEntity<EstadoDtoResponse>(carteleraDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<EstadoDtoResponse>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteEstadoByID(@PathVariable Integer id) {
        estadoServicePort.deleteEstado(id);
    }
}
