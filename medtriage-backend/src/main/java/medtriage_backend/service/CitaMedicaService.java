package medtriage_backend.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import medtriage_backend.dto.CitaMedicaDTO;
import medtriage_backend.dto.CrearCitaDTO;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import medtriage_backend.model.Doctor;
import medtriage_backend.model.Paciente;
import medtriage_backend.model.CitaMedica;
import medtriage_backend.repository.CitaMedicaRepository;
import medtriage_backend.repository.DoctorRepository;
import medtriage_backend.repository.PacienteRepository;

@Service
public class CitaMedicaService {
    private final CitaMedicaRepository citaMedicaRepository;
    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;

    public CitaMedicaService(CitaMedicaRepository citaMedicaRepository, DoctorRepository doctorRepository,
            PacienteRepository pacienteRepositoty) {
        this.citaMedicaRepository = citaMedicaRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepositoty;
    }

    @Transactional 
    public List<CitaMedica> obtenerTodas() {
        return citaMedicaRepository.findAllByOrderByFecha_citaDesc();
    }

    @Transactional 
    public List<CitaMedica> obtenerPorPrioridad(String nivelPrioridad) {
        return citaMedicaRepository.findByNivelPrioridad(nivelPrioridad);
    }

    @Transactional 
    public CitaMedicaDTO crearCita(CrearCitaDTO crearCitaDTO) {
        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setCodigo_cita("CIT-2026-" + System.currentTimeMillis());

        Paciente paciente = pacienteRepository.findById(crearCitaDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("El paciente no existe"));
        citaMedica.setPaciente_id(paciente);

        Doctor doctor = doctorRepository.findById(crearCitaDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("El doctor no existe"));

        citaMedica.setDoctor_id(doctor);
        citaMedica.setMotivo_consulta(crearCitaDTO.getMotivoConsulta());
        citaMedica.setEstado("PENDIENTE");
        citaMedica.setMonto_consulta(crearCitaDTO.getMontoConsulta());
        return convertirADTO(citaMedicaRepository.save(citaMedica));
    }
    
    @Transactional 
    public CitaMedicaDTO actualizarEstadoCita(Long id, String nuevoEstado) {
        CitaMedica citaMedica = citaMedicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita médica no encontrada"));

        citaMedica.setEstado(nuevoEstado);
        return convertirADTO(citaMedicaRepository.save(citaMedica));
    }

    public CitaMedicaDTO convertirADTO(CitaMedica citaMedica) {
        CitaMedicaDTO citaMedicaDTO = new CitaMedicaDTO();
        citaMedicaDTO.setId(citaMedica.getId());
        citaMedicaDTO.setCodigoCita(citaMedica.getCodigo_cita());
        citaMedicaDTO.setNombrePaciente(citaMedica.getPaciente_id().getId());
        citaMedicaDTO.setNombreDoctor(citaMedica.getDoctor_id().getId());
        citaMedicaDTO.setNivelPrioridad(citaMedica.getNivel_priodidad());
        citaMedicaDTO.setMotivoConsulta(citaMedica.getMotivo_consulta());
        citaMedicaDTO.setEstado(citaMedica.getEstado());
        citaMedicaDTO.setMontoConsulta(citaMedica.getMonto_consulta());
        citaMedicaDTO.setFechaCita(citaMedica.getFecha_cita());

        return citaMedicaDTO;
    }

}
