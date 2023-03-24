package org.exemple.ports.spi;

import org.exemple.data.AsientoDTO;
import java.util.List;

public interface AsientoPersistencePort {
    AsientoDTO addAsiento(AsientoDTO asientoDto);
    AsientoDTO updateAsiento(AsientoDTO asientoDto);
    void deleteAsiento(Integer id);
    List<AsientoDTO> getAsientos();
    AsientoDTO getAsientoDtoById(Integer id);
}
