import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.sass']
})
export class SearchComponent implements OnInit {
  @Input() data: any;
  @Input() allData: any;
  @Input() attributes: any;
  @Output() changeData = new EventEmitter<any>();
  searchAttribute = 'all';
  searchValue: string;
  searchAttributes: any = ['all', 'id'];

  constructor() {
  }

  searchById(id) {
    return this.data.filter((e) => {
      return e.id.toString().search(id) > -1;
    });
  }
  searchAll(value) {
    return this.data.filter((e) => {
      return e.id.toString().search(value) > -1 || this.searchFromArray(e, value);
    });
  }

  searchFromArray(elem, val) {
    let count = 0;
    this.attributes.forEach(e => {
      if (elem.data[e.toLowerCase()].search(val) > -1) {
        count++;
      }
    });
    return count > 0;
  }

  searchByValue(value) {
    return this.data.filter((e) => {
      return e.data[this.searchAttribute].search(value) > -1;
    });
  }

  search() {
    let regExp = new RegExp(this.searchValue, 'i');
    let data = [];
    switch (this.searchAttribute) {
      case 'all':
        data = this.searchAll(regExp);
        break;
      case 'id':
        data = this.searchById(regExp);
        break;
      default:
        data = this.searchByValue(regExp);
        break;
    }
    this.changeData.emit(data);
  }
  setValue(event) {
    this.searchValue = event.target.value;
    this.search();
  }
  setSearchAttribute(item) {
   this.searchAttribute = item.toLowerCase();
   this.search();
  }
  ngOnInit() {
    this.searchAttributes = this.searchAttributes.concat(this.attributes);
  }

}
