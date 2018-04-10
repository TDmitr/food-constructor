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
    this.itemsInCartSubject.next([...this.itemsInCart, item]);
  }
  public getItems(): Observable<Object> {
    return this.itemsInCartSubject;
  }
}
