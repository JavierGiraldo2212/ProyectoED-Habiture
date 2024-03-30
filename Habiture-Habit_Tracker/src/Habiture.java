import DataStructures.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Habiture {

	public static void main(String[] args) {
        

        Actividad actividad1 = new Actividad("Hacer ejercicio", LocalDate.now(), 3);
        Actividad actividad2 = new Actividad("Estudiar programación", LocalDate.of(2024, 3, 30), 2,
        		LocalTime.of(14, 0), "Repasar Estructuras de datos");
        
        
        
        NodeStack<Actividad> stackActividades = new NodeStack<>();
        stackActividades.push(actividad2);
        stackActividades.push(actividad1);
        
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        System.out.println(stackActividades.pop());
        
        stackActividades.push(actividad1);
        System.out.println(stackActividades.pop());
        
        
    }

}
