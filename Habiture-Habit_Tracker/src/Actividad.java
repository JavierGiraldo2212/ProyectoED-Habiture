import java.time.LocalDateTime;

public class Actividad {
    private LocalDateTime fechaHora;
    private String descripcion;
    private int duracionMinutos;

    public Actividad(LocalDateTime fechaHora, String descripcion, int duracionMinutos) {
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }


    @Override
    public String toString() {
        return "Actividad{" +
                "fechaHora=" + fechaHora +
                ", descripcion='" + descripcion + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                '}';
    }
}

