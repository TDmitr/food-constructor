import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-service-list',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.sass']
})
export class ServiceListComponent implements OnInit {
  @Input() data: any;
  @Input() isCart: boolean;
  @Input() totalCount: any;
  @Input() totalPrice: any;

  constructor() { }

  ngOnInit() {

  }

}
