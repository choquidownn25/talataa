package org.exemple.service;

import org.exemple.data.PeliculaDTO;
import org.exemple.data.response.PeliculaDtoResponse;
import org.exemple.data.response.Message;
import org.exemple.data.response.PeliculaDtoResponse;
import org.exemple.ports.api.PeliculaServicePort;
import org.exemple.ports.spi.PeliculaPersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PeliculaServiceImpl implements PeliculaServicePort {

    private PeliculaPersistencePort peliculaPersistencePort;
    @Autowired
    public PeliculaServiceImpl(PeliculaPersistencePort peliculaPersistencePort) {
        this.peliculaPersistencePort = peliculaPersistencePort;
    }

    @Override
    public PeliculaDtoResponse addPelicula(PeliculaDTO peliculaDto) {
        PeliculaDtoResponse response = new PeliculaDtoResponse();
        PeliculaDTO asiento = null;
        List<PeliculaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = peliculaPersistencePort.addPelicula(peliculaDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListPeliculaDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public PeliculaDtoResponse updatePelicula(PeliculaDTO peliculaDto) {
        PeliculaDtoResponse response = new PeliculaDtoResponse();
        PeliculaDTO asiento = null;
        List<PeliculaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = peliculaPersistencePort.updatePelicula(peliculaDto);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListPeliculaDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public void deletePelicula(Integer id) {
            peliculaPersistencePort.deletePelicula(id);
    }

    @Override
    public List<PeliculaDTO> getPeliculas() {
        return peliculaPersistencePort.getPeliculas();
    }

  

    @Override
    public PeliculaDtoResponse getPeliculaDtoById(Integer id) {
        PeliculaDtoResponse response = new PeliculaDtoResponse();
        PeliculaDTO asiento = null;
        List<PeliculaDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        asiento = peliculaPersistencePort.getPeliculaDTOById(id);
        if(asiento==null){
            message.setEcho (StringResponse.ErrorSAVE.getName());
            message.setCode( StringResponse.ErrorSAVE.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(asiento);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListPeliculaDTO(listPrestamoDTO);
        }
        return response;
    }
}
