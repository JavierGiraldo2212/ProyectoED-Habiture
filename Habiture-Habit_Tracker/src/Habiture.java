import DataStructures.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadLocalRandom;


public class Habiture {

	public static void main(String[] args) {
       
		Funcion fn = new Funcion(); TEST test = new TEST();
		int max = 100;

		
		LinkedList<Actividad> actividades = new LinkedList<>(); // La lista enlazada ordena de menor a mayor según la fecha
		NodeStack<Actividad> Historial = new NodeStack<>();
		
        //test.testDo_undo(Historial, actividades, fn);
		
		test.testUpdtDlt(actividades, fn);

    }

}

/*
 * Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
 * Actividad actividad2 = new Actividad("Estudiar programación",
 * LocalDate.of(2024, 3, 28), 2,
 * LocalTime.of(14, 0), "Repasar Estructuras de datos");
 * Actividad actividad3 = new Actividad("Ni había nacido", LocalDate.of(1999, 5,
 * 31), 3);
 * 
 * // Lista con actividades, ordenada menor a mayor
 * actividades.add(actividad1);
 * actividades.add(actividad1);
 * actividades.add(actividad3);
 * 
 * // Cola con actividades, en el orden recibido
 * Programacion.enqueue(actividad1);
 * Programacion.enqueue(actividad2);
 * Programacion.enqueue(actividad3);
 * 
 * System.out.println("Lista ordenada original - ordenada");
 * actividades.printRecursive();
 * System.out.println();
 * fn.Done(Historial, actividades);
 * System.out.println("Lista actualizada");
 * actividades.printRecursive();
 * System.out.println("HISTORIAL");
 * System.out.println(Historial.peek());
 * 
 * System.out.println("\n Retomando del historial");
 * fn.UnDone(Historial, actividades);
 * System.out.println("Lista actualizada");
 * actividades.printRecursive();
 */


