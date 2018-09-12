import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'show-input-parameters',
  templateUrl: './show-input-parameters.component.html',
  styleUrls: ['./show-input-parameters.component.css']
})
export class ShowInputParametersComponent implements OnInit {

  public isCollapsed:boolean=false;

  constructor() { }

  ngOnInit() {
  }

}
