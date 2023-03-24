package org.example.controller;

import org.exemple.data.VentaDTO;
import org.exemple.data.response.Message;
import org.exemple.data.response.VentaDtoResponse;
import org.exemple.ports.api.CarteleraServicePort;
import org.exemple.ports.api.ClienteServicePort;
import org.exemple.ports.api.EstadoServicePort;
import org.exemple.ports.api.VentaServicePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaServicePort ventaServicePort;
    @Autowired
    private ClienteServicePort clienteServicePort;
    @Autowired
    private CarteleraServicePort carteleraServicePort;
    @Autowired
    private EstadoServicePort estadoServicePort;
    @PostMapping("/add")
    public ResponseEntity<VentaDtoResponse> addVenta(@RequestBody VentaDTO asientoDto) {
        VentaDtoResponse ventaDtoResponse = new VentaDtoResponse();

        if(estadoServicePort.getEstadoDtoById(asientoDto.getIdestado().getId())== null
                || asientoDto.getIdestado().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            ventaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(carteleraServicePort.getCarteleraDtoById(asientoDto.getIdcartelera().getId())== null
                || asientoDto.getIdcartelera().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYCartelera.getName());
            message.setCode( StringResponse.ErrorNOHAYCartelera.getCode());
            ventaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(clienteServicePort.getClienteDtoById(asientoDto.getIdcartelera().getId())== null
                || asientoDto.getIdcartelera().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYCliente.getName());
            message.setCode( StringResponse.ErrorNOHAYCliente.getCode());
            ventaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
        }
        ventaDtoResponse = ventaServicePort.addVenta(asientoDto);
        if (ventaDtoResponse != null)
            return  new ResponseEntity<VentaDtoResponse>(ventaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<VentaDtoResponse>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/update")
    public ResponseEntity<VentaDtoResponse> updateVenta(@RequestBody VentaDTO asientoDto) {
        VentaDtoResponse ventaDtoResponse = new VentaDtoResponse();

        if(estadoServicePort.getEstadoDtoById(asientoDto.getIdestado().getId())== null
                || asientoDto.getIdestado().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            ventaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(carteleraServicePort.getCarteleraDtoById(asientoDto.getIdcartelera().getId())== null
                || asientoDto.getIdcartelera().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYCartelera.getName());
            message.setCode( StringResponse.ErrorNOHAYCartelera.getCode());
            ventaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
        }
        if(clienteServicePort.getClienteDtoById(asientoDto.getIdcartelera().getId())== null
                || asientoDto.getIdcartelera().getId()<=0 ){
            Message message = new Message();
            message.setEcho (StringResponse.ErrorNOHAYCliente.getName());
            message.setCode( StringResponse.ErrorNOHAYCliente.getCode());
            ventaDtoResponse.setMessage(message);
            return   new ResponseEntity<>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
        }

        ventaDtoResponse = ventaServicePort.updateVenta(asientoDto);
        if (ventaDtoResponse != null)
            return  new ResponseEntity<VentaDtoResponse>(ventaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<VentaDtoResponse>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get")
    public ResponseEntity<List<VentaDTO>> getVentaDto() {
        List<VentaDTO> ventaDTOS = new ArrayList<>();
        ventaDTOS = ventaServicePort.getVentas();
        if (ventaDTOS != null)
            return  new ResponseEntity<List<VentaDTO>>(ventaDTOS, HttpStatus.OK);
        else
            return   new ResponseEntity<List<VentaDTO>>(ventaDTOS, HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<VentaDtoResponse> getVentaByID(@PathVariable Integer id)  {
        VentaDtoResponse ventaDtoResponse = new VentaDtoResponse();
        ventaDtoResponse = ventaServicePort.getVentaDtoById(id);
        if (ventaDtoResponse != null)
            return  new ResponseEntity<VentaDtoResponse>(ventaDtoResponse, HttpStatus.OK);
        else
            return   new ResponseEntity<VentaDtoResponse>(ventaDtoResponse, HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteVentaByID(@PathVariable Integer id) {
        ventaServicePort.deleteVenta(id);
    }
}
