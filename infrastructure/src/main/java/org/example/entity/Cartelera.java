package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "cartelera")
public class Cartelera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCARTELERA", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDPELICULA", nullable = false)
    private Pelicula idpelicula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSALA", nullable = false)
    private Sala idsala;

    @Column(name = "HORAINICIO", nullable = false)
    private LocalTime horainicio;

    @Column(name = "HORAFIN", nullable = false)
    private LocalTime horafin;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDESTADO", nullable = false)
    private Estado idestado;


}