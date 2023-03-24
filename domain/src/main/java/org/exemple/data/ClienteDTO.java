package org.exemple.data;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class ClienteDTO {

    private Integer id;


    private String nombre;
    private String apellido;
    private String dni;



}