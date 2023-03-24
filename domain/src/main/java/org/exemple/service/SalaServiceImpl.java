package org.exemple.service;

import lombok.RequiredArgsConstructor;
import org.exemple.data.SalaDTO;
import org.exemple.data.SalaDTO;
import org.exemple.data.response.Message;
import org.exemple.data.response.SalaDtoResponse;
import org.exemple.data.response.SalaDtoResponse;
import org.exemple.ports.api.SalaServicePort;
import org.exemple.ports.spi.SalaPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Component
public class SalaServiceImpl implements SalaServicePort {
    @Autowired
    private SalaPersistencePort salaPersistencePort;

    public SalaServiceImpl(SalaPersistencePort salaPersistencePort) {
        this.salaPersistencePort = salaPersistencePort;
    }

    @Override
    public SalaDtoResponse addSala(SalaDTO salaDto) {
        SalaDtoResponse response = new SalaDtoResponse();
        SalaDTO asiento = null;
        List<SalaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = salaPersistencePort.addSala(salaDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListSalaDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public SalaDtoResponse updateSala(SalaDTO salaDto) {
        SalaDtoResponse response = new SalaDtoResponse();
        SalaDTO asiento = null;
        List<SalaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = salaPersistencePort.updateSala(salaDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListSalaDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public void deleteSala(Integer id) {

    }

    @Override
    public List<SalaDTO> getSalas() {
        return salaPersistencePort.getSalas();
    }

    @Override
    public SalaDtoResponse getSalaDtoById(Integer id) {
        SalaDtoResponse response = new SalaDtoResponse();
        SalaDTO asiento = null;
        List<SalaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = salaPersistencePort.getSalaDTOById(id);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListSalaDTO(listPrestamoDTO);
        }
        return response;
    }
}
