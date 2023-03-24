package org.exemple.data.response;

import lombok.*;
import org.exemple.data.SalaDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SalaDtoResponse {
    private List<SalaDTO> listSalaDTO;
    private Message message;
}
