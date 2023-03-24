package org.exemple.data;

import lombok.*;

import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class PeliculaDTO {

    private Integer id;


    private String titulo;


    private LocalTime duracion;


    private String genero;


    private String clasificacion;


    private String formato;


    private String portada;

    private EstadoDTO idestado;


}