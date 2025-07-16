package utils;

import entities.Vuelo;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class GenerateVuelo {
    // Definicion de las empresas que pueden ser usadas para crear un vuelo
    static String[] empresas = new String[]{"IBERIA","TURKISH","AirEuropa","Vueling"};
    // Definicion de las ciudades que pueden ser usadas para crear un vuelo
    static String[] ciudades = new String[]{"MADRID","BARCELONA","GRAN CANARIA","MÁLAGA"};
    // Definicion de la variable random
    static Random r = new Random();
    // Funcion para crear un mes
    public static int generateMes(){
        return r.nextInt(1,12);
    }
    // Funcion para crear un dia
    public static int generateDia(){
        return r.nextInt(1,29);
    }
    // Funcion para crear una fecha
    public static LocalDate generateLocalDate(){
        return LocalDate.of(LocalDate.now().getYear(), generateMes(),generateDia());
    }
    // Funcion para crear la lista de vuelos
    public static void generateVuelo(List<Vuelo> vuelos){
        for (int i = 0; i < 10; i++) {
            LocalDate fechaInicio = generateLocalDate();
            LocalDate fechaFinal = fechaInicio.plusDays(r.nextInt(1,10));
            Vuelo v = new Vuelo(i,"H0"+i+"-V",empresas[i%4],ciudades[(i+1)%4],ciudades[(i+2)%4],fechaInicio,fechaFinal);
            vuelos.add(v);
        }
    }
}
