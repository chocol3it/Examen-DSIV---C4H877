import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CitaMedica, CrearCitaPayload } from '../models/cita.model';

@Injectable({
  providedIn: 'root',
})
export class CitaService {
  private http = inject(HttpClient);
  private url = 'http://localhost:8080/api/v1/citas';

  getCitas(): Observable<CitaMedica[]> {
    return this.http.get<CitaMedica[]>(this.url);
  }

  getCitasPorPrioridad(prioridad: string): Observable<CitaMedica[]> {
    return this.http.get<CitaMedica[]>(this.url + '/prioridad/' + prioridad);
  }

  crearCita(payload: CrearCitaPayload): Observable<CitaMedica> {
    return this.http.post<CitaMedica>(this.url, payload);
  }

  actualizarEstado(id: number, estado: string): Observable<CitaMedica> {
    return this.http.patch<CitaMedica>(
      this.url + '/' + id + '/estado?nuevoEstado=' + encodeURIComponent(estado),
      {},
    );
  }
}
