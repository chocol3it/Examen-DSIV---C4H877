package medtriage_backend.model;

import jakarta.persistence.*;

@Entity 
@Table(name = "paciente")
public class Paciente {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identificacion", nullable = false, unique = true)
    private String identificacion;

    @Column(name = "nombre_completo", nullable = false)
    private String nombre_completo; 

    @Column (name = "correo", nullable = false)
    private String correo;

    @Column (name = "telefono", nullable = false)
    private String telefono;

    public Paciente() {
    }

    public Paciente(Long id, String identificacion, String nombre_completo, String correo, String telefono) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
}
