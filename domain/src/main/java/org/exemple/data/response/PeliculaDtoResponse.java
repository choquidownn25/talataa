package org.exemple.data.response;

import lombok.*;
import org.exemple.data.PeliculaDTO;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PeliculaDtoResponse {
    private List<PeliculaDTO> listPeliculaDTO;
    private Message message;
}
