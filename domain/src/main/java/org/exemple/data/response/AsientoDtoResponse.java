package org.exemple.data.response;

import lombok.*;
import org.exemple.data.AsientoDTO;
import org.exemple.data.ProductoDto;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AsientoDtoResponse {
    private List<AsientoDTO> listAsientoDTO;
    private Message message;
}
