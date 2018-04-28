import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";

@Injectable()
export class FavouritesService {

  private itemsInFavouritesSubject: BehaviorSubject<Object[]> = new BehaviorSubject([]);
  private itemsInFavourites: Object[] = [];
  constructor() {
    this.itemsInFavouritesSubject.subscribe(_ => this.itemsInFavourites = _);
  }
  public addToFavourites(item: Object) {
    this.itemsInFavouritesSubject.next([...this.itemsInFavourites, item]);
  }
  public removeFromFavourites(item: Object) {
    const curArray = this.itemsInFavourites;
    const newArray = curArray.filter(_ => _['id'] !== item['id']);
    this.itemsInFavouritesSubject.next(newArray);
  }
  public getItems(): Observable<Object> {
    return this.itemsInFavouritesSubject;
  }
  public isInFavourites(item: Object): boolean {
    return this.itemsInFavourites.filter(_ => _['id'] === item['id']).length > 0;
  }

}
