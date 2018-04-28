import { Component, OnInit, OnChanges } from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.sass']
})
export class CategoriesAddComponent implements OnInit {
  steps: any = [1, 2, 3, 4];
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
