
package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Sede {

    protected String nombre;
    protected String direccion;
    protected int capacidadMaxima;

    // Funciones
    private List<Funcion> funciones = new ArrayList<>();

    // Constructor
    public Sede(String nombre, String direccion, int capacidadMaxima) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Método
    double calcularPrecioEntrada(double precioBase, int sector) {
        // implementar
        return precioBase;
    }

    public void agregarFuncion(Funcion funcion) {
        if (funcion == null) {
            throw new RuntimeException("La función no puede ser nula");
        }
        funciones.add(funcion);
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }



}