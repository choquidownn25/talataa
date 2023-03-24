package org.example.mappers;

import org.example.entity.Cliente;
import org.exemple.data.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO clienteDTOToCliente(Cliente cliente);
    Cliente clienteToClienteDto(ClienteDTO clienteDto);
    //listado
    List<ClienteDTO> clienteDtoListToClienteList(List<Cliente> clienteList);
    List<Cliente> clienteListToClienteDtoList(List<ClienteDTO> clienteDtoList);

}
