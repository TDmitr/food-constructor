import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dish-constructor',
  templateUrl: './dish-constructor.component.html',
  styleUrls: ['./dish-constructor.component.sass']
})
export class DishConstructorComponent implements OnInit {
  public data = {
    id: 1,
    category: 'Salads',
    isSize: true,
    sizes: [
      {name: 'Mega', description: '500g - 50% meat / 50% other', price: 'double'},
      {name: 'Standard', description: '250g - 50% meat / 50% other', price: 'standard'}
      ],
    minPrice: 30,
    properties: [
      {
        name: 'Meat',
        mandatory: true,
        ingredients: [
          {
            id: 1,
            name: 'Chicken',
            price: 12
          },
          {
            id: 2,
            name: 'Veal',
            price: 13,
            properties: [{name: 'Roasting', values: ['Well Done', 'Not Well Done']}]
          },
        ]
      },
      {
        name: 'Sauce',
        mandatory: true,
        ingredients: [
          { id: 3, name: 'Ketchup', price: 3 },
          { id: 4, name: 'Mayo', price: 3 },
        ]
      },
      {
        name: 'Other',
        maxCount: 10,
        ingredients: [
          { id: 5, name: 'Cheese', price: 3 },
          { id: 6, name: 'Cucumber', price: 3 },
        ]
      }
    ]
  };
  public step = this.data.properties[0].name;
  public currData = {};

  constructor() { }

  navToStep(step) {
    this.step = step;
  }

  addProperty(name, event) {

  }

  ngOnInit() {
  }

}
