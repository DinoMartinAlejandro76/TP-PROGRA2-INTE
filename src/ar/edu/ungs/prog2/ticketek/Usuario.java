package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String email;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private ArrayList<Entrada> entradas;


    //Constructor
    public Usuario(String email, String nombre, String apellido, String contrasenia) {

        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;

    }

    //Otro constructor que toma la lista de entradas
    public Usuario(String email, String nombre, String apellido, String contrasenia, ArrayList<Entrada> entradas) {

        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.entradas = entradas;

    }

    //Metodos

    //Validar Contraseña
    public boolean validarContrasenia(String contrasenia) {

        //Validar que sea la contraseña igual a la del usuario. Podria ser que este algo asi?

        if(! this.contrasenia.equals(contrasenia)) {
            throw new RuntimeException("Contraseña invalida");
        }
        return true;
    }

    //Agregar entrada
    public void agregarEntrada(Entrada entrada) {

        if (entrada == null) {
            throw new RuntimeException("Entrada no puede ser nula");
        }
        entradas.add(entrada);

    }

    //Obtener la lista de entradas del usuario. //Generada con getter
    public ArrayList<Entrada> getEntradas() {
        return entradas;
    }

    public List<Entrada> getEntradasFuturas(){

        //falta implementa.
        return null;

    }

    public void eliminarEntrada(int codigoEntrada) {

        //Algo asi?
        //hacer despues


    }

    //Getters y Setters

    public String getContrasenia() {
        return contrasenia;
    }






}