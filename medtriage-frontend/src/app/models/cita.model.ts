export interface CitaMedica {
    id : number,
    codigo_cita : string,
    paciente_id : string,
    doctor_id : string,
    nivel_prioridad : string,
    motivo_consulta : string,
    estado : string,
    monto_consulta : number,
    fecha_cita : string

}
export interface Doctor {
    id : number,
    nombre : string,
    especialidad : string,
    disponible : boolean

}

export interface Paciente {
    id : number, 
    identificacion : string,
    nombre_completo : string,
    correo : string,
    telefono : string

}

export interface CrearCitaPayload{
    pacienteId : number,
    doctorId : number,
    nivelPrioridad : 'ALTA' | 'MEDIA' | 'BAJA';
    motivoConsulta : string,
    montoConsulta : number

}