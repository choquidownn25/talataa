package org.exemple.ports.api;

import org.exemple.data.VentaDTO;
import org.exemple.data.response.VentaDtoResponse;

import java.util.List;

public interface VentaServicePort {
    VentaDtoResponse addVenta(VentaDTO clienteDto);
    VentaDtoResponse updateVenta(VentaDTO clienteDto);
    void deleteVenta(Integer id);
    List<VentaDTO> getVentas();
    VentaDtoResponse getVentaDtoById(Integer id);
}
