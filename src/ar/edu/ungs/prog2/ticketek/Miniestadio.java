package ar.edu.ungs.prog2.ticketek;

import java.util.Map;

public class Miniestadio extends Teatro {

    private int asientosPorFila;
    private int cantidadPuestos;
    private double precioConsumicion;
    private String[] sectores;
    private int[] capacidad;
    private int[] porcentajeAdicional;

    public Miniestadio(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        super(nombre, direccion, capacidadMaxima, asientosPorFila, sectores, capacidad, porcentajeAdicional);
        this.asientosPorFila = asientosPorFila;
        this.cantidadPuestos = cantidadPuestos;
        this.precioConsumicion = precioConsumicion;
        this.sectores = sectores;
        this.capacidad = capacidad;
        this.porcentajeAdicional = porcentajeAdicional;


    }

    @Override
    public double calcularPrecioEntrada(double precioBase, int sector) {

        return 0;
    }

}
