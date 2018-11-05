import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { GetProgramNamesService } from '../get-program-names.service';
import { FormGroup, FormBuilder, Validators } from '../../../node_modules/@angular/forms';
import { AgGridNg2 } from 'ag-grid-angular';

@Component({
  selector: 'program-approval',
  templateUrl: './program-approval.component.html',
  styleUrls: ['./program-approval.component.css']
})
export class ProgramApprovalComponent implements OnInit {
  loginUser: string;
  selectedProgram: string;
  editData: any;
  cleanTable: boolean = false;
  isCollapsed: boolean = true;
  isCollapsed2: boolean = false;
  filterForm: FormGroup;
  clickedProgram: string;
  @ViewChild('agGrid') agGrid: AgGridNg2;
  @ViewChild('agGrid2') agGrid2: AgGridNg2;

  btExport1(){
    var params = {
      skipHeader: false,
      skipFooters: true,
      skipGroups: true,
      fileName: "Approval_Summary.csv"
  };
    this.agGrid.gridOptions.api.exportDataAsCsv(params);
  }

  btExport2(){
    var params = {
      skipHeader: false,
      skipFooters: true,
      skipGroups: true,
      fileName: "To_Be_Approved_Summary.csv"
  };
    this.agGrid2.gridOptions.api.exportDataAsCsv(params);
  }

  getSelectedRows(flag) {
    const selectedNodes = this.agGrid.api.getSelectedNodes();
    const selectedData = selectedNodes.map(node => node.data);
    const selectedDataStringPresentation = selectedData.map(node => node.programName).join(',');
    // alert(selectedDataStringPresentation);
    this.getProgramNamesService.approveRejectSelectedRows(selectedDataStringPresentation,flag)
    setTimeout(() => {
      this.rowData1 = this.http.get('http://localhost:8080/peo/programApproval/fetchApprovalDetail?userId=admin&role=admin')
    },500);
  }


  onRowClicked(event: any) {
    console.log(event.data.programName);
    this.clickedProgram=event.data.programName;
    this.cleanTable = true;
    this.rowData3 = this.http.get('http://localhost:8080/peo/programData/fetchValidData?programName=' + event.data.programName + '&status=CLEAN');
  }

  columnDefs1 = [
    {
      headerName: '', field: '', width: 40, cellStyle: { 'text-align': 'center' }, checkboxSelection: function (params) {
        // add your cancheck-logic here
        if (params.data.status == 'Pending') {
          return true;
        }
        return false;
      }
    },
    { headerName: 'Program Name', field: 'programName', width: 300, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Approved On', field: 'approvedOn', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Adjustment Type', field: 'adjustmentType', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Uploaded By', field: 'uploadedBy', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'File Name', field: 'fileName', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Total Transactions', field: 'totalTransaction', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Status', field: 'status', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Upload Comments', field: 'uploadComment', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Approver Comments', field: 'approverComment', width: 155, cellStyle: { 'text-align': 'center' } },



  ];


  columnDefs2 = [
    { headerName: 'Program Name', field: 'programName', width: 300, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Approved On', field: 'approvedOn', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Adjustment Type', field: 'adjustmentType', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Uploaded By', field: 'uploadedBy', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Approver', field: 'approver', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'File Name', field: 'fileName', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Total Transactions', field: 'totalTransaction', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Status', field: 'status', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Upload Comments', field: 'uploadComment', width: 155, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Approver Comments', field: 'approverComment', width: 155, cellStyle: { 'text-align': 'center' } },




  ];

  columnDefs3 = [
    { headerName: 'SO Number', field: 'soNum', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Transaction Number', field: 'transNumber', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Book Date', field: 'bookDateBonusEarnedDate', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Transaction Date', field: 'trxDateBonusPaidDate', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Part Number', field: 'partNumber', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Sales Val Pymnt Amt', field: 'salesValuePymntAmt', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Split Percentage', field: 'splitPercentage', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Trans Group Code', field: 'transGroupCode', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'SalesRep Number', field: 'salesrepNumber', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Share Segment 1', field: 'shareSegment1', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Territory Type', field: 'territoryType', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Hierarchy Name', field: 'hierarchyName', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Roll Up Flag', field: 'rollUpFlag', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Service Type', field: 'serviceType', width: 158, cellStyle: { 'text-align': 'center' } },
    { headerName: 'Currency Code', field: 'currencyCode', width: 158, cellStyle: { 'text-align': 'center' } },


  ];

  status = 0;
  flag1: boolean = false;
  flag2: boolean = false;
  flag3: boolean = false;
  flag4: boolean = false;

  pageSize = 5;
  progName = localStorage.getItem("ProgName");
  rowData1: any;
  rowData2: any;
  rowData3: any;

  selectChangeHandler(event: any) {
    //update the ui
    this.pageSize = event.target.value;
    alert(this.pageSize);

  }

  setPage() {
    localStorage.setItem("page1", "false");
    localStorage.setItem("page2", "true");
  }

  showFilterFormData() {
    this.rowData1 = this.getProgramNamesService.getFilteredData(this.filterForm.value.userId, this.filterForm.value.batchStatus, this.filterForm.value.theatre, this.filterForm.value.fromUpload, this.filterForm.value.toUpload);

  }

  constructor(private http: HttpClient, private getProgramNamesService: GetProgramNamesService, private formBuilder: FormBuilder) {
    console.log(this.pageSize);
  }

  ngOnInit() {
    this.editData = {};
    this.loginUser = localStorage.getItem("userName");
    this.selectedProgram = localStorage.getItem("ProgName");

    this.filterForm = this.formBuilder.group({

      userId: [null, [Validators.required]],
      batchStatus: [null, [Validators.required]],
      theatre: [null, [Validators.required]],
      fromUpload: [null, [Validators.required]],
      toUpload: [null, [Validators.required]]

    });
    this.filterForm.patchValue({

      userId: this.loginUser,
      batchStatus: 'All',
      theatre: 'APJC',
      fromUpload: '2018-10-01',
      toUpload: '2018-10-01'
    });

    this.rowData1 = this.http.get('http://localhost:8080/peo/programApproval/fetchApprovalDetail?userId=admin&role=admin');
    this.rowData2 = this.http.get('http://localhost:8080/peo/programApproval/fetchApprovalDetail?userId=' + this.loginUser + '&role=user');

    this.getProgramNamesService.getEditData(this.selectedProgram).subscribe(data => {
      this.editData = data;
      // this.status = this.editData.status;

      // console.log(this.editData.status);

      // if (this.status == 1) {
      //   this.flag3 = false; this.flag4 = false;
      //   this.flag2 = false; this.flag1 = true;
      // }
      // else if (this.status == 2) {
      //   this.flag2 = true; this.flag1 = true;
      //   this.flag3 = false; this.flag4 = false;
      // }
      // else if (this.status == 3) {
      //   this.flag3 = true; this.flag4 = false;
      //   this.flag2 = true; this.flag1 = true;
      // }
      // else if (this.status == 4) {
      //   this.flag3 = true; this.flag4 = true;
      //   this.flag2 = true; this.flag1 = true;
      // }

    }, err => console.error(err), () => console.log('done loading edit data'));

  }




}
