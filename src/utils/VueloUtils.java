package utils;

import entities.Vuelo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class VueloUtils {
    // Funcion de filtrado
    public static void filtrarVuelos(List<Vuelo> vuelos, Optional<LocalDate> fechaDesde, Optional<LocalDate> fechaHasta){
        // Si ninguna fecha es nula, filtra los vuelos comprendidos entre las dos fechas ordenados por fechaInicio
        if (fechaDesde.isPresent() && fechaHasta.isPresent()){
            vuelos.stream()
                    .filter(n -> n.getFechaInicio().isAfter(fechaDesde.get()))
                    .filter(n -> n.getFechaInicio().isBefore(fechaHasta.get()))
                    .sorted(Comparator.comparing(Vuelo::getFechaInicio))
                    .forEach(System.out::println);
        // Si la fechaDesde no es nula, filtra los vuelos desde la fecha hacia delante ordenados por fechaInicio
        } else if (fechaDesde.isPresent()) {
            vuelos.stream()
                    .filter(n -> n.getFechaInicio().isAfter(fechaDesde.get()))
                    .sorted(Comparator.comparing(Vuelo::getFechaInicio))
                    .forEach(System.out::println);
        // Si la fechaHasta no es nula, filtra los vuelos hasta la fecha ordenados por fechaInicio
        } else if (fechaHasta.isPresent()) {
            vuelos.stream()
                    .filter(n -> n.getFechaInicio().isBefore(fechaHasta.get()))
                    .sorted(Comparator.comparing(Vuelo::getFechaInicio))
                    .forEach(System.out::println);
        // Si las dos fechas son nulas, muestra todos los vuelos ordenados por fechaInicio
        }else {
            vuelos.stream()
                    .sorted(Comparator.comparing(Vuelo::getFechaInicio))
                    .forEach(System.out::println);
        }

    }
}
