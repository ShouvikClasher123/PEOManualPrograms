import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { GetProgramNamesService } from '../get-program-names.service';
import { HttpClient } from '../../../node_modules/@angular/common/http';

@Component({
  selector: 'program-creation',
  templateUrl: './program-creation.component.html',
  styleUrls: ['./program-creation.component.css']
})
export class ProgramCreationComponent implements OnInit {

  constructor(private http: HttpClient,private formBuilder: FormBuilder, private getProgramNamesService: GetProgramNamesService) { }

  createNewForm: FormGroup;
  editForm: FormGroup;
  inputParamForm: FormGroup;
  selectProgramForm: FormGroup;

  status=0;
  flag1:boolean=false;
  flag2:boolean=false;
  flag3:boolean=false;
  flag4:boolean=false;

  public page1Flag: boolean = true;
  public page2Flag: boolean = false;
  public showFlag: boolean = false;
  public showFlag2: boolean = false;
  public showFlag3: boolean = false;
  public sec2Flag: boolean = false;
  public sec2_NextFlag: boolean = false;
  public sec2_EditFlag: boolean = false;
  public sec3Flag: boolean = false;
  public manualUploadFlag: boolean = false;
  public fileUploadedFlag: boolean=false;
  public names: any;
  public categoryTypes: any;
  public programCategories: any;
  public programTypes: any;
  public editData: any;
  public inputParamsData:any;
  public selectedProgram: string = '';
  public selectedType;
  public category;
  public adjustmentType;
  public selectedFile;
  public validFileFlag:boolean;
  public uploadFlag:boolean=false;

  setManualUploadFlag(val:boolean){
    this.manualUploadFlag=val;
    if(val==true){
      this.sec2_EditFlag=false;this.sec2Flag=false;this.sec2_NextFlag=false;this.sec3Flag=false
    }
    if(val==false){
      // this.sec2_EditFlag=true;
    }
  }

  checkFile(){
    this.uploadFlag=true;
    localStorage.setItem("uploadedFile",this.selectedFile);
    if(this.selectedFile=='Valid Data.xlsx'){
      this.validFileFlag=true;
    }
    else{
      this.validFileFlag=false;
    }
   
  }

  getFileDetails (event) {
      this.selectedFile=event.target.files[0].name;
      var name = event.target.files[0].name;
      var type = event.target.files[0].type;
      var size = event.target.files[0].size;
      var modifiedDate = event.target.files[0].lastModifiedDate;
      
      console.log ('Name: ' + name + "\n" + 
        'Type: ' + type + "\n" +
        'Last-Modified-Date: ' + modifiedDate + "\n" +
        'Size: ' + Math.round(size / 1024) + " KB");
  }

