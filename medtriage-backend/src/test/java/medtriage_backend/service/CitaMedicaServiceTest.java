package medtriage_backend.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import medtriage_backend.dto.CitaMedicaDTO;
import medtriage_backend.dto.CrearCitaDTO;
import medtriage_backend.model.CitaMedica;
import medtriage_backend.model.Doctor;
import medtriage_backend.model.Paciente;
import medtriage_backend.repository.CitaMedicaRepository;
import medtriage_backend.repository.DoctorRepository;
import medtriage_backend.repository.PacienteRepository;

@ExtendWith(MockitoExtension.class)
public class CitaMedicaServiceTest {

    @Mock private CitaMedicaRepository citaMedicaRepository;
    @Mock private DoctorRepository doctorRepository;
    @Mock private PacienteRepository pacienteRepository;
    @InjectMocks private CitaMedicaService service;

    @Test
    void crearCita() {
        Doctor doctor = new Doctor();
        doctor.setId(124L);

        Paciente paciente = new Paciente();
        paciente.setId(856L);

        CrearCitaDTO datos = new CrearCitaDTO();
        datos.setPacienteId(856L);
        datos.setDoctorId(124L);
        datos.setMotivoConsulta("Dolor de cabeza");
        datos.setMontoConsulta(new BigDecimal("20000"));

        when(pacienteRepository.findById(856L)).thenReturn(Optional.of(paciente));
        when(doctorRepository.findById(124L)).thenReturn(Optional.of(doctor));
        when(citaMedicaRepository.save(any(CitaMedica.class)))
                .thenAnswer(invocacion -> invocacion.getArgument(0));

        CitaMedicaDTO resultado = service.crearCita(datos);

        assertNotNull(resultado);
        assertNotNull(resultado.getCodigoCita());
        assertTrue(resultado.getCodigoCita().startsWith("CIT-2026-"));
    }

}
