import DataStructures.*;
import java.time.LocalDate;



public class Funcion {
	
	public void Done(NodeStack<Actividad> Historial, LinkedList<Actividad> actividades) {
		Historial.push(actividades.popFront());
	}
	
	public void UnDone(NodeStack<Actividad> Historial, LinkedList<Actividad> actividades) {
		actividades.add(Historial.pop());
	}
	
	
	
	 public static NodeQueue<Actividad> MetaDiaria(LinkedList<Actividad> listaActividades) {
		 
        // Obtener la fecha de hoy
        LocalDate fechaHoy = LocalDate.now();
        NodeQueue<Actividad> colaActividades = new NodeQueue<>();
        
        
        
        return colaActividades;
    }
}
