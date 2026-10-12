package medtriage_backend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity 
public class CitaMedica {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "codigo_cita", nullable = false, unique = true)
    private String codigo_cita;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente_id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor_id;

    @Column (name = "nivel_priorididad", nullable = false)
    private String nivel_priodidad;

    @Column (name = "motivo_consulta", nullable = false)
    private String motivo_consulta;

    @Column (name = "estado", nullable = false)
    private String estado;

    @Column (name = "monto_consulta", nullable = false)
    private BigDecimal monto_consulta;

    @Column (name = "fecha_cita", nullable = false)
    private LocalDateTime fecha_cita;

    public CitaMedica() {
    }

    public CitaMedica(Long id, String codigo_cita, Paciente paciente_id, Doctor doctor_id, String nivel_priodidad, String motivo_consulta, String estado, BigDecimal monto_consulta, LocalDateTime fecha_cita) {
        this.id = id;
        this.codigo_cita = codigo_cita;
        this.paciente_id = paciente_id;
        this.doctor_id = doctor_id;
        this.nivel_priodidad = nivel_priodidad;
        this.motivo_consulta = motivo_consulta;
        this.estado = estado;
        this.monto_consulta = monto_consulta;
        this.fecha_cita = fecha_cita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo_cita() {
        return codigo_cita;
    }

    public void setCodigo_cita(String codigo_cita) {
        this.codigo_cita = codigo_cita;
    }

    public Paciente getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Paciente paciente_id) {
        this.paciente_id = paciente_id;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Doctor doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getNivel_priodidad() {
        return nivel_priodidad;
    }

    public void setNivel_priodidad(String nivel_priodidad) {
        this.nivel_priodidad = nivel_priodidad;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getMonto_consulta() {
        return monto_consulta;
    }

    public void setMonto_consulta(BigDecimal monto_consulta) {
        this.monto_consulta = monto_consulta;
    }

    public LocalDateTime getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDateTime fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    

    
}
