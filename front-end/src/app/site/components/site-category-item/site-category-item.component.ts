import { Component, OnInit } from '@angular/core';
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-site-category-item',
  templateUrl: './site-category-item.component.html',
  styleUrls: ['./site-category-item.component.sass']
})
export class SiteCategoryItemComponent implements OnInit {

  constructor(private cartService: CartService) { }

  addToCart() {
    this.cartService.addToCart({});
  }

  ngOnInit() {
  }

}
