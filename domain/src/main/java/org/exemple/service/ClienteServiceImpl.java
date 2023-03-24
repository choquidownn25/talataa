package org.exemple.service;

import org.exemple.data.ClienteDTO;
import org.exemple.data.response.ClienteDtoResponse;
import org.exemple.data.response.Message;
import org.exemple.ports.api.ClienteServicePort;
import org.exemple.ports.spi.ClientePersistencePort;
import org.exemple.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ClienteServiceImpl implements ClienteServicePort {
    private ClientePersistencePort clientePersistencePort;
    @Autowired
    public ClienteServiceImpl(ClientePersistencePort clientePersistencePort) {
        this.clientePersistencePort = clientePersistencePort;
    }

    @Override
    public ClienteDtoResponse addCliente(ClienteDTO clienteDto) {
        ClienteDtoResponse response = new ClienteDtoResponse();
        ClienteDTO clienteDTO = null;
        List<ClienteDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        clienteDTO = clientePersistencePort.addCliente(clienteDto);
        if(clienteDTO==null){
            message.setEcho (StringResponse.ErrorSAVECliente.getName());
            message.setCode( StringResponse.ErrorSAVECliente.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(clienteDTO);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListClienteDTO(listPrestamoDTO);
        }
        return response;

    }

    @Override
    public ClienteDtoResponse updateCliente(ClienteDTO clienteDto) {
        ClienteDtoResponse response = new ClienteDtoResponse();
        ClienteDTO clienteDTO = null;
        List<ClienteDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        clienteDTO = clientePersistencePort.updateCliente(clienteDto);
        if(clienteDTO==null){
            message.setEcho (StringResponse.ErrorSAVECliente.getName());
            message.setCode( StringResponse.ErrorSAVECliente.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(clienteDTO);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListClienteDTO(listPrestamoDTO);
        }
        return response;
    }

    @Override
    public void deleteCliente(Integer id) {
        clientePersistencePort.deleteCliente(id);
    }

    @Override
    public List<ClienteDTO> getClientes() {
        return clientePersistencePort.getClientes();
    }

    @Override
    public ClienteDtoResponse getClienteDtoById(Integer id) {
        ClienteDtoResponse response = new ClienteDtoResponse();
        ClienteDTO clienteDTO = null;
        List<ClienteDTO>listPrestamoDTO = new ArrayList<>();
        Message message = new Message();
        clienteDTO = clientePersistencePort.getClienteDTOById(id);
        if(clienteDTO==null){
            message.setEcho (StringResponse.ErrorNOHAYCliente.getName());
            message.setCode( StringResponse.ErrorNOHAYCliente.getCode());
            response.setMessage( message);
        }else{
            listPrestamoDTO.add(clienteDTO);
            message.setEcho (StringResponse.OK.getName());
            message.setCode( StringResponse.OK.getCode());
            response.setMessage( message);
            response.setListClienteDTO(listPrestamoDTO);
        }
        return response;
    }
}
