import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';
import { ChartsModule } from 'ng2-charts';

import { AppComponent } from './app.component';
import { ProgramCreationComponent } from './program-creation/program-creation.component';
import { ProgramDetailsComponent } from './program-details/program-details.component';
import { Table2Component } from './table2/table2.component';
import { Table3Component } from './table3/table3.component';
import { ShowInputParametersComponent } from './show-input-parameters/show-input-parameters.component';
import { AppRoutingModule } from './app.routing';
import { HttpModule } from '../../node_modules/@angular/http';
import { CustomCell1Component } from './custom-cell1/custom-cell1.component';
import { CustomCell2Component } from './custom-cell2/custom-cell2.component';
import { FormsModule, ReactiveFormsModule } from '../../node_modules/@angular/forms';
import { ProgramApprovalComponent } from './program-approval/program-approval.component';
import { ProgramLoginComponent } from './program-login/program-login.component';
import { PieChartComponent } from './pie-chart/pie-chart.component';
import { LineChartComponent } from './line-chart/line-chart.component';
import { BarChartComponent } from './bar-chart/bar-chart.component';

@NgModule({
  declarations: [
    AppComponent,
    ProgramCreationComponent,
    ProgramDetailsComponent,
    Table2Component,
    Table3Component,
    ShowInputParametersComponent,
    CustomCell1Component,
    CustomCell2Component,
    ProgramApprovalComponent,
    ProgramLoginComponent,
    PieChartComponent,
    LineChartComponent,
    BarChartComponent
  ],
  imports: [AppRoutingModule, HttpModule, BrowserModule, ChartsModule, FormsModule, ReactiveFormsModule.withConfig({warnOnNgModelWithFormControl: 'never'}),HttpClientModule, AgGridModule.withComponents([ProgramDetailsComponent])],
  providers: [],
  entryComponents: [CustomCell1Component,CustomCell2Component],
  bootstrap: [AppComponent]
})
export class AppModule { }
