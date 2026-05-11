package demo.model;
import java.time.LocalDate;

public class Tarea{

    //Atributos

    private String titulo;
    private String descripcion;
    private Estado estado;
    private LocalDate fechaCreacion;

    public enum Estado{
        PENDING,
        IN_PROGRESS,
        DONE,
        BLOCKED
    }

    //Constructor

    public Tarea(String titulo, String descripcion, Estado estado, LocalDate fechaCreacion){

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }

    //Getters

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public LocalDate getfechaCreacion() {
        return fechaCreacion;
    }

    //Setters con validaciones

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setfechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }




}