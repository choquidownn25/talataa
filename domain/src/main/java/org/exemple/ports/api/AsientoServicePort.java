package org.exemple.ports.api;



import org.exemple.data.AsientoDTO;
import org.exemple.data.response.AsientoDtoResponse;

import java.util.List;

public interface AsientoServicePort {
    AsientoDtoResponse addAsiento(AsientoDTO asientoDto);
    AsientoDtoResponse updateAsiento(AsientoDTO asientoDto);
    void deleteAsiento(Integer id);
    List<AsientoDTO> getAsientos();
    AsientoDtoResponse getAsientoDtoById(Integer id);

}
