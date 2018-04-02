import { Component, OnInit } from '@angular/core';
import {NgDataJsonserviceService} from "../../../../../services/ng-data-jsonservice.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.sass']
})
export class IngredientsIndexGroupComponent implements OnInit {
  groups: any;
  totalDescription = 'ingredients in group';

  constructor(private getDataService: NgDataJsonserviceService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDataService.getData('ingredients-group.json').subscribe(res => {
      this.groups = res;
    });
  }

}
