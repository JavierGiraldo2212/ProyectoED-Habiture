import java.time.LocalDate;
import java.time.LocalTime;

public class Actividad {
    // Atributos obligatorios
    private String nombre;
    private LocalDate fecha;
    private int nivelImportancia;

    // Atributos opcionales
    private LocalTime hora;
    private String descripcion;

    // Constructor para obligatorios
    public Actividad(String nombre, LocalDate fecha, int nivelImportancia) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.nivelImportancia = nivelImportancia;
    }

    // Constructor para todos los atributos
    public Actividad(String nombre, LocalDate fecha, int nivelImportancia, LocalTime hora, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.nivelImportancia = nivelImportancia;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    // Métodos para acceder y modificar atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNivelImportancia() {
        return nivelImportancia;
    }

    public void setNivelImportancia(int nivelImportancia) {
        this.nivelImportancia = nivelImportancia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre);
        sb.append(", Fecha: ").append(fecha);
        sb.append(", Nivel de importancia: ").append(nivelImportancia);
        if (hora != null) {
            sb.append(", Hora: ").append(hora);
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            sb.append(", Descripción: ").append(descripcion);
        }
        return sb.toString();
    }
}

