package org.exemple.data;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class CarteleraDTO {

    private Integer id;


    private PeliculaDTO idpelicula;


    private SalaDTO idsala;

    private LocalTime horainicio;

    private LocalTime horafin;

    private LocalDate fecha;

    private EstadoDTO idestado;


}