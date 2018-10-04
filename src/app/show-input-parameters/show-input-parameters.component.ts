import { Component, OnInit } from '@angular/core';
import { GetProgramNamesService } from '../get-program-names.service';

@Component({
  selector: 'show-input-parameters',
  templateUrl: './show-input-parameters.component.html',
  styleUrls: ['./show-input-parameters.component.css']
})
export class ShowInputParametersComponent implements OnInit {

  public isCollapsed:boolean=false;
  selectedProgram:string;
  inputParamsData:any;
  constructor(private getProgramNamesService: GetProgramNamesService) { }

  ngOnInit() {
    this.inputParamsData={};
    this.selectedProgram=localStorage.getItem("ProgName");
    
    this.getProgramNamesService.getInputParams(this.selectedProgram).subscribe(data => { this.inputParamsData = data; console.log(data)}, err => console.error(err), () => console.log('done loading categories'));
  }

}
