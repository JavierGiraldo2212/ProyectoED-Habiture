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


	// Metodo auxiliar para encontrar una actividad por el nombre
    private Actividad findActividadByName(String name, LinkedList<Actividad> actividades) {
        for (Actividad actividad : actividades) {
            if (actividad.getNombre().equals(name)) {
                return actividad;
            }
        }
        return null; // Actividad no encontrada
    }
	
    // Actualizar una actividad
    public void updateActividad(String oldName, String newName, String newDescription, LinkedList<Actividad> actividades) {
        Actividad ActividadToUpdate = findActividadByName(oldName, actividades);
        if (ActividadToUpdate != null) {
            ActividadToUpdate.setNombre(newName);
            ActividadToUpdate.setDescripcion(newDescription);
        } else {
            System.out.println("Actividad no encontrada.");
        }
    }

    // Remover una actividad
    public void removeActividad(String name, LinkedList<Actividad> actividades) {
        Actividad ActividadToRemove = findActividadByName(name, actividades);
        if (ActividadToRemove != null) {
            actividades.remove(ActividadToRemove);
        } else {
            System.out.println("Actividad no encontrada.");
        }
    }

    
}
