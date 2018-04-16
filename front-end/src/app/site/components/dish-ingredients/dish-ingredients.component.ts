import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-dish-ingredients',
  templateUrl: './dish-ingredients.component.html',
  styleUrls: ['./dish-ingredients.component.sass']
})
export class DishIngredientsComponent implements OnInit {
  @Input() ingredients: any;
  @Input() addIngredients: any;
  fieldArray: Array<any> = [];
  isEdit = false;
  public currList: any;
  public currChange: any;

  constructor() { }
  addRowPopup(data) {
    if (data) {
      this.currList = data.change;
      this.currChange = data.id;
    } else {
      this.currList = this.addIngredients.slice(0);
      this.currChange = false;
    }
    this.isEdit = true;
  }
  closePopup() {
    this.isEdit = false;
  }
  addRow(data) {
    this.fieldArray.push(data);
    this.closePopup();
  }
  removeRow(index) {
    if (this.fieldArray.length > 1) {
      this.fieldArray.splice(index, 1);
    }
  }
  changeElem(data) {
    this.fieldArray.forEach(elem => {
      if (elem.id === this.currChange) {
        elem.id = data.id;
        elem.name = data.name;
        elem.price = data.price;
        return;
      }
    });
    this.closePopup();
  }

  ngOnInit() {
    this.fieldArray = this.ingredients.slice(0);
  }

}
