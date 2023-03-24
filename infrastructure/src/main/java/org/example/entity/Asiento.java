package org.example.entity;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "asiento")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDASIENTO", nullable = false)
    private Integer id;

    @Column(name = "NROASIENTO", nullable = false)
    private Integer nroasiento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSALA", nullable = false)
    private Sala idsala;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDESTADO", nullable = false)
    private Estado idestado;



}