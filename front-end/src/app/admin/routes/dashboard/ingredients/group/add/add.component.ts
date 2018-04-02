import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.sass']
})
export class IngredientsAddGroupComponent implements OnInit {
  steps: any = [1, 2];
  state = 1;

  constructor() {}

  changeState(step) {
    this.state = step;
  }
  nextStep() {
    this.state++;
  }
  prevStep() {
    this.state--;
  }
  ngOnInit() {
  }


}
