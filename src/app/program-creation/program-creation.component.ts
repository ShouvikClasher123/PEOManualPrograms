import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'program-creation',
  templateUrl: './program-creation.component.html',
  styleUrls: ['./program-creation.component.css']
})
export class ProgramCreationComponent implements OnInit {

  constructor() { }

  public showFlag:boolean=false;

  ngOnInit() {
  }

  displayMsg(){
    this.showFlag=true;
    setTimeout(()=>{    //<<<---    using ()=> syntax
      this.showFlag = false;
 }, 4000);
  }
}
