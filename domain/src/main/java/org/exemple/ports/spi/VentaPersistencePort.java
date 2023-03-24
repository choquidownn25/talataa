package org.exemple.ports.spi;

import org.exemple.data.VentaDTO;

import java.util.List;

public interface VentaPersistencePort {
    VentaDTO addVenta(VentaDTO ventaDto);
    VentaDTO updateVenta(VentaDTO ventaDto);
    void deleteVenta(Integer id);
    List<VentaDTO> getVentas();
    VentaDTO getVentaDTOById(Integer id);
}
