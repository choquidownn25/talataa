package org.exemple.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class SalaDTO {

    private Integer id;


    private String descripcion;


    private Integer asientos;

    private EstadoDTO idestado;


}