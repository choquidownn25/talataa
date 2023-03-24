package org.example.adapters;


import org.example.entity.Venta;
import org.example.mappers.VentaMapper;
import org.example.repository.VentaRepository;
import org.exemple.data.VentaDTO;
import org.exemple.ports.spi.VentaPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VentaJpaAdapter implements VentaPersistencePort {
    @Autowired
    private VentaRepository ventaRepository;
    @Override
    public VentaDTO addVenta(VentaDTO ventaDto) {
        ModelMapper modelMapper = null;
        Venta postRequest = VentaMapper.INSTANCE.INSTANCE.ventaToVentaDto(ventaDto);
        Venta ventaSave = ventaRepository.save(postRequest);
        VentaDTO retornVentaDto = VentaMapper.INSTANCE.ventaDTOToVenta(ventaSave);
        return retornVentaDto;
    }

    @Override
    public VentaDTO updateVenta(VentaDTO ventaDto) {
        ModelMapper modelMapper = null;
        Venta postRequest = VentaMapper.INSTANCE.INSTANCE.ventaToVentaDto(ventaDto);
        Venta ventaSave = ventaRepository.save(postRequest);
        VentaDTO retornVentaDto = VentaMapper.INSTANCE.ventaDTOToVenta(ventaSave);
        return retornVentaDto;
    }

    @Override
    public void deleteVenta(Integer id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public List<VentaDTO> getVentas() {
        List<Venta> listVentas = ventaRepository.findAll();
        return VentaMapper.INSTANCE.ventaDtoListToVentaList(listVentas);
    }

    @Override
    public VentaDTO getVentaDTOById(Integer id) {
        Optional<Venta> ventaId = ventaRepository.findById(id);
        if (ventaId.isPresent()) {
            return VentaMapper.INSTANCE.ventaDTOToVenta(ventaId.get());
        }
        return null;
    }
}
