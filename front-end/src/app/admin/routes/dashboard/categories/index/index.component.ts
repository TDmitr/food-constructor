import { Component, OnInit } from '@angular/core';
import {NgDataJsonserviceService} from "../../../../services/ng-data-jsonservice.service";
import {ActivatedRoute} from "@angular/router";
import {
  trigger,
  state,
  style,
  animate,
  transition,
  query,
  stagger
} from '@angular/animations';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.sass'],
  animations: [
    trigger('articleAnimation', [
      transition(':enter', [
        query('article', style({ opacity: '0', transform: 'translateY(-15px)'})),
        query('article',
          stagger('150ms', [
            animate('300ms', style({ opacity: '1', transform: 'translateY(0)'}))
          ]))
      ])
    ])
  ]
})

export class CategoriesIndexComponent implements OnInit {
  categories: any;

  constructor(private getDataService: NgDataJsonserviceService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDataService.getData('categories.json').subscribe(res => {
      this.categories = res;
    });
  }

}
