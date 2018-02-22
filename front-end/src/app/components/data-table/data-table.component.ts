import {Component, Input, OnInit} from '@angular/core';
import {KeysPipe} from '../../pipes/json-to-array';

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.sass']
})
export class DataTableComponent implements OnInit {
  @Input('columns') columns: any;
  @Input() data: any;
  @Input() image: boolean;
  initialData: any;
  filter = '';

  constructor() {}
  arraySortEquality(arr1, arr2) {
    return arr1.length === arr2.length &&
           arr1.length > 0 &&
           Object.is(arr1[0], arr2[0]) &&
           Object.is(arr1[arr1.length - 1], arr2[arr2.length - 1]);
  }
  sortByValue(value, event) {
    let order = +event.target.dataset.order;
    this.data.sort((a, b) => {
      return a[value] - b[value];
    });
    if (!!order) {
      this.data = this.data.reverse();
    }
    event.target.dataset.order = +!order;
  }
  ngOnInit() {}
  ngOnChanges() {
    this.initialData = this.data;
  }
}

