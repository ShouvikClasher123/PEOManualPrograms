import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'table3',
  templateUrl: './table3.component.html',
  styleUrls: ['./table3.component.css']
})
export class Table3Component implements OnInit {

  columnDefs = [
    { headerName: 'SO#', field: 'SO#' ,width:158},
    { headerName: 'Last Adj Date', field: 'Last Adj Date' ,width:158 },
    { headerName: 'Last Adj Amt', field: 'Last Adj Amt' ,width:158 },
    { headerName: 'Trans Adj Date', field: 'Trans Adj Date' ,width:158 },
    { headerName: 'Part Num', field: 'Part Num' ,width:158 },
    { headerName: 'Sales Rep#', field: 'Sales Rep#',width:158  },
    { headerName: 'Territory Type', field: 'Territory Type',width:158 }
  ];


  rowData: any;
  public isCollapsed:boolean=true;

  constructor(private http: HttpClient) {

  }

  ngOnInit() {
    this.rowData = this.http.get('https://api.myjson.com/bins/rjs1c');
  }
}
