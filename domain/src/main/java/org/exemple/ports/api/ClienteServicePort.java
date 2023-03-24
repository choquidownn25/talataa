package org.exemple.ports.api;

import org.exemple.data.ClienteDTO;
import org.exemple.data.response.ClienteDtoResponse;

import java.util.List;

public interface ClienteServicePort {
    ClienteDtoResponse addCliente(ClienteDTO clienteDto);
    ClienteDtoResponse updateCliente(ClienteDTO clienteDto);
    void deleteCliente(Integer id);
    List<ClienteDTO> getClientes();
    ClienteDtoResponse getClienteDtoById(Integer id);

}
