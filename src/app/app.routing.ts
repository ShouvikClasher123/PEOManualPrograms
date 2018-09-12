import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProgramCreationComponent } from './program-creation/program-creation.component';
import { ProgramDetailsComponent } from './program-details/program-details.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'programCreation',
    pathMatch: 'full'
  },
  { path: 'programCreation', component: ProgramCreationComponent },
  { path: 'programDetails', component: ProgramDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}