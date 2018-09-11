import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'table2',
  templateUrl: './table2.component.html',
  styleUrls: ['./table2.component.css']
})
export class Table2Component implements OnInit {
  columnDefs = [
  { headerName: 'SO#', field: 'SO#' ,width:90},
  { headerName: 'Last Adj Date', field: 'Last Adj Date' ,width:120 },
  { headerName: 'Last Adj Amt', field: 'Last Adj Amt' ,width:115 },
  { headerName: 'Trans Adj Date', field: 'Trans Adj Date' ,width:125 },
  { headerName: 'Part Num', field: 'Part Num' ,width:95 },
  { headerName: 'Sales Rep#', field: 'Sales Rep#',width:105  },
  { headerName: 'Territory Type', field: 'Territory Type',width:120 },
  { headerName: 'Status', field: 'Status' ,width:80 },
  { headerName: 'Error Reason', field: 'Error Reason',width:155  },
  { headerName: 'Validate', field: 'Validate',width:100 }
];


rowData: any;

constructor(private http: HttpClient) {

}

ngOnInit() {
  this.rowData = this.http.get('https://api.myjson.com/bins/5zvxs');
}
}
