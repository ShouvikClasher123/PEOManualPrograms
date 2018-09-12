import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'custom-cell1',
  templateUrl: './custom-cell1.component.html',
  styleUrls: ['./custom-cell1.component.css']
})
export class CustomCell1Component implements OnInit {

  data:any;
  constructor() { }

    agInit(params){
      this.data=params.value;
    }

  ngOnInit() {
  }

}
