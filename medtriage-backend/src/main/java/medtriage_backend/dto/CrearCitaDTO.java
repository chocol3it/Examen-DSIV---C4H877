package medtriage_backend.dto;

import java.math.BigDecimal;

public class CrearCitaDTO {
    private Long pacienteId;
    private Long doctorId;
    private enum nivelPrioridad {
        ALTA,
        MEDIA,
        BAJA
    }
    private String motivoConsulta;
    private BigDecimal montoConsulta;

    public CrearCitaDTO() {
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public BigDecimal getMontoConsulta() {
        return montoConsulta;
    }

    public void setMontoConsulta(BigDecimal montoConsulta) {
        this.montoConsulta = montoConsulta;
    } 

    

    
}
