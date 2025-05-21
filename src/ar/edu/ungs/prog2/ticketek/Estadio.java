package ar.edu.ungs.prog2.ticketek;

public class Estadio extends Sede {

    //Sector campo
    public String sector;

    //Contructor
    public Estadio(String nombre, String direccion, int capacidadMaxima) {
        super(nombre, direccion, capacidadMaxima);
        // TODO Auto-generated constructor stub
    }


    //Metodo
    @Override
    public double calcularPrecioEntrada(double precioBase, int sector) {
        // En un estadio no importa el sector:
        return precioBase;
    }

}
