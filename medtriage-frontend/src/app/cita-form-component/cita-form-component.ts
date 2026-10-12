import { Component, inject } from '@angular/core';
import { CitaMedica } from '../models/cita.model';
import { CitaService } from '../services/cita.service';

@Component({
  selector: 'app-cita-form-component',
  imports: [],
  templateUrl: './cita-form-component.html',
  styleUrl: './cita-form-component.css',
})
export class CitaFormComponent {
  private CitaService = inject(CitaService)

}
