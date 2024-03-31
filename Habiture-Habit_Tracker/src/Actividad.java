import java.time.LocalDate;
import java.time.LocalTime;

public class Actividad implements Comparable<Actividad>{
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
        this.hora = LocalTime.of(23,59);	// Hora estandar 23:59
    }

    // Constructor para todos los atributos menos descripcion
    public Actividad(String nombre, LocalDate fecha, int nivelImportancia, LocalTime hora) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.nivelImportancia = nivelImportancia;
        this.hora = hora;
    }

    // Constructor para todos los atributos menos hora
    public Actividad(String nombre, LocalDate fecha, int nivelImportancia, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.nivelImportancia = nivelImportancia;
        this.descripcion = descripcion;
        this.hora = LocalTime.of(23, 59);
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

    
    // Comparar por importancia
    public int compararPorImportancia(Actividad otraActividad) {
        return Integer.compare(this.nivelImportancia, otraActividad.nivelImportancia);
    }

    // Comparar por fecha y hora si la fecha es la misma
    public int compareTo(Actividad otraActividad) {
        int comparacionFecha = this.fecha.compareTo(otraActividad.fecha);
        if (comparacionFecha == 0) {// Si las fechas son iguales, comparar por hora
            return this.hora.compareTo(otraActividad.hora);
        }
        return comparacionFecha;
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

