package medtriage_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import medtriage_backend.model.CitaMedica;

@Repository 
public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

    List<CitaMedica> findByNivelPrioridad(@Param("nivelPrioridad") String nivelPrioridad);

    List<CitaMedica> findAllByOrderByFecha_citaDesc();
}
