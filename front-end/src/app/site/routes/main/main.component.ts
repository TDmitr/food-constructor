import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {CartService} from "../../services/cart.service";
import {FavouritesService} from "../../services/favourites.service";

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.sass']
})
export class SiteMainRouter implements OnInit {
  constructor() {
  }

  ngOnInit() {
  }

}
