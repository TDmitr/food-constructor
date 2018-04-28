import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-site-category',
  templateUrl: './site-category.component.html',
  styleUrls: ['./site-category.component.sass']
})
export class SiteCategoryComponent implements OnInit {
  public data = [
    { id: 1, name: 'Pepper Salad 1', weight: '400g', price: 40, minPrice: 30, currency: 'UAH', ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 2, name: 'Pepper Salad 2', weight: '400g', price: 40, minPrice: 30, currency: 'UAH', ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 3, name: 'Pepper Salad 3', weight: '400g', price: 40, minPrice: 30, currency: 'UAH', ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 4, name: 'Pepper Salad 4', weight: '400g', price: 40, minPrice: 30, currency: 'UAH', ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] },
    { id: 5, name: 'Pepper Salad 5', weight: '400g', price: 40, minPrice: 30, currency: 'UAH', ingredients: [{ id: 1, name: 'Chicken', isEdit: true, change: [1, 10, 15] }, { id: 2, name: 'Tomato', price: 5 }] }
    ];

  constructor() {
  }

  ngOnInit() {
  }

}
