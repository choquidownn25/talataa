package org.example.controller;

import org.exemple.data.ClienteDTO;
import org.exemple.data.response.ClienteDtoResponse;
import org.exemple.ports.api.ClienteServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteServicePort clienteServicePort;
    @PostMapping("/add")
    public ResponseEntity<ClienteDtoResponse> addCliente(@RequestBody ClienteDTO asientoDto) {
        ClienteDtoResponse asientoDtoDtoResponse = new ClienteDtoResponse();
        asientoDtoDtoResponse = clienteServicePort.addCliente(asientoDto);
        if (asientoDtoDtoResponse != null)
            return  new ResponseEntity<ClienteDtoResponse>(asientoDtoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<ClienteDtoResponse>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/update")
    public ResponseEntity<ClienteDtoResponse> updateCliente(@RequestBody ClienteDTO carteleraDto) {
        ClienteDtoResponse asientoDtoDtoResponse = new ClienteDtoResponse();
        asientoDtoDtoResponse = clienteServicePort.updateCliente(carteleraDto);
        if (asientoDtoDtoResponse != null)
            return  new ResponseEntity<ClienteDtoResponse>(asientoDtoDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<ClienteDtoResponse>(asientoDtoDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/get")
    public ResponseEntity<List<ClienteDTO>> getClienteDto() {
        List<ClienteDTO> carteleraDTOResponse = new ArrayList<>();
        carteleraDTOResponse = clienteServicePort.getClientes();
        if (carteleraDTOResponse != null)
            return  new ResponseEntity<List<ClienteDTO>>(carteleraDTOResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<List<ClienteDTO>>(carteleraDTOResponse, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ClienteDtoResponse> getClienteByID(@PathVariable Integer id)  {
        ClienteDtoResponse carteleraDtoResponse = new ClienteDtoResponse();
        carteleraDtoResponse = clienteServicePort.getClienteDtoById(id);
        if (carteleraDtoResponse != null)
            return  new ResponseEntity<ClienteDtoResponse>(carteleraDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<ClienteDtoResponse>(carteleraDtoResponse, HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteClienteByID(@PathVariable Integer id) {
        clienteServicePort.deleteCliente(id);
    }

}
