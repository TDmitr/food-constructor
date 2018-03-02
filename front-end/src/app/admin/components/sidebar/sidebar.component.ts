import { Component, OnInit } from '@angular/core';
import {Http} from '@angular/http';
import {NgDataJsonserviceService} from "../../services/ng-data-jsonservice.service";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.sass']
})
export class SidebarComponent implements OnInit {

  data: any;

  constructor(private getDataService: NgDataJsonserviceService) {

  }

  ngOnInit() {
    this.getDataService.getData('navigation.json').subscribe(res => {
      this.data = res;
    });
  }

}
