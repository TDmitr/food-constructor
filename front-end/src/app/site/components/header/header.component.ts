import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {CartService} from "../../services/cart.service";
import {FavouritesService} from "../../services/favourites.service";

@Component({
  selector: 'app-site-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.sass']
})
export class HeaderSiteComponent implements OnInit {
  public shoppingCartItems: Observable<any>;
  public favouriteItems: Observable<any>;
  public totalCartPrice: any;
  public totalCartCount: any;
  public mobileMenuOpen = false;

  constructor(private cartService: CartService, private favouriteService: FavouritesService) {
    this.shoppingCartItems = this
      .cartService
      .getItems();
    this.favouriteItems = this
      .favouriteService
      .getItems();
    this.totalCartPrice = this
      .cartService
      .getTotalPrice();
    this.totalCartCount = this
      .cartService
      .getTotalCount();

    this.shoppingCartItems.subscribe(_ => _);
    this.favouriteItems.subscribe(_ => _);
    this.totalCartPrice.subscribe(_ => _);
    this.totalCartCount.subscribe(_ => _);
  }
  openMenuMobile() {
    this.mobileMenuOpen = true;
  }
  ngOnInit() {
  }

}
