package org.exemple.service;

import lombok.RequiredArgsConstructor;
import org.exemple.data.AsientoDTO;
import org.exemple.data.response.AsientoDtoResponse;
import org.exemple.data.response.Message;
import org.exemple.ports.api.AsientoServicePort;
import org.exemple.ports.spi.AsientoPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Component
public class AsientoServiceImpl implements AsientoServicePort {
    private AsientoPersistencePort asientoPersistencePort;

    @Autowired
    public AsientoServiceImpl(AsientoPersistencePort asientoPersistencePort) {
        this.asientoPersistencePort = asientoPersistencePort;
    }

    @Override
    public AsientoDtoResponse addAsiento(AsientoDTO asientoDto) {
        AsientoDtoResponse response = new AsientoDtoResponse();
        AsientoDTO asiento = null;
        List<AsientoDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = asientoPersistencePort.addAsiento(asientoDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVEASIENTO.getName());
            message.setCode( StringResponse.ErrorSAVEASIENTO.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListAsientoDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public AsientoDtoResponse updateAsiento(AsientoDTO asientoDto) {
        AsientoDtoResponse response = new AsientoDtoResponse();
        AsientoDTO asiento = null;
        List<AsientoDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        if(asientoPersistencePort.getAsientoDtoById(asientoDto.getId()) == null) {
            message.setEcho (StringResponse.ErrorNOHAYASIENTO.getName());
            message.setCode( StringResponse.ErrorNOHAYASIENTO.getCode());
            response.setMessage( message);
        }else{
            asiento = asientoPersistencePort.updateAsiento(asientoDto);
            if(asiento==null){
                message.setEcho (StringResponse.ErrorSAVEASIENTO.getName());
                message.setCode( StringResponse.ErrorSAVEASIENTO.getCode());
                response.setMessage( message);
            }else{
                listPrestamoDTO.add(asiento);
                message.setEcho (StringResponse.OK.getName());
                message.setCode( StringResponse.OK.getCode());
                response.setMessage( message);
                response.setListAsientoDTO(listPrestamoDTO);
            }
        }

        return response;
    }

    @Override
    public void deleteAsiento(Integer id) {
        asientoPersistencePort.deleteAsiento(id);
    }

    @Override
    public List<AsientoDTO> getAsientos() {
        return asientoPersistencePort.getAsientos();
    }

    @Override
    public AsientoDtoResponse getAsientoDtoById(Integer id) {
        AsientoDtoResponse response = new AsientoDtoResponse();
        AsientoDTO asiento = null;
        List<AsientoDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = asientoPersistencePort.getAsientoDtoById(id);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorNOHAYASIENTO.getName());
            message.setCode( StringResponse.ErrorNOHAYASIENTO.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListAsientoDTO(listPrestamoDTO);
        }
        return response;
    }
}
