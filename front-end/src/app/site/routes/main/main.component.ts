import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.sass']
})
export class SiteMainRouter implements OnInit {
  public shoppingCartItems: Observable<Object[]>;

  constructor(private cartService: CartService) {
    this.shoppingCartItems = this
      .cartService
      .getItems();

    this.shoppingCartItems.subscribe(_ => _);
  }

  ngOnInit() {
  }

}
