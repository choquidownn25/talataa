package org.example.entity;

import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDESTADO", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;


}