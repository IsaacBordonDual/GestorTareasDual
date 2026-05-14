package demo.controller;

import demo.entity.Tarea;
import demo.repository.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/tasks")
public class TareaController {

    private final TareaRepository tareaRepository;

    public TareaController(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @GetMapping
    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tarea> obtenerPorId(@PathVariable Integer id) {
        return tareaRepository.findById(id);
    }

   
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Integer id, @RequestBody Tarea tareaActualizada) {

        Tarea tarea = tareaRepository.findById(id).orElseThrow();

        tarea.setTitulo(tareaActualizada.getTitulo());
        tarea.setDescripcion(tareaActualizada.getDescripcion());
        tarea.setEstado(tareaActualizada.getEstado());

        return tareaRepository.save(tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Integer id) {
        tareaRepository.deleteById(id);
    }
}