  //event handler for the select element's change event
  selectChangeHandler(event: any) {
    //update the ui
    this.selectedProgram = event.target.value;
    localStorage.setItem("ProgName", this.selectedProgram);
    console.log(this.selectedProgram);
    this.getProgramNamesService.getEditData(this.selectedProgram).subscribe(data => { this.editData = data;console.log(this.editData);
      
      
     this.getProgramNamesService.getProgramCategory(this.editData.categoryType).subscribe(data => { this.programCategories = data; console.log('categoryType category',data);  
     
     setTimeout(() => {    //<<<---    using ()=> syntax
     
    
     this.editForm.controls["category"].setValue(this.editData.category);

    }, 500);
    
    }, err => console.log(err), () => console.log('done loading cate typr'));

     this.editForm.patchValue({
        
      adjustmentType:this.editData.adjustmentType,
      approverId:this.editData.approverId,
      categoryType:this.editData.categoryType,
      programType: this.editData.programType
      // category:this.editData.category

   }); 
   
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
    this.getProgramNamesService.getInputParams(this.selectedProgram).subscribe(data => { this.inputParamsData = data; 
      this.inputParamForm.patchValue({
        programName: this.selectedProgram,
        fromPid: this.inputParamsData.fromPid,
        toPid: this.inputParamsData.toPid,
        soNum: this.inputParamsData.soNum,
        territoryType: this.inputParamsData.territoryType,
        transGroupCode: this.inputParamsData.transGroupCode
        
  
     }); 
      console.log(data)}, err => console.error(err), () => console.log('done loading input params'));
    
    // this.inputParamForm.controls["fromPid"].setValue(this.inputParamsData.fromPid);
  }

    //event handler for the select element's change event
    // selectChangeHandler2(event: any) {
    //   //update the ui
    //   this.selectedProgram = event.target.value;
    //   localStorage.setItem("ProgName", this.selectedProgram);
    //   this.getProgramNamesService.getInputParams(this.selectedProgram).subscribe(data => { this.inputParamsData = data; console.log(data)}, err => console.error(err), () => console.log('done loading categories'));
      
    // }


    selectChangeHandler2(event: any) {
      //update the ui
      this.selectedType = event.target.value;
      console.log(this.selectedType);
      this.getProgramNamesService.getProgramCategory(this.selectedType).subscribe(data => { this.programCategories = data; console.log('categoryType category',data)}, err => console.log(err), () => console.log('done loading cate typr'));
    
    }  


  ngOnInit() {

    var self = this;
    this.editData = {};
    this.inputParamsData = {};

    // if(localStorage.getItem("page1")!="null" && localStorage.getItem("page2")!="null"){
    //   this.page1Flag=false;
    //   this.page2Flag=true;
    //   this.getProgramNamesService.getInputParams(this.selectedProgram).subscribe(data => { this.inputParamsData = data; console.log(data)}, err => console.error(err), () => console.log('done loading categories'));
      
    // }
    this.selectedProgram=localStorage.getItem("ProgName");
    this.getProgramNamesService.getNames().subscribe(data => { self.names = data; }, err => console.error(err), () => console.log('done loading names'));
    this.getProgramNamesService.getCategoryType().subscribe(data => { self.categoryTypes = data; }, err => console.error(err), () => console.log('done loading types'));
    this.getProgramNamesService.getProgramType().subscribe(data => { self.programTypes = data; }, err => console.error(err), () => console.log('done loading prog types'));
   

    this.createNewForm = this.formBuilder.group({

      year: [self.editData.year, [Validators.required]],
      terrType: [null, [Validators.required]],
      fet: [null, [Validators.required]],
      uniqueName: [null, [Validators.required]],
      programType: [null, [Validators.required]],
      adjustmentType: [null, [Validators.required]],
      approverId: [null, [Validators.required]],
      categoryType: [self.editData.categoryType, [Validators.required]],
      category: [self.editData.category, [Validators.required]]

    });



    this.editForm = this.formBuilder.group({
      year: [self.editData.year, [Validators.required]],
      terrType: [null, [Validators.required]],
      fet: [null, [Validators.required]],
      uniqueName: [null, [Validators.required]],
      programType: [null, [Validators.required]],
      adjustmentType: [null, [Validators.required]],
      approverId: [null, [Validators.required]],
      categoryType: [self.editData.categoryType, [Validators.required]],
      category: [, [Validators.required]]

    });

    this.inputParamForm = this.formBuilder.group({
      programName: [null, ],
      fromPid: [null, [Validators.required]],
      toPid: [null, [Validators.required]],
      soNum: [null, ],
      territoryType: [null, ],
      transGroupCode: [null, ],

    });

    this.selectProgramForm = this.formBuilder.group({
      programName: [null, [Validators.required]]
    })
  }

  showFormData() {
    var self = this;
    // alert(JSON.stringify(this.createNewForm.value));
    this.getProgramNamesService.saveData(this.createNewForm.value);

    

    setTimeout(() => {
      this.getProgramNamesService.getNames().subscribe(data => { this.names = data; }, err => console.error(err), () => console.log('done reloading names'));
      this.displayMsg();
    }, 1500);
  }

  showFormData2() {
    // alert(JSON.stringify(this.editForm.value));
    this.getProgramNamesService.postEditData(this.editForm.value);
    this.showFlag2 = true;

    

    setTimeout(() => {    //<<<---    using ()=> syntax
      this.showFlag2 = false;
    }, 4000);
  }

  showFormData3(){
   
    this.inputParamForm.controls["programName"].setValue(this.selectedProgram);
    // alert(JSON.stringify(this.inputParamForm.value));
    console.log("params:",this.inputParamsData);
    
    this.getProgramNamesService.updateInputParams(this.inputParamForm.value);

    setTimeout(() => {    //<<<---    using ()=> syntax
    this.getProgramNamesService.getEditData(this.selectedProgram).subscribe(data => { this.editData = data;console.log(this.editData);
    
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
  }, 1500);

    this.showFlag3 = true;
    setTimeout(() => {    //<<<---    using ()=> syntax
      this.showFlag3 = false;
    }, 4000);
    

  }




  displayMsg() {
    this.showFlag = true;
    setTimeout(() => {    //<<<---    using ()=> syntax
      this.showFlag = false;
    }, 4000);
  }
}
