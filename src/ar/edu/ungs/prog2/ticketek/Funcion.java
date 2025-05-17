package ar.edu.ungs.prog2.ticketek;

import java.sql.Date;
import java.util.List;

public class Funcion {

    private Sede sede;
    private Date LocalDate;
    private double precioBase;
    private List<Entrada> entradasVendidas;


    //Contructor
    public Funcion(Sede sede, Date LocalDate, double precioBase, List<Entrada> entradasVendidas) {
        this.sede = sede;
        this.setLocalDate(LocalDate);
        this.precioBase = precioBase;
        this.entradasVendidas = entradasVendidas;
    }



    //Metodos
    public boolean hayDisponibilidad(int sector, int asiento) {


        return true;
    }

    public Entrada venderEntrada(Usuario usuario, int sector, int asiento) {

        //Hacer
        return entradasVendidas.getFirst();
    }

    public double calcularPrecioEntrada(int sector) {

        return sede.calcularPrecioEntrada(precioBase, sector);

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



    public Date getLocalDate() {
        return LocalDate;
    }



    public void setLocalDate(Date localDate) {
        LocalDate = localDate;
    }



    public java.time.LocalDate getFecha() {
        return LocalDate.toLocalDate();
    }
}
