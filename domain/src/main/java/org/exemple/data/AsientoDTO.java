package org.exemple.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class AsientoDTO {

    private Integer id;

    private Integer nroasiento;

    private SalaDTO idsala;

    private EstadoDTO idestado;



}