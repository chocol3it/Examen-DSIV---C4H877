package medtriage_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import medtriage_backend.dto.CitaMedicaDTO;
import medtriage_backend.dto.CrearCitaDTO;
import medtriage_backend.model.CitaMedica;
import medtriage_backend.service.CitaMedicaService;

@RestController
@RequestMapping("/api/v1/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitaMedicaController {
    private final CitaMedicaService citaMedicaService;

    public CitaMedicaController(CitaMedicaService citaMedicaService) { this.citaMedicaService = citaMedicaService; }

    @GetMapping // GET /api/v1/citas
    public ResponseEntity<List<CitaMedicaDTO>> obtenerTodas() {
        List<CitaMedica> citas = citaMedicaService.obtenerTodas();
        List<CitaMedicaDTO> respuesta = new ArrayList<>();

        for (CitaMedica cita : citas) {
            respuesta.add(citaMedicaService.convertirADTO(cita));
        }

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/prioridad/{prioridad}") // GET /api/v1/citas/prioridad/ALTA
    public ResponseEntity<List<CitaMedicaDTO>> obtenerPorPrioridad(@PathVariable String prioridad) {
        List<CitaMedica> citas = citaMedicaService.obtenerPorPrioridad(prioridad);
        List<CitaMedicaDTO> respuesta = new ArrayList<>();

        for (CitaMedica cita : citas) {
            respuesta.add(citaMedicaService.convertirADTO(cita));
        }

        return ResponseEntity.ok(respuesta);
    }

    @PostMapping // POST -> 201 CREATED
    public ResponseEntity<CitaMedicaDTO> crearCita(@RequestBody CrearCitaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(citaMedicaService.crearCita(dto));
    }

    @PatchMapping("/{id}/estado") // PATCH /api/v1/citas/5/estado?nuevoEstado=EN_ATENCION
    public ResponseEntity<CitaMedicaDTO> actualizarEstado(@PathVariable Long id, @RequestParam String nuevoEstado) {
        return ResponseEntity.ok(citaMedicaService.actualizarEstadoCita(id, nuevoEstado));
    }
}
