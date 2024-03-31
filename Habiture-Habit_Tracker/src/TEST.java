import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import DataStructures.LinkedList;
import DataStructures.NodeStack;

public class TEST {
    public Actividad generador(int No){
        Random random = new Random();
        String nombre = "Actividad " + No;
        LocalDate fecha = LocalDate.now().plusDays(random.nextInt(30)); // Generar una fecha aleatoria en los próximos 30 días
        
        int nivelImportancia = random.nextInt(10) + 1; // Generar un nivel de importancia aleatorio entre 1 y 10
        
        LocalTime hora = LocalTime.of(23,59);;
        if (random.nextBoolean()) { // Hay un 50% de probabilidad de tener una hora
            hora = LocalTime.of(random.nextInt(24), random.nextInt(60)); // Generar una hora aleatoria
        }
        String descripcion = "";
        if (random.nextBoolean()) { // Hay un 50% de probabilidad de tener una descripción
            descripcion = "Descripción de la actividad"; // Una descripción aleatoria
        }
        Actividad actividad = new Actividad(nombre, fecha, nivelImportancia, hora, descripcion);
        return actividad;
    }
    
    public long testDo_undo(int No, NodeStack<Actividad> Historial, 
            LinkedList<Actividad> actividades, Funcion fn) {
        
        for(int num = 1; num <= No; num++) actividades.add(generador(num));
        System.out.println(actividades.getSize());
        
        long startTime = System.nanoTime(); // Guarda el tiempo de inicio
        for(int num = 1; num <= No; num++) fn.Done(Historial, actividades);
        System.out.println(actividades.getSize());
        for(int num = 1; num <= No; num++) fn.UnDone(Historial, actividades);
        System.out.println(actividades.getSize());
        
        long endTime = System.nanoTime(); // Guarda el tiempo de finalización
        
        return endTime - startTime;
    }

    
}
