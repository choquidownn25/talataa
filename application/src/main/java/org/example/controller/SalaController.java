package org.example.controller;

import org.exemple.data.SalaDTO;
import org.exemple.data.response.SalaDtoResponse;
import org.exemple.ports.api.SalaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaController {
    @Autowired
    private SalaServicePort salaServicePort;
    @PostMapping("/add")
    public ResponseEntity<SalaDtoResponse> addSala(@RequestBody SalaDTO asientoDto) {
        SalaDtoResponse salaDtoResponse = new SalaDtoResponse();
        salaDtoResponse = salaServicePort.addSala(asientoDto);
        if (salaDtoResponse != null)
            return  new ResponseEntity<SalaDtoResponse>(salaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<SalaDtoResponse>(salaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/update")
    public ResponseEntity<SalaDtoResponse> updateSala(@RequestBody SalaDTO asientoDto) {
        SalaDtoResponse salaDtoResponse = new SalaDtoResponse();
        salaDtoResponse = salaServicePort.updateSala(asientoDto);
        if (salaDtoResponse != null)
            return  new ResponseEntity<SalaDtoResponse>(salaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<SalaDtoResponse>(salaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get")
    public ResponseEntity<List<SalaDTO>> getSalaDto() {
        List<SalaDTO> salaDTOS = new ArrayList<>();
        salaDTOS = salaServicePort.getSalas();
        if (salaDTOS != null)
            return  new ResponseEntity<List<SalaDTO>>(salaDTOS, HttpStatus.OK);
        else
            return   new ResponseEntity<List<SalaDTO>>(salaDTOS, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<SalaDtoResponse> getSalaByID(@PathVariable Integer id)  {
        SalaDtoResponse salaDtoResponse = new SalaDtoResponse();
        salaDtoResponse = salaServicePort.getSalaDtoById(id);
        if (salaDtoResponse != null)
            return  new ResponseEntity<SalaDtoResponse>(salaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<SalaDtoResponse>(salaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteSalaByID(@PathVariable Integer id) {
        salaServicePort.deleteSala(id);
    }

}
