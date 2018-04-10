import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dish-ingredients',
  templateUrl: './dish-ingredients.component.html',
  styleUrls: ['./dish-ingredients.component.sass']
})
export class DishIngredientsComponent implements OnInit {
  fieldArray: Array<any> = [{id: 1, name: 'Chicken'}, {id: 2, name: 'Chicken'}, {id: 3, name: 'Chicken'}];
  newAttribute: any = {name: 'Chicken', isEdit: true};
  isEdit = true;

  constructor() { }
  addRow() {
    this.fieldArray.push(this.newAttribute);
    this.newAttribute = {name: 'Chicken', isEdit: !this.isEdit};
    this.isEdit = !this.isEdit;
  }
  removeRow(index) {
    if (this.fieldArray.length > 1) {
      this.fieldArray.splice(index, 1);
    }
  }

  ngOnInit() {
  }

}
