package org.exemple.data.response;

import lombok.*;
import org.exemple.data.ClienteDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClienteDtoResponse {
    private List<ClienteDTO> listClienteDTO;
    private Message message;
}
