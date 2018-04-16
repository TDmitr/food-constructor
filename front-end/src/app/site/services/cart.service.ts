import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable, Subject, Subscriber} from 'rxjs';
import {of} from 'rxjs/observable/of';

@Injectable()
export class CartService {
  private itemsInCartSubject: BehaviorSubject<Object[]> = new BehaviorSubject([]);
  private itemsInCart: Object[] = [];
  constructor() {
    this.itemsInCartSubject.subscribe(_ => this.itemsInCart = _);
  }
  public addToCart(item: Object) {
    if (this.cartHasItem(item)) {
      this.iterateItemCount(item);
    } else {
      this.itemsInCartSubject.next([...this.itemsInCart, item]);
    }
  }
  public getItems(): Observable<Object> {
    return this.itemsInCartSubject;
  }
  public getTotalPrice(): Observable<number> {
    return this.itemsInCartSubject.map((items: any) => {
      return items.reduce((prev, curr) => {
        return prev + (curr['price'] * curr['count']);
      }, 0);
    });
  }

  public  getTotalCount():  Observable<number> {
    return this.itemsInCartSubject.map((items: Object[]) => {
      return items.reduce((prev, curr: Object) => {
        return prev + curr['count'];
      }, 0);
    });
  }

  public iterateItemCount(item) {
    const currentItems = [...this.itemsInCart];
    const itemInArray = currentItems.filter(_ => _['id'] !== item['id']);
    const currentItem = currentItems.find(_ => _['id'] === item['id'])
    this.itemsInCartSubject.next(itemInArray);
    this.itemsInCartSubject.next([...this.itemsInCart, Object.assign({count: ++currentItem['count']}, currentItem)]);
  }

  public cartHasItem(item: Object): boolean {
    const currentItems = [...this.itemsInCart];
    const itemInArray = currentItems.filter(_ => _['id'] === item['id']).length > 0;
    return itemInArray;
  }
}
