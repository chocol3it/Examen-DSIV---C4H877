package medtriage_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import medtriage_backend.model.Doctor;
import medtriage_backend.model.Paciente;

/**
 * PacienteRepositoty
 */
public interface PacienteRepository extends JpaRepository <Paciente, Long>{
        Optional<Paciente> findById(Long id);    

}
