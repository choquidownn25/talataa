package org.exemple.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class EstadoDTO {

    private Integer id;
    private String descripcion;


}