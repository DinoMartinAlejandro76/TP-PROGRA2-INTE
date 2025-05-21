package ar.edu.ungs.prog2.ticketek;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcion {

    private Sede sede;
    private Date LocalDate;
    private double precioBase;
    private List<Entrada> entradasVendidas;
    private Espectaculo espectaculo;


    //Contructor
    public Funcion(Sede sede, Date LocalDate, double precioBase, List<Entrada> entradasVendidas) {
        this.sede = sede;
        this.setLocalDate(LocalDate);
        this.precioBase = precioBase;
        this.entradasVendidas = entradasVendidas;
    }

    //Constructor
    public Funcion(Sede sede, Date LocalDate, double precioBase) {
        this.sede = sede;
        this.setLocalDate(LocalDate);
        this.precioBase = precioBase;
    }

    public Funcion(Espectaculo espectaculo, String fecha, String sede, double precioBase) {

    }


    //Metodos
    public boolean hayDisponibilidad(int sector, int asiento) {

        //Recorrer la lista de entradas vendidas
        for (Entrada entrada : entradasVendidas) {
            //Si la entrada ya fue vendida, no hay disponibilidad
            if (entrada.getSector() == sector && entrada.getAsiento() == asiento) {
                return false;
            }
        }
        return true;
    }

    public List<IEntrada> venderEntrada(
            Usuario usuario,
            int cantidadEntradas,
            int valorCodigoInicial
    ) {
        if (cantidadEntradas <= 0) {
            throw new RuntimeException("La cantidad de entradas debe ser positiva");
        }
        if (usuario == null) {
            throw new RuntimeException("Debe haber un usuario.");
        }
        List<IEntrada> vendidas = new ArrayList<>(cantidadEntradas);

        for (int i = 0; i < cantidadEntradas; i++) {
            int codigo = valorCodigoInicial + i;
            // En un estadio: sector = 0 y asiento = 0 (no numerado).
            Entrada e = new Entrada(
                    codigo,
                    this.espectaculo,
                    this,
                    usuario,
                    0,   // sector genérico
                    0    // asiento genérico
            );
            entradasVendidas.add(e);
            vendidas.add(e);
            usuario.agregarEntrada(e);
        }
        return vendidas;
    }


    public double calcularTotalRecaudado(){

        double suma = 0;
        for (Entrada entrada : entradasVendidas) {
            suma+=entrada.calcularPrecio();
        }
        return suma;

    }



    public double getPrecioBase() {
        return precioBase;
    }

    public Sede getSede() {
        return sede;
    }

    public LocalDate getLocalDate() {
        return LocalDate.toLocalDate();
    }



    

    public void setLocalDate(Date localDate) {
        LocalDate = localDate;
    }



    public java.time.LocalDate getFecha() {
        return LocalDate.toLocalDate();
    }

    public List<IEntrada> venderEntrada(Usuario usuario, int cantidadEntradas) {



    return List.of();
    }

    public double calcularPrecio() {
        return 0;
    }
}
