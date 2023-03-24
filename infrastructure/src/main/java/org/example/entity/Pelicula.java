package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPELICULA", nullable = false)
    private Integer id;

    @Column(name = "TITULO", nullable = false, length = 50)
    private String titulo;

    @Column(name = "DURACION", nullable = false)
    private LocalTime duracion;

    @Column(name = "GENERO", nullable = false, length = 50)
    private String genero;

    @Column(name = "CLASIFICACION", nullable = false, length = 50)
    private String clasificacion;

    @Column(name = "FORMATO", nullable = false, length = 40)
    private String formato;

    @Column(name = "PORTADA", length = 50)
    private String portada;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDESTADO", nullable = false)
    private Estado idestado;


}