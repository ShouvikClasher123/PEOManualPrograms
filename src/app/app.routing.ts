import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProgramCreationComponent } from './program-creation/program-creation.component';
import { ProgramDetailsComponent } from './program-details/program-details.component';
import { ProgramApprovalComponent } from './program-approval/program-approval.component';
import { ProgramLoginComponent } from './program-login/program-login.component';

const routes: Routes = [
  {
    path: '',
    // redirectTo: 'programCreation',
    redirectTo: 'programLogin',
    pathMatch: 'full'
  },
  { path: 'programLogin', component: ProgramLoginComponent },
  { path: 'programCreation', component: ProgramCreationComponent },
  { path: 'programDetails', component: ProgramDetailsComponent },
  { path: 'programApproval', component: ProgramApprovalComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}