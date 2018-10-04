import { Injectable } from '@angular/core';
import { HttpClient } from '../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GetProgramNamesService {
  
  constructor(private http:HttpClient) {}
 
    // Uses http.get() to load data from a single API endpoint
    getNames() {
        return this.http.get('http://localhost:8080/peo/programSetUp/fetchAllProgram');
    }

    getEditData(selectedProgramName) {
      return this.http.get('http://localhost:8080/peo/programSetUp/fetchProgram?programName='+selectedProgramName)
    }

    saveData(data) {
      this.http.post('http://localhost:8080/peo/programSetUp/saveProgram?flag=save',data).subscribe(
        success => { console.log("success"+success) }, error => { console.log("errrr"+error) } ); 
    }

    saveInputParams(data) {
      this.http.post('http://localhost:8080/peo/programInputParam/saveInputParam?flag=save',data).subscribe(
        success => { console.log("success"+success) }, error => { console.log("errrr"+error) } ); 
    }

    updateInputParams(data) {
      this.http.post('http://localhost:8080/peo/programInputParam/saveInputParam?flag=update',data).subscribe(
        success => { console.log("success"+success) }, error => { console.log("errrr"+error) } ); 
    }

    postEditData(data) {
      this.http.post('http://localhost:8080/peo/programSetUp/saveProgram?flag=update',data).subscribe(
        success => { console.log("success"+success) }, error => { console.log("errrr"+error) } ); 
    }

    saveApprovalDetails(data) {
      this.http.post('http://localhost:8080/peo/programApproval/saveApprovalDetail',data).subscribe(
        success => { console.log("success"+success) }, error => { console.log("errrr"+error) } ); 
    }

    getProgramType() {
      return this.http.get('http://localhost:8080/peo/programSetUp/fetchAllProgramType');
    }

    getFilteredData(userId,batchStatus,theatre,fromUpload,toUpload){
      return this.http.get('http://localhost:8080/peo/programApproval/fetchFilteredDetail?userId='+userId+'&batchStatus='+batchStatus+'&theatre='+theatre+'&fromUpload='+fromUpload+'&toUpload='+toUpload);
    }

    approveRejectSelectedRows(data,flag){
      this.http.post('http://localhost:8080/peo/programApproval/editApprovalDetail?programName='+data+'&flag='+flag,'').subscribe(
        success => { console.log("success"+success) }, error => { console.log("errrr"+error) } ); 
    }

    getCategoryType() {
      return this.http.get('http://localhost:8080/peo/programSetUp/fetchAllCategoryType');
    }

    getProgramCategory(selectedType) {
      return this.http.get('http://localhost:8080/peo/programSetUp/fetchAllProgramCategory?categoryType='+selectedType);
    }

    getInputParams(selectedProgramName) {
      return this.http.get('http://localhost:8080/peo/programInputParam/fetchInputParam?programName='+selectedProgramName);
    }
}
