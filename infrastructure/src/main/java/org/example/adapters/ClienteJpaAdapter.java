package org.example.adapters;

import org.example.entity.Asiento;
import org.example.entity.Cartelera;
import org.example.entity.Cliente;
import org.example.mappers.AsientoMapper;
import org.example.mappers.CarteleraMapper;
import org.example.mappers.ClienteMapper;
import org.example.repository.ClienteRepository;
import org.exemple.data.ClienteDTO;
import org.exemple.data.ClienteDTO;
import org.exemple.ports.spi.ClientePersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClienteJpaAdapter implements ClientePersistencePort {
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public ClienteDTO addCliente(ClienteDTO clienteDto) {
        // convert DTO to Entity
        ModelMapper modelMapper = null;
        Cliente postRequest = ClienteMapper.INSTANCE.clienteToClienteDto(clienteDto);
        Cliente clienteSave = clienteRepository.save(postRequest);
        ClienteDTO retornClienteDto = ClienteMapper.INSTANCE.clienteDTOToCliente(clienteSave);
        return retornClienteDto;

    }

    @Override
    public ClienteDTO updateCliente(ClienteDTO clienteDto) {
        ModelMapper modelMapper = null;
        Cliente postRequest = ClienteMapper.INSTANCE.clienteToClienteDto(clienteDto);
        Cliente clienteSave = clienteRepository.save(postRequest);
        ClienteDTO retornClienteDto = ClienteMapper.INSTANCE.clienteDTOToCliente(clienteSave);
        return retornClienteDto;
    }

    @Override
    public void deleteCliente(Integer id) {

    }

    @Override
    public List<ClienteDTO> getClientes() {
        List<Cliente> listClientes = clienteRepository.findAll();
        return ClienteMapper.INSTANCE.clienteDtoListToClienteList(listClientes);

    }

    @Override
    public ClienteDTO getClienteDTOById(Integer id) {
        Optional<Cliente> clienteId = clienteRepository.findById(id);
        if (clienteId.isPresent()) {
            return  ClienteMapper.INSTANCE.clienteDTOToCliente(clienteId.get());
        }
        return null;
    }
}
