package org.exemple.data.response;

import lombok.*;
import org.exemple.data.VentaDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class VentaDtoResponse {
    private List<VentaDTO> listVentaDTO;
    private Message message;
}
