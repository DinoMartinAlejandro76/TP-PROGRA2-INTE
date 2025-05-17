package ar.edu.ungs.prog2.ticketek;

import java.util.Map;

public class Teatro extends Sede {

    private int asientosPorFila;
    private String[] sectores;
    private int[] capacidad;
    private int[] porcentajeAdicional;

    public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        super(nombre, direccion, capacidadMaxima);
        this.asientosPorFila = asientosPorFila;
        this.sectores = sectores;
        this.capacidad = capacidad;
        this.porcentajeAdicional = porcentajeAdicional;


    }

    @Override
    public double calcularPrecioEntrada(double precioBase, int sector) {

        return 0;
    }

}
