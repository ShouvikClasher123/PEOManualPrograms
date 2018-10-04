import { Component, OnInit,ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GetProgramNamesService } from '../get-program-names.service';
import { Router } from '../../../node_modules/@angular/router';
import { AgGridNg2 } from 'ag-grid-angular';

@Component({
  selector: 'program-details',
  templateUrl: './program-details.component.html',
  styleUrls: ['./program-details.component.css']
})
export class ProgramDetailsComponent implements OnInit {

  @ViewChild('agGrid1') agGrid1: AgGridNg2;
  btExport1(){
    var params = {
      skipHeader: false,
      skipFooters: true,
      skipGroups: true,
      fileName: "Final_Data.csv"
  };
    this.agGrid1.gridOptions.api.exportDataAsCsv(params);
  }
  
  selectedProgram:string;
  editData:any;
    columnDefs = [
    { headerName: 'Sequence Number', field: 'seqNo' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: 'SO Number', field: 'soNum' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: 'Transaction Number', field: 'transNumber' ,width:158,cellStyle: {'text-align':'center'}},
    { headerName: '&nbsp&nbsp&nbsp&nbsp&nbspBook Date', field: 'bookDateBonusEarnedDate' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Transaction Date', field: 'trxDateBonusPaidDate' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Part Number', field: 'partNumber' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Sales Val Pymnt Amt', field: 'salesValuePymntAmt' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Split Percentage', field: 'splitPercentage' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Trans Group Code', field: 'transGroupCode' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'SalesRep Number', field: 'salesrepNumber' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Share Segment 1', field: 'shareSegment1' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Territory Type', field: 'territoryType' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Hierarchy Name', field: 'hierarchyName' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Roll Up Flag', field: 'rollUpFlag' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Service Type', field: 'serviceType' ,width:158 ,cellStyle: {'text-align':'center'}},
    { headerName: 'Currency Code', field: 'currencyCode' ,width:158 ,cellStyle: {'text-align':'center'}},
    
    
  ];
  status=0;
  flag1:boolean=false;
  flag2:boolean=false;
  flag3:boolean=false;
  flag4:boolean=false;

  pageSize=5;
  progName=localStorage.getItem("ProgName");
  rowData: any;


 

   selectChangeHandler (event: any) {
    //update the ui
    this.pageSize = event.target.value;
    alert(this.pageSize);
    
  }

  setPage(){
    localStorage.setItem("page1","false");
    localStorage.setItem("page2","true");
  }

 

  showApprovalDetails(){
    var json={
      "adjustmentType": this.editData.adjustmentType,
      "approver": this.editData.approverId,
      "fileName": localStorage.getItem("uploadedFile"),
      "programName": localStorage.getItem("ProgName"),
      "theatre": this.editData.terrType,
      "uploadComment": "",
      "uploadedBy": localStorage.getItem("userName")
    };
    // alert(JSON.stringify(this.editData));
    // console.log(JSON.stringify(json));
    this.getProgramNamesService.saveApprovalDetails(json);
    this.router.navigate(['/programApproval']);
  }

  constructor(private http: HttpClient, private getProgramNamesService:GetProgramNamesService,private router:Router) {
    console.log(this.pageSize);
  }

  ngOnInit() {
    this.editData={};
    this.selectedProgram=localStorage.getItem("ProgName");
    
     this.rowData = this.http.get('http://localhost:8080/peo/programData/fetchValidData?programName='+this.progName+'&status=CLEAN');
  
    this.getProgramNamesService.getEditData(this.selectedProgram).subscribe(data => { this.editData = data;
      this.status=this.editData.status;

      console.log(this.editData.status);
     
     if(this.status==1){
       this.flag3=false;this.flag4=false;
       this.flag2=false; this.flag1=true;
     }
     else if(this.status==2){
       this.flag2=true; this.flag1=true;
       this.flag3=false;this.flag4=false;
     }
     else if(this.status==3){
       this.flag3=true;this.flag4=false;
       this.flag2=true; this.flag1=true;
     }
     else if(this.status==4){
       this.flag3=true;this.flag4=true;
       this.flag2=true; this.flag1=true;
     }
 
    }, err => console.error(err), () => console.log('done loading edit data'));
  
  }

  


}
