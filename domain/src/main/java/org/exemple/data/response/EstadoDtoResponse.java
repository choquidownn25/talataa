package org.exemple.data.response;

import lombok.*;
import org.exemple.data.EstadoDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstadoDtoResponse {
    private List<EstadoDTO> listEstadoDTO;
    private Message message;
}
