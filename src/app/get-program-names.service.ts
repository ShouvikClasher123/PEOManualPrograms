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

    saveData(data) {
      this.http.post('http://localhost:8080/peo/programSetUp/saveProgram',data).subscribe(
        success => { console.log("success"+success) }, error => { console.log("errrr"+error) } ); 
    }

    getProgramType() {
      return this.http.get('http://localhost:8080/peo/programSetUp/fetchAllProgramType');
    }

    getProgramCategory() {
      return this.http.get('http://localhost:8080/peo/programSetUp/fetchAllProgramCategory');
    }
}
