import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-second-step',
  templateUrl: './add-second-step.component.html',
  styleUrls: ['./add-second-step.component.sass']
})
export class AddSecondStepComponent implements OnInit {
  isSize = true;
  fieldArray: Array<any> = [];
  newAttribute: any = {};

  constructor() { }
  addRow() {
    this.fieldArray.push(this.newAttribute);
    this.newAttribute = {};
  }
  removeRow(index) {
    if (this.fieldArray.length > 1) {
      this.fieldArray.splice(index, 1);
    }
  }
  toggleSize() {
    this.isSize = !this.isSize;
  }
  ngOnInit() {
    this.addRow();
  }

}
