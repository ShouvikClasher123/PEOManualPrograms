import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CustomCell1Component } from '../custom-cell1/custom-cell1.component';
import { CustomCell2Component } from '../custom-cell2/custom-cell2.component';
import { isNull } from '../../../node_modules/@angular/compiler/src/output/output_ast';

@Component({
  selector: 'table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component implements OnInit {
  columnDefs = [
    {
      headerName: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  SO#', field: 'SO#', width: 120
      , checkboxSelection: true 
    },
    { headerName: 'Last Adj Date', field: 'Last Adj Date', width: 120 },
    { headerName: 'Last Adj Amt', field: 'Last Adj Amt', width: 115 },
    { headerName: 'Trans Adj Date', field: 'Trans Adj Date', width: 125 },
    { headerName: 'Part Num', field: 'Part Num', width: 95 },
    { headerName: 'Sales Rep#', field: 'Sales Rep#', width: 105 },
    {
      headerName: 'Territory Type', field: 'Territory Type', width: 120,
      cellStyle: function (params) {
        if (params.value == '') {
          return { 'background-color': 'rgba(255,0,0,0.3)', 'border-radius': '2px' };
        }
      },
      editable: function (params) {
        if (params.value=='') {
          return true;
        }
      }
    },
    { headerName: 'Status', field: 'Status', width: 80 },
    { headerName: 'Error Reason', field: 'Error Reason', width: 133, cellRendererFramework: CustomCell1Component },
    { headerName: 'Validate', field: 'Validate', width: 90, cellRendererFramework: CustomCell2Component }
  ];


  rowData: any;

  constructor(private http: HttpClient) {

  }

  ngOnInit() {
    var self = this;
    this.rowData = this.http.get('https://api.myjson.com/bins/5zvxs');
  }
}
