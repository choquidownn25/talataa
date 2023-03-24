package org.exemple.utils;

public enum StringResponse {
    ErrorSAVE("Tipo de usuario no permitido en la biblioteca",1),
    ErrorSREMOVE("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",2),
    ErrorNOHAYPRODUCTO("Producto no encontrado",3),
    ErrorSUPDATE("El usuario con identificación xxxxxx ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo",401),
    ErrorSAVEASIENTO("Error en guardar un asiento",4),
    ErrorSREMOVEASIENTO("Error en guardar un asiento",5),
    ErrorNOHAYASIENTO("Asiento no encontrado",6),
    ErrorSASIENTO("El Asiento ha sufrido un error en actuliazar",7),
    ErrorSAVECartelera("Error en guardar un cartelera",8),
    ErrorSREMOVECartelera("Error en guardar un cartelera",9),
    ErrorNOHAYCartelera("Cartelera no encontrado",10),
    ErrorSCartelera("El Cartelera ha sufrido un error en actuliazar",11),


    ErrorSAVECliente("Error en guardar un cliente",12),
    ErrorSREMOVECliente("Error en guardar un cliente",13),
    ErrorNOHAYCliente("Cliente no encontrado",14),
    ErrorSCliente("El Cliente ha sufrido un error en actuliazar",15),

    ErrorSAVEEstado("Error en guardar un estado",16),
    ErrorSREMOVEEstado("Error en guardar un estado",17),
    ErrorNOHAYEstado("Estado no encontrado",18),
    ErrorSEstado("El Estado ha sufrido un error en actuliazar",19),

    ErrorSAVEPelicula("Error en guardar un Pelicula",20),
    ErrorSREMOVEPelicula("Error en guardar un Pelicula",21),
    ErrorNOHAYPelicula("Pelicula no encontrado",23),
    ErrorSPelicula("El Pelicula ha sufrido un error en actuliazar",24),

    ErrorSAVESala("Error en guardar un Sala",25),
    ErrorSREMOVESala("Error en guardar un Sala",26),
    ErrorNOHAYSala("Sala no encontrado",27),
    ErrorSSala("El Sala ha sufrido un error en actuliazar",28),
    ErrorSAVEVenta("Error en guardar un Venta",29),
    ErrorSREMOVEVenta("Error en guardar un Venta",30),
    ErrorNOHAYVenta("Venta no encontrado",31),
    ErrorSVenta("El Venta ha sufrido un error en actuliazar",32),
    OK("Registro agregado",200);



    private String name;
    private int code;


    private StringResponse (String name, int code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
