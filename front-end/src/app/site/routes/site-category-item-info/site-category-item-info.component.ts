import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-site-category-item-info',
  templateUrl: './site-category-item-info.component.html',
  styleUrls: ['./site-category-item-info.component.sass']
})
export class SiteCategoryItemInfoComponent implements OnInit {
  public data = [
    { id: 1, name: 'Pepper Salad 1', weight: 400, price: 40, minPrice: 30, currency: 'UAH', addIngredients: [1, 2, 3], ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 2, name: 'Pepper Salad 2', weight: 400, price: 40, minPrice: 30, currency: 'UAH', addIngredients: [2, 3, 4], ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 3, name: 'Pepper Salad 3', weight: 400, price: 40, minPrice: 30, currency: 'UAH', addIngredients: [4, 5, 6], ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 4, name: 'Pepper Salad 4', weight: 400, price: 40, minPrice: 30, currency: 'UAH', addIngredients: [10, 15, 1], ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 5, name: 'Pepper Salad 5', weight: 400, price: 40, minPrice: 30, currency: 'UAH', addIngredients: [1, 2, 3], ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] }
  ];
  public dish: object;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.dish = this.data.find(elem => elem.id == params.dishId);
    });
  }

  ngOnInit() {
  }

}
