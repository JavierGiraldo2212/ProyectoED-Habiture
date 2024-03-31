import DataStructures.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Habiture {

	public static void main(String[] args) {
       
		Funcion fn = new Funcion();
		TEST test = new TEST();
		int max = 100000;
		
		
		LinkedList<Actividad> actividades = new LinkedList<>(); // La lista enlazada ordena de menor a mayor según la fecha
		NodeStack<Actividad> Historial = new NodeStack<>();
		
		System.out.println("Prueba para el generador aleatorio");
		long tiempo = test.testDo_undo(max, Historial, actividades, fn);
		System.out.println("Tiempo en ejecución: "+tiempo);// tiempo en nano segundos
		
	/* 	
		Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad2 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 28), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad3 = new Actividad("Ni había nacido", LocalDate.of(1999, 5, 31), 3);
        
        // Lista con actividades, ordenada menor a mayor
        actividades.add(actividad1);
        actividades.add(actividad1);
        actividades.add(actividad3);
        
        // Cola con actividades, en el orden recibido
        Programacion.enqueue(actividad1);
        Programacion.enqueue(actividad2);
        Programacion.enqueue(actividad3);
        
        System.out.println("Lista ordenada original - ordenada");
        actividades.printRecursive();
        System.out.println();
        fn.Done(Historial, actividades);
        System.out.println("Lista actualizada");
        actividades.printRecursive();
        System.out.println("HISTORIAL");
        System.out.println(Historial.peek());
        
        System.out.println("\n Retomando del historial");
        fn.UnDone(Historial, actividades);
        System.out.println("Lista actualizada");
        actividades.printRecursive();
    */

        
    }

	public static void TestComparadores() {
		Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad2 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad3 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad4 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad5 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(15, 0), "Repasar Estructuras de datos");
        
        System.out.println(actividad1.compareTo(actividad2));
        System.out.println(actividad2.compareTo(actividad1));
        System.out.println(actividad1.compareTo(actividad3));
        
        System.out.println();
        
        System.out.println(actividad4.compararPorImportancia(actividad5));
        System.out.println(actividad5.compararPorImportancia(actividad4));
        System.out.println(actividad5.compararPorImportancia(actividad5));	
	}
	
	public static void TestStack(){
		
		Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad2 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad3 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad4 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad5 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(15, 0), "Repasar Estructuras de datos");
        
		
		NodeStack<Actividad> stackActividades = new NodeStack<>();
        stackActividades.push(actividad1);
        stackActividades.push(actividad2);
        stackActividades.push(actividad3);
        stackActividades.push(actividad4);
        stackActividades.push(actividad5);	
        
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        
        System.out.println();
	}	
}
