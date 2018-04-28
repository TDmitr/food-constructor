import {Component, Input, OnInit} from '@angular/core';
import {CartService} from "../../services/cart.service";
import {FavouritesService} from "../../services/favourites.service";

@Component({
  selector: 'app-site-category-item',
  templateUrl: './site-category-item.component.html',
  styleUrls: ['./site-category-item.component.sass']
})
export class SiteCategoryItemComponent implements OnInit {
  @Input() dish: any;
  public count = 1;

  constructor(private cartService: CartService, private favouriteService: FavouritesService) { }

  addToCart() {
    this.dish['count'] = this.count;
    this.cartService.addToCart(this.dish);
  }
  addToFavourites() {
    if (this.isFavourite()) {
      this.favouriteService.removeFromFavourites(this.dish);
    } else {
      this.favouriteService.addToFavourites(this.dish);
    }
  }
  isFavourite(): boolean {
    return this.favouriteService.isInFavourites(this.dish);
  }
  ngOnInit() {
  }

}
