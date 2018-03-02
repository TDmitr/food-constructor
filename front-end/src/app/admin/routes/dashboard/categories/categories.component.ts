import { Component, OnInit } from '@angular/core';
import {NgDataJsonserviceService} from "../../../services/ng-data-jsonservice.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.sass']
})
export class CategoriesComponent implements OnInit {
  categories: any;

  constructor(private getDataService: NgDataJsonserviceService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDataService.getData('categories.json').subscribe(res => {
      this.categories = res;
    });
  }

}
