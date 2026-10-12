import { Routes } from '@angular/router';
import { CitaListComponent } from './cita-list-component/cita-list-component';

export const routes: Routes = [
  { path: 'citas', component: CitaListComponent },
  { path: '', redirectTo: 'citas', pathMatch: 'full' },
];
