public class Tarea{

    //Atributos

    private String titulo;
    private String descripion;
    private Estado estado;
    private LocalDate fecha_creacion;

    public enum Estado{
        PENDING,
        IN_PROGRESS,
        DONE,
        BLOCKED
    }

    private static final ArrayList<Tarea> tareas = new ArrayList<>();


    //Constructor

    public Tarea(String titulo, String descripion, Estado estado, LocalDate fecha_creacion){
        validarString(titulo);
        validarString(descripion);
        validarEstado(estado);
        validarFecha(fecha_creacion);

        this.titulo = titulo;
        this.descripion = descripion;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
    }

    //Métodos de validación para los atributos

    public static void validarString(String texto){
        if (texto == null || texto.isEmpty()){
            throw new IllegalArgumentException("El texto introducido no puede ser nulo o estar vacío");
        }
    }

    public static void validarEstado(Estado estado){
        if (estado == null){
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
    }
    
    public static void validarFecha(LocalDate fecha){
        if (fecha == null){
            throw new IllegalArgumentException("La fecha no puede ser nula");
        } else if (fecha.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La fecha no puede ser pasada");
        }
    }

    //Metodos para gestionar las tareas

    public void mostrarTareas(){
        for (Tarea tarea : tareas){
            System.out.println(tarea);
        }
    }

    public void agregarTarea(Tarea tarea){
        if (tarea == null){
            throw new IllegalArgumentException("La tarea no puede ser nula");
        }
        tareas.add(tarea);
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripion='" + descripion + '\'' +
                ", estado=" + estado +
                ", fecha_creacion=" + fecha_creacion +
                '}';
    }


    //Getters

    public String getTitulo() {
        return titulo;
    }

    public String getDescripion() {
        return descripion;
    }

    public Estado getEstado() {
        return estado;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    //Setters con validaciones

    public void setTitulo(String titulo) {
        validarString(titulo);
        this.titulo = titulo;
    }

    public void setDescripion(String descripion) {
        validarString(descripion);
        this.descripion = descripion;
    }

    public void setEstado(Estado estado) {
        validarEstado(estado);
        this.estado = estado;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        validarFecha(fecha_creacion);
        this.fecha_creacion = fecha_creacion;
    }




}