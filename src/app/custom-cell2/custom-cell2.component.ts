import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-custom-cell2',
  templateUrl: './custom-cell2.component.html',
  styleUrls: ['./custom-cell2.component.css']
})
export class CustomCell2Component implements OnInit {
  data:any;
  constructor() { }

    agInit(params){
      this.data=params.value;
    }

  ngOnInit() {
  }

}
