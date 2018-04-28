import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-change-ingredient',
  templateUrl: './change-ingredient.component.html',
  styleUrls: ['./change-ingredient.component.sass']
})
export class ChangeIngredientComponent implements OnInit {
  @Input() change: any;
  @Input() list: any;
  @Output() closePopup = new EventEmitter<any>();
  @Output() addIngredient = new EventEmitter<any>();
  @Output() changeIngredient = new EventEmitter<any>();
  public chosen = {};
  public listData: any = [];
  public ingredients = [
    {id: 1, name: 'Chicken', price: 120, measure: 100},
    {id: 2, name: 'Cheese', price: 100, measure: 100},
    {id: 3, name: 'Milk', price: 20, measure: 100},
    {id: 4, name: 'Salad', price: 30, measure: 100},
    {id: 5, name: 'Tomato', price: 50, measure: 100},
    {id: 6, name: 'Pepper', price: 70, measure: 100},
    {id: 10, name: 'Duck', price: 90, measure: 100},
    {id: 15, name: 'Veal', price: 120, measure: 100}
  ];

  constructor() {
  }

  choose(data) {
    this.chosen = data;
  }
  submit() {
    if (this.chosen['id']) {
      this.change ? this.changeIngredient.emit(this.chosen) : this.addIngredient.emit(this.chosen);
    } else {
      this.cancel();
    }
  }
  cancel() {
    this.closePopup.emit();
  }

  ngOnInit() {
    this.list.forEach(id => {
      this.listData.push(this.ingredients.find(elem => elem.id === id));
    });
  }

}
