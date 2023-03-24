package org.exemple.service;

import org.exemple.data.EstadoDTO;
import org.exemple.data.EstadoDTO;
import org.exemple.data.response.EstadoDtoResponse;
import org.exemple.data.response.EstadoDtoResponse;
import org.exemple.data.response.Message;
import org.exemple.ports.api.EstadoServicePort;
import org.exemple.ports.spi.EstadoPersistencePort;
import org.exemple.ports.spi.EstadoPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EstadoServiceImpl implements EstadoServicePort {
    private EstadoPersistencePort estadoPersistencePort;
    @Autowired
    public EstadoServiceImpl(EstadoPersistencePort estadoPersistencePort) {
        this.estadoPersistencePort = estadoPersistencePort;
    }

    @Override
    public EstadoDtoResponse addEstado(EstadoDTO clienteDto) {
        EstadoDtoResponse response = new EstadoDtoResponse();
        EstadoDTO estadoDTO = null;
        List<EstadoDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        estadoDTO = estadoPersistencePort.addEstado(clienteDto);
        if(estadoDTO==null){
            message.setEcho (StringResponse.ErrorSAVEEstado.getName());
            message.setCode( StringResponse.ErrorSAVEEstado.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(estadoDTO);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListEstadoDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public EstadoDtoResponse updateEstado(EstadoDTO clienteDto) {
        EstadoDtoResponse response = new EstadoDtoResponse();
        EstadoDTO estadoDTO = null;
        List<EstadoDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        estadoDTO = estadoPersistencePort.updateEstado(clienteDto);
        if(estadoDTO==null){
            message.setEcho (StringResponse.ErrorSAVEEstado.getName());
            message.setCode( StringResponse.ErrorSAVEEstado.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(estadoDTO);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListEstadoDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public void deleteEstado(Integer id) {
        estadoPersistencePort.deleteEstado(id);
    }

    @Override
    public List<EstadoDTO> getEstados() {
        return estadoPersistencePort.getEstados();
    }

    @Override
    public EstadoDtoResponse getEstadoDtoById(Integer id) {
        EstadoDtoResponse response = new EstadoDtoResponse();
        EstadoDTO estadoDTO = null;
        List<EstadoDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        estadoDTO = estadoPersistencePort.getEstadoDTOById(id);
        if(estadoDTO==null){
            message.setEcho (StringResponse.ErrorNOHAYEstado.getName());
            message.setCode( StringResponse.ErrorNOHAYEstado.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(estadoDTO);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListEstadoDTO(listPrestamoDTO);
        }
        return response;
    }
}
