/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3bim2;

import java.io.File;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Usuario iTC
 */
public class Proceso {
    public static void leerDatos (){
        
        // Apertura del archivo contenedor 
        try
        {
            Scanner teclado = new Scanner (new File 
            ("datos/tabula-FWC_2018_Squadlists_4.csv"));
            double promedio_goals = 0; // V para acumular el número de goles
            double promedio_height = 0; // V para acumular la altura
            int contador = 1; //Contador para calcular las personas en la lista
            // Bucle 1: Mueve la información y suma los goles y la altura 
            while (teclado.hasNext()){ 
                // Variable que tendra la información de n persona 
                String texto = teclado.nextLine();
                // Arrays que alamacenara la info que da la v texto 
                ArrayList <String> registro_futbol = new ArrayList<>(
                Arrays.asList(texto.split("\\|"))); // sepración de la info
                // Transformación de cadena a double para los goles
                double goals = Double.parseDouble(registro_futbol.get(11));
                promedio_goals = promedio_goals + goals; // suma goles 
                // Transformación de cadena a double para la altura 
                double height = Double.parseDouble(registro_futbol.get(9));
                promedio_height = promedio_height+height; // suma altura
                contador ++; // Inncremento del contador 
            }
            teclado.close(); 
            // obtención de los promedios 
            promedio_goals = promedio_goals / contador;
            promedio_height = promedio_height / contador;
            // impresión del mensaje final 
            System.out.printf("El promedio de goles del equipo es de %.2f\n"
                    + "Mientras que la altura promedio de los "
                    + "jugadores es de: %.2f\n"
                    ,promedio_goals, promedio_height);
               
        }
        // En caso de que suceda una escepción se enviara un mensaje al usuario
        catch (Exception e){
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        }
    }
}
