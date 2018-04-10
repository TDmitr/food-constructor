import { Injectable } from '@angular/core';

@Injectable()
export class ProductsService {

  constructor() { }

  public getProducts(): Object[] {
    return this.products();
  }

  private products(): Object[] {
    return <Object[]>[
      <Object>{id: 1, name: 'Blue item', price: 123.09, colors: ['blue']},
      <Object>{id: 2, name: 'Green and gray', price: 99.09, colors: ['green', 'gray']},
      <Object>{id: 3, name: 'Green item', price: 99.09, colors: ['green']},
      <Object>{id: 4, name: 'Blue and gray', price: 99.09, colors: ['blue', 'gray']},
      <Object>{id: 5, name: 'Green and blue', price: 99.09, colors: ['green', 'blue']},
      <Object>{id: 6, name: 'Green and blue', price: 99.09, colors: ['green', 'blue']},
      <Object>{id: 7, name: 'Gray', price: 99.09, colors: ['gray']},
      <Object>{id: 8, name: 'Blue', price: 99.09, colors: ['blue']},
      <Object>{id: 9, name: 'All colors', price: 99.09, colors: ['gray', 'blue', 'green']},
    ];
  }

}
