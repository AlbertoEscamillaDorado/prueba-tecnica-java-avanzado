import entities.Vuelo;

import java.time.LocalDate;
import java.util.*;

import static utils.GenerateVuelo.generateVuelo;
import static utils.VueloUtils.filtrarVuelos;

public class Main {

    public static void main(String[] args) {
        LocalDate fechaDesde, fechaHasta;
        List<Vuelo> vuelos = new ArrayList<>();
        // Genera la lista de vuelos
        generateVuelo(vuelos);

        // Muestra la lista vuelos
        linea();
        vuelos.stream().forEach(System.out::println);
        linea();

        //Editar el valor de las fechas. Formato(Año,Mes,Dia)
        fechaDesde = LocalDate.of(2025,5,1);
        fechaHasta = LocalDate.of(2025,7,20);
        //fechaDesde = null;
        //fechaHasta = null;

        // Llama a la funcion de filtro
        filtrarVuelos(vuelos,Optional.ofNullable(fechaDesde),Optional.ofNullable(fechaHasta));
        linea();
    }

    // Funcion para mostrar un separador por consola
    public static void linea(){
        System.out.println("-----------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------");
    }
}