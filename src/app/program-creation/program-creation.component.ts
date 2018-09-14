import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GetProgramNamesService } from '../get-program-names.service';

@Component({
  selector: 'program-creation',
  templateUrl: './program-creation.component.html',
  styleUrls: ['./program-creation.component.css']
})
export class ProgramCreationComponent implements OnInit {

  constructor(private formBuilder:FormBuilder, private getProgramNamesService:GetProgramNamesService) { }

  createNewForm: FormGroup;
  selectProgramForm: FormGroup;

  public showFlag:boolean=false;
  public sec2Flag:boolean=false;
  public sec2_1Flag:boolean=false;
  public sec3Flag:boolean=false;
  private names:any;
  private programTypes:any;
  private programCategories:any;

  public selectedProgram: string = '';

  //event handler for the select element's change event
  selectChangeHandler (event: any) {
    //update the ui
    this.selectedProgram = event.target.value;
    localStorage.setItem("ProgName", this.selectedProgram);
  }

  

  ngOnInit() {

    var self=this;
    this.getProgramNamesService.getNames().subscribe(data => { self.names = data; },err => console.error(err),() => console.log('done loading names'));
    this.getProgramNamesService.getProgramType().subscribe(data => { self.programTypes = data; },err => console.error(err),() => console.log('done loading types'));
    this.getProgramNamesService.getProgramCategory().subscribe(data => { self.programCategories = data; },err => console.error(err),() => console.log('done loading categories'));
        

    this.createNewForm = this.formBuilder.group({
      year: [null, [Validators.required]],
      terrType: [null, [Validators.required]],
      fet: [null, [Validators.required]],
      uniqueName: [null, [Validators.required]],
      type: [null, [Validators.required]],
      category: [null, [Validators.required]],
      
    });

    this.selectProgramForm = this.formBuilder.group({
      programName:[null, [Validators.required]]
    })
  }

  showFormData(){
    var self=this;
    this.getProgramNamesService.saveData(this.createNewForm.value);
    setTimeout(()=>{
    this.getProgramNamesService.getNames().subscribe(data => { self.names = data; },err => console.error(err),() => console.log('done reloading names'));
    this.displayMsg();
    },500);
  }

  displayMsg(){
    this.showFlag=true;
    setTimeout(()=>{    //<<<---    using ()=> syntax
      this.showFlag = false;
 }, 4000);
  }
}
