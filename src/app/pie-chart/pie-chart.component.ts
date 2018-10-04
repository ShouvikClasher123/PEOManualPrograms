import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  public pieChartLabels:string[] = ['Attainment Uploads', 'No. Of Orders Adjusted', 'Programs Adjusted'];
  public pieChartData:number[] = [300, 500, 100];
  public pieChartType:string = 'pie';
  public chartColors: Array<any> = [
    { // all colors in order
      backgroundColor: [
        'rgba(255, 0, 0, 0.5)',
        'rgba(0, 255, 0, 0.5)',
        'rgba(3, 169, 244, 0.5)'
        ]
    }
]
 
  // events
  public chartClicked(e:any):void {
    console.log(e);
  }
 
  public chartHovered(e:any):void {
    console.log(e);
  }
}
