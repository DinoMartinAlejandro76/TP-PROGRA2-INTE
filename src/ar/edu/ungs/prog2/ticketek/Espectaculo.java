package ar.edu.ungs.prog2.ticketek;

import java.util.List;

public class Espectaculo {

    private int codigoEspectaculo;
    private String nombre;
    private List<Funcion> funciones;


    //Contructor
    public Espectaculo(int codigoEspectaculo, String nombre, List<Funcion> funciones) {
        super();
        this.codigoEspectaculo = codigoEspectaculo;
        this.nombre = nombre;
        this.funciones = funciones;

    }

    public Espectaculo(String nombre) {
        this.nombre = nombre;
    }

    public void agregarFuncion(Funcion f) {
        if (f == null) throw new RuntimeException("Función no puede ser nula");
        funciones.add(f);
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }

    public String getNombre() {
        return nombre;
    }

    //metodos







}
