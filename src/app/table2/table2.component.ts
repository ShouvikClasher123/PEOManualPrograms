import { Component, OnInit , ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CustomCell1Component } from '../custom-cell1/custom-cell1.component';
import { CustomCell2Component } from '../custom-cell2/custom-cell2.component';
import { AgGridNg2 } from 'ag-grid-angular';

@Component({
  selector: 'table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component implements OnInit {

  @ViewChild('agGrid2') agGrid2: AgGridNg2;
  btExport2(){
    var params = {
      skipHeader: false,
      skipFooters: true,
      skipGroups: true,
      fileName: "Error_Data.csv"
  };
    this.agGrid2.gridOptions.api.exportDataAsCsv(params);
  }

  

  columnDefs = [
    { headerName: '', field: '' ,width:40,cellStyle: {'text-align':'center'},checkboxSelection: true,},
    { headerName: 'Sequence Number', field: 'seqNo' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: 'SO Number', field: 'soNum' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: 'Transaction Number', field: 'transNumber' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: '&nbsp&nbsp&nbsp&nbsp&nbspBook Date', field: 'bookDateBonusEarnedDate' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Transaction Date', field: 'trxDateBonusPaidDate' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Part Number', field: 'partNumber' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Sales Val Pymnt Amt', field: 'salesValuePymntAmt' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Split Percentage', field: 'splitPercentage' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Trans Group Code', field: 'transGroupCode' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'SalesRep Number', field: 'salesrepNumber' ,width:158 ,
    cellStyle: function (params) {
      if (params.value == '' || params.value== null) {
        return { 'background-color': 'rgba(255,0,0,0.3)', 'border-radius': '2px' ,'text-align':'center'};
      }
    }},
    { headerName: 'Share Segment 1', field: 'shareSegment1' ,width:158 ,
    cellStyle: function (params) {
      if (params.value == '' || params.value== null) {
        return { 'background-color': 'rgba(255,0,0,0.3)', 'border-radius': '2px' ,'text-align':'center'};
      }
    }},
    { headerName: 'Territory Type', field: 'territoryType' ,width:158 , cellStyle: {'text-align':'center'}},
    { headerName: 'Hierarchy Name', field: 'hierarchyName' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Roll Up Flag', field: 'rollUpFlag' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Service Type', field: 'serviceType' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Currency Code', field: 'currencyCode' ,width:158 ,cellStyle: {'text-align':'center'}},
    
    

    { headerName: 'Status', field: 'status', width: 158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Error Reason', field: 'errorMessage', width: 158, cellRendererFramework: CustomCell1Component ,cellStyle: {'text-align':'center'}},
    { headerName: 'Validate', field: 'validateLink', width: 158, cellRendererFramework: CustomCell2Component ,cellStyle: {'text-align':'center'}}
  ];


  progName=localStorage.getItem("ProgName")
  rowData: any;


  constructor(private http: HttpClient) {
    
  }

  ngOnInit() {
    this.rowData = this.http.get('http://localhost:8080/peo/programData/fetchValidData?programName='+this.progName+'&status=ERROR');
  }
}
