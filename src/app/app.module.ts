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
import { AppRoutingModule } from './app.routing';
import { HttpModule } from '../../node_modules/@angular/http';
import { CustomCell1Component } from './custom-cell1/custom-cell1.component';

@NgModule({
  declarations: [
    AppComponent,
    ProgramCreationComponent,
    ProgramDetailsComponent,
    Table2Component,
    Table3Component,
    ShowInputParametersComponent,
    CustomCell1Component
  ],
  imports: [AppRoutingModule, HttpModule, BrowserModule, HttpClientModule, AgGridModule.withComponents([ProgramDetailsComponent])],
  providers: [],
  entryComponents: [CustomCell1Component],
  bootstrap: [AppComponent]
})
export class AppModule { }
