package org.exemple.data;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class VentaDTO {

    private Integer id;


    private ClienteDTO idcliente;


    private CarteleraDTO idcartelera;

    private LocalDate fecha;


    private String asientos;


    private String tpago;


    private String promocion;


    private BigDecimal descuento;


    private EstadoDTO idestado;

}