package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class Ticketek implements ITicketek {

    //Para las sedes
    private Map<String, Sede> sedes = new HashMap<>();
    //Para los usuarios
    private Map<String, Usuario> usuarios = new HashMap<>();
    //Entradas
    private Map<String, IEntrada> entradas = new HashMap<>();
    //Espectaculos
    private Map<String, Espectaculo> espectaculos = new HashMap<>();

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima) {

        if (sedes.containsKey(nombre)) {
            throw new RuntimeException("Ya existe una sede con ese nombre");
        }
        Sede nuevaSede = new Estadio(nombre, direccion, capacidadMaxima);
        sedes.put(nombre, nuevaSede);

    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        if (sedes.containsKey(nombre)) {
            throw new RuntimeException("Ya existe una sede con ese nombre");
        }
        Sede nuevaSede = new Teatro(nombre, direccion, capacidadMaxima, asientosPorFila, sectores, capacidad, porcentajeAdicional);
        sedes.put(nombre, nuevaSede);
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        if (sedes.containsKey(nombre)) {
            throw new RuntimeException("Ya existe una sede con ese nombre");
        }
        Sede nuevaSede = new Miniestadio(nombre, direccion, capacidadMaxima, asientosPorFila, cantidadPuestos, precioConsumicion, sectores, capacidad, porcentajeAdicional);
        sedes.put(nombre, nuevaSede);
    }

    @Override
    public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {

        if (email == null || email.isEmpty() || nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty() || contrasenia == null || contrasenia.isEmpty()) {
            throw new RuntimeException("Los datos del usuario no son válidos");
        }
        if (usuarios.containsKey(email)) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }
        Usuario nuevoUsuario = new Usuario(email, nombre, apellido, contrasenia);
        usuarios.put(email, nuevoUsuario);


    }

    @Override
    public void registrarEspectaculo(String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            throw new RuntimeException("El nombre del espectáculo no es válido");
        }
        if (espectaculos.containsKey(nombre)) {
            throw new RuntimeException("Ya existe un espectáculo con ese nombre");
        }
        Espectaculo nuevoEspectaculo = new Espectaculo(nombre);
        espectaculos.put(nombre, nuevoEspectaculo);


    }

    @Override
    public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {

        if (!espectaculos.containsKey(nombreEspectaculo)) {
            throw new RuntimeException("El espectáculo no existe.");
        }

        if (!sedes.containsKey(sede)) {
            throw new RuntimeException("La sede no existe.");
        }

        Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
        Sede sedeEncontrada = sedes.get(sede);

        Funcion nuevaFuncion = new Funcion(espectaculo, fecha, sede, precioBase);
        sedeEncontrada.agregarFuncion(nuevaFuncion);


    }

    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas) {

        //Se debe lanzar una excepcion si: - Si la sede de la funcion está numerada -
        //        si el usuario no está registrado - si el espectaculo no está registrado -
        //        si la contraseña no es valida -

        if (!espectaculos.containsKey(nombreEspectaculo)) {
            throw new RuntimeException("El espectáculo no existe.");
        }
        if (!usuarios.containsKey(email)) {
            throw new RuntimeException("El usuario no existe.");
        }

        if (!usuarios.get(email).validarContrasenia(contrasenia)) {
            throw new RuntimeException("La contraseña es inválida.");
        }


        return List.of();

    }


    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos) {


        if (!espectaculos.containsKey(nombreEspectaculo)) {
            throw new RuntimeException("El espectáculo no existe.");
        }
        if (!usuarios.containsKey(email)) {
            throw new RuntimeException("El usuario no existe.");
        }

        if (!usuarios.get(email).validarContrasenia(contrasenia)) {
            throw new RuntimeException("La contraseña es inválida.");
        }
        //Si no devolver la lista de entradas vendidas
        List<IEntrada> entradasVendidas = new ArrayList<>();
        for (int i = 0; i < asientos.length; i++) {
            Entrada entrada = new Entrada(email, nombreEspectaculo, fecha, sector, asientos[i]);
            entradasVendidas.add(entrada);
        }
        return entradasVendidas;
    }

    @Override
    public String listarFunciones(String nombreEspectaculo) {
        return "";
    }

    @Override
    public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
        return List.of();
    }

    @Override
    public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
        return List.of();
    }

    @Override
    public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {

        if (!usuarios.containsKey(email)) {
            throw new RuntimeException("El usuario no existe.");
        }
        if (!usuarios.get(email).validarContrasenia(contrasenia)) {
            throw new RuntimeException("La contraseña es inválida.");
        }

        //Recorro el ArrayLista de entradas de usuario
        ArrayList<Entrada> entradasUsuario = usuarios.get(email).getEntradas();

        //Creo una lista de entradas
        List<IEntrada> entradas = new ArrayList<>();
        //Recorro la lista de entradas del usuario

        for (Entrada entrada : entradasUsuario) {

            entradas.add(entrada);

        }




        return entradas;
    }

    @Override
    public boolean anularEntrada(IEntrada entrada, String contrasenia) {

        return false;
    }

    @Override
    public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
        return null;
    }

    @Override
    public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
        return null;
    }

    @Override
    public double costoEntrada(String nombreEspectaculo, String fecha) {
        if (!espectaculos.containsKey(nombreEspectaculo)) {
            throw new RuntimeException("El espectáculo no existe.");
        }
        if (!sedes.containsKey(fecha)) {
            throw new RuntimeException("La sede no existe.");
        }

        Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
        Funcion funcionEncontrada = null;
        for (Funcion f : espectaculo.getFunciones()) {
            if (f.getLocalDate().equals(fecha)) {
                funcionEncontrada = f;
                break;
            }
        }
        if (funcionEncontrada == null) {
            throw new RuntimeException(
                    "No existe función para ese espectáculo en la fecha indicada."
            );
        }


        Sede sedeDeFuncion = funcionEncontrada.getSede();
        if (!(sedeDeFuncion instanceof Estadio)) {
            throw new RuntimeException(
                    "La sede de esta función está numerada; este método es sólo para estadios."
            );
        }


        return funcionEncontrada.getPrecioBase();

    }

    @Override
    public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
        return 0;
    }

    @Override
    public double totalRecaudado(String nombreEspectaculo) {

        if (!espectaculos.containsKey(nombreEspectaculo)) {
            throw new RuntimeException("El espectáculo no existe.");
        }
        Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
        double totalRecaudado = 0;
        for (Funcion funcion : espectaculo.getFunciones()) {
            totalRecaudado += funcion.calcularTotalRecaudado();
        }
        return totalRecaudado;
    }

    @Override
    public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
        return 0;
    }
}
