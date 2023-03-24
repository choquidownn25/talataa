package org.exemple.ports.spi;

import org.exemple.data.ClienteDTO;

import java.util.List;

public interface ClientePersistencePort {
    ClienteDTO addCliente(ClienteDTO clienteDto);
    ClienteDTO updateCliente(ClienteDTO clienteDto);
    void deleteCliente(Integer id);
    List<ClienteDTO> getClientes();
    ClienteDTO getClienteDTOById(Integer id);
}
