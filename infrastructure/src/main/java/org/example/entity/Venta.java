package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDVENTA", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCLIENTE", nullable = false)
    private Cliente idcliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDCARTELERA", nullable = false)
    private Cartelera idcartelera;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "ASIENTOS", nullable = false, length = 20)
    private String asientos;

    @Column(name = "TPAGO", nullable = false, length = 50)
    private String tpago;

    @Column(name = "PROMOCION", nullable = false, length = 80)
    private String promocion;

    @Column(name = "DESCUENTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal descuento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDESTADO", nullable = false)
    private Estado idestado;

}