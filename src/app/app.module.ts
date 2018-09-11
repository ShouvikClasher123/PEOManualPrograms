import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ProgramCreationComponent } from './program-creation/program-creation.component';
import { ProgramDetailsComponent } from './program-details/program-details.component';
import { Table2Component } from './table2/table2.component';
import { Table3Component } from './table3/table3.component';
import { ShowInputParametersComponent } from './show-input-parameters/show-input-parameters.component';

@NgModule({
  declarations: [
    AppComponent,
    ProgramCreationComponent,
    ProgramDetailsComponent,
    Table2Component,
    Table3Component,
    ShowInputParametersComponent
  ],
  imports: [BrowserModule, HttpClientModule, AgGridModule.withComponents([ProgramDetailsComponent])],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
