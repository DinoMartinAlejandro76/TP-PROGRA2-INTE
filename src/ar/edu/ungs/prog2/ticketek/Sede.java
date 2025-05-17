package ar.edu.ungs.prog2.ticketek;

public class Sede {

    protected String nombre;
    protected String direccion;
    protected int capacidadMaxima;


    //Constructor
    public Sede(String nombre, String direccion, int capacidadMaxima) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
    }


    //Metodo
    double calcularPrecioEntrada(double precioBase, int sector){

        //implementar
        return precioBase;
    }


    public String getNombre() {
        return nombre;
    }





}