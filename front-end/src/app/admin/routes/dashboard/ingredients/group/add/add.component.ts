import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.sass']
})
export class IngredientsAddGroupComponent implements OnInit {
  steps: any = [1, 2];
  state = 1;
  isAddProperty = false;
  editMode = false;
  editModeIndex = 0;
  properties: any = [];

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
  togglePropertyForm(state) {
    this.isAddProperty = state;
  }
  addProperty(data) {
    this.properties.push(data);
    this.togglePropertyForm(false);
  }
  deleteProperty(i) {
    this.properties.splice(i, 1);
  }
  edit(data) {
    this.properties[this.editModeIndex] = data;
    this.editMode = false;
    this.togglePropertyForm(false);
  }
  openEdit(data, index) {
    this.editMode = data;
    this.editModeIndex = index;
    this.togglePropertyForm(true);
  }
  ngOnInit() {
  }

}
