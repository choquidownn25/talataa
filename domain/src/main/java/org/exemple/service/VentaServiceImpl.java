package org.exemple.service;

import org.exemple.data.VentaDTO;
import org.exemple.data.response.Message;
import org.exemple.data.response.VentaDtoResponse;
import org.exemple.ports.api.VentaServicePort;
import org.exemple.ports.spi.VentaPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class VentaServiceImpl implements VentaServicePort {
    private VentaPersistencePort ventaPersistencePort;
    @Autowired
    public VentaServiceImpl(VentaPersistencePort ventaPersistencePort) {
        this.ventaPersistencePort = ventaPersistencePort;
    }

    @Override
    public VentaDtoResponse addVenta(VentaDTO ventaDto) {
        VentaDtoResponse response = new VentaDtoResponse();
        VentaDTO asiento = null;
        List<VentaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = ventaPersistencePort.addVenta(ventaDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListVentaDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public VentaDtoResponse updateVenta(VentaDTO ventaDto) {
        VentaDtoResponse response = new VentaDtoResponse();
        VentaDTO asiento = null;
        List<VentaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = ventaPersistencePort.updateVenta(ventaDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListVentaDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public void deleteVenta(Integer id) {
        ventaPersistencePort.deleteVenta(id);
    }

    @Override
    public List<VentaDTO> getVentas() {
        return ventaPersistencePort.getVentas();
    }

    @Override
    public VentaDtoResponse getVentaDtoById(Integer id) {
        VentaDtoResponse response = new VentaDtoResponse();
        VentaDTO asiento = null;
        List<VentaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = ventaPersistencePort.getVentaDTOById(id);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListVentaDTO(listPrestamoDTO);
        }
        return response;
    }
}
