import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProgramCreationComponent } from './program-creation/program-creation.component';
import { ProgramDetailsComponent } from './program-details/program-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ProgramCreationComponent,
    ProgramDetailsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
