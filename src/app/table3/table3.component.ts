import { Component, OnInit,ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AgGridNg2 } from 'ag-grid-angular';

@Component({
  selector: 'table3',
  templateUrl: './table3.component.html',
  styleUrls: ['./table3.component.css']
})
export class Table3Component implements OnInit {

  public isCollapsed:boolean;
  @ViewChild('agGrid3') agGrid3: AgGridNg2;
  btExport3(){
    var params = {
      skipHeader: false,
      skipFooters: true,
      skipGroups: true,
      fileName: "Exception_Data.csv"
  };
    this.agGrid3.gridOptions.api.exportDataAsCsv(params);
  }

  columnDefs = [
    { headerName: 'SO Number', field: 'soNum' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: 'Fiscal Year', field: 'fiscalYear' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: 'Source Trans Date', field: 'sourceTransactionDate' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: 'SalesRep Number', field: 'salesrepNumber' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Territory Name', field: 'territoryName' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Territory Type', field: 'territoryType' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Part Number', field: 'partNumber' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Service Type', field: 'serviceType' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'RO Flag', field: 'roFlag' ,width:158 ,cellStyle: {'text-align':'center'}},
    
    { headerName: 'Commission Status', field: 'commissionStatus' ,width:158 ,cellStyle: {'text-align':'center'}},
    
    
    { headerName: 'REV', field: 'rev' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Exception Type', field: '' ,width:158 ,cellStyle: {'text-align':'center'}},
    
    

    ];

  progName=localStorage.getItem("ProgName")
  rowData: any;


  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.rowData = this.http.get('http://localhost:8080/peo/programData/fetchValidData?programName='+this.progName+'&status=EXCEPTION');
  }
}
