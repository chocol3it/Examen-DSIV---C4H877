import { CommonModule } from '@angular/common';
import { Component, computed, inject, signal } from '@angular/core';

import { CitaMedica } from '../models/cita.model';
import { CitaService } from '../services/cita.service';

@Component({
  selector: 'app-cita-list-component',
  imports: [CommonModule],
  templateUrl: './cita-list-component.html',
  styleUrl: './cita-list-component.css',
})
export class CitaListComponent {
  private citaService = inject(CitaService);

  citas = signal<CitaMedica[]>([]);
  prioridadSeleccionada = signal('TODAS');
  mensajeError = signal('');

  citasFiltradas = computed(() => {
    const prioridad = this.prioridadSeleccionada();

    if (prioridad === 'TODAS') {
      return this.citas();
    }

    return this.citas().filter(cita => cita.nivel_prioridad === prioridad);
  });

  constructor() {
    this.citaService.getCitas().subscribe({
      next: citas => this.citas.set(citas),
      error: () => this.mensajeError.set('No se pudieron cargar las citas.'),
    });
  }

  filtrarPorPrioridad(prioridad: string) {
    this.prioridadSeleccionada.set(prioridad);
  }

  avanzarEstado(cita: CitaMedica) {
    const nuevoEstado = this.obtenerSiguienteEstado(cita.estado);

    if (!nuevoEstado) return;

    this.citaService.actualizarEstado(cita.id, nuevoEstado).subscribe({
      next: citaActualizada =>
        this.citas.update(citas =>
          citas.map(citaActual =>
            citaActual.id === cita.id ? citaActualizada : citaActual
          )
        ),
      error: () => this.mensajeError.set('No se pudo actualizar el estado.'),
    });
  }

  obtenerSiguienteEstado(estado: string) {
    if (estado === 'PENDIENTE') {
      return 'EN_ATENCION';
    }

    if (estado === 'EN_ATENCION') {
      return 'ATENDIDA';
    }

    return '';
  }

}
