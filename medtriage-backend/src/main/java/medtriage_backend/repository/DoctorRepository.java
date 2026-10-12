package medtriage_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import medtriage_backend.model.Doctor;
import java.util.List;
import java.util.Optional;


/**
 * DoctorRepository
 */
public interface DoctorRepository extends JpaRepository <Doctor, Long>{

    Optional<Doctor> findById(Long id);    
}