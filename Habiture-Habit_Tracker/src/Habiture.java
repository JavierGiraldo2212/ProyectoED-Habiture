import DataStructures.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Habiture {

	public static void main(String[] args) {
        

        Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad2 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad3 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        
        
        NodeStack<Actividad> stackActividades = new NodeStack<>();
        stackActividades.push(actividad1);
        stackActividades.push(actividad2);
        stackActividades.push(actividad3);
        
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        
        System.out.println(actividad1.compareTo(actividad2));
        System.out.println(actividad2.compareTo(actividad1));
        System.out.println(actividad1.compareTo(actividad3));
        
        
        Actividad actividad4 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        Actividad actividad5 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 29), 2,
        		LocalTime.of(15, 0), "Repasar Estructuras de datos");
        
        System.out.println();
        
        System.out.println(actividad4.compararPorFecha(actividad5));
        System.out.println(actividad5.compararPorFecha(actividad4));
        System.out.println(actividad5.compararPorFecha(actividad5));
        
    }

}
