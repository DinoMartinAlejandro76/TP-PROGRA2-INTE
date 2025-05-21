package ar.edu.ungs.prog2.ticketek;

import java.sql.Date;
import java.time.LocalDate;

public class Entrada implements IEntrada{

    private int codigoEntrada;
    private Espectaculo espectaculo;
    private Funcion funcion;
    private Usuario comprador;
    private int sector;
    private int asiento;
    private String nombreSector;


    //contructor
    public Entrada(int codigoEntrada, Espectaculo espectaculo, Funcion funcion, Usuario comprador, int sector,
                   int asiento) {
        super();
        this.codigoEntrada = codigoEntrada;
        this.espectaculo = espectaculo;
        this.funcion = funcion;
        this.comprador = comprador;
        this.sector = sector;
        this.asiento = asiento;
    }

    //Contructor para entradas vendidas
    public Entrada(String email, String nombreEspectaculo, String fecha, String sector, int asiento) {

    }


    //Metodos

    public double calcularPrecio() {

        //Pido a la funcion el precio
        double precio = funcion.getPrecioBase();
        double calculoSector = funcion.getSede().calcularPrecioEntrada(precio, sector);
        return  calculoSector;


    }

    public boolean esFutura() {

        return funcion.getFecha().isAfter(LocalDate.now());
    }

    public boolean anularEntrada(){
        if (esFutura()) {
            return true;
        } else {
            return false;
        }
    }



    public int getCodigoEntrada() {
        return codigoEntrada;
    }



    public void setCodigoEntrada(int codigoEntrada) {
        this.codigoEntrada = codigoEntrada;
    }



    public Espectaculo getEspectaculo() {
        return espectaculo;
    }



    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }



    public Funcion getFuncion() {
        return funcion;
    }



    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }



    public Usuario getComprador() {
        return comprador;
    }



    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }



    public int getSector() {
        return sector;
    }



    public void setSector(int sector) {
        this.sector = sector;
    }



    public int getAsiento() {
        return asiento;
    }



    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }


    @Override
    public double precio() {

        return funcion.calcularPrecio();
    }

    @Override
    public String ubicacion() {
        Sede sede = funcion.getSede();
        if(sede instanceof Estadio){
            return "Campo";
        }

        Teatro teatro = (Teatro) sede;
        String[] listaSectores = teatro.sectores;
        int asientosPorFila = teatro.asientosPorFila;
        String nombreSetor = listaSectores[sector];

        int fila  = (asiento / asientosPorFila) + 1;
        int nroAsiento = (asiento % asientosPorFila) + 1;

        return nombreSector + " f:" + fila + " a:" + nroAsiento;




    }


}
