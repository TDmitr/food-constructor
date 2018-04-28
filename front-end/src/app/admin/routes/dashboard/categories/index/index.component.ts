import { Component, OnInit } from '@angular/core';
import { NgDataJsonserviceService } from '../../../../services/ng-data-jsonservice.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.sass'],
})

export class CategoriesIndexComponent implements OnInit {
  categories: any;
  totalDescription = 'items of category';

  constructor(private getDataService: NgDataJsonserviceService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getDataService.getData('categories.json').subscribe(res => {
      this.categories = res;
    });
  }

}
