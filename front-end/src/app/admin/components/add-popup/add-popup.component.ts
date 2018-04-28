import {Component, EventEmitter, Input, OnInit, OnChanges, Output} from '@angular/core';

@Component({
  selector: 'app-add-popup',
  templateUrl: './add-popup.component.html',
  styleUrls: ['./add-popup.component.sass']
})
export class AddPopupComponent implements OnInit {
  @Output() save = new EventEmitter<any>();
  @Output() edit = new EventEmitter<any>();
  @Output() close = new EventEmitter<any>();
  @Input() data: any;
  fieldArray: Array<any> = [];
  newAttribute: any = {};
  value: string;
  name: string;
  editMode = false;

  constructor() { }

  addRow() {
    console.log(this.newAttribute);
    this.fieldArray.push(this.newAttribute);
    this.newAttribute = {};
  }

  removeRow(index) {
    this.fieldArray.splice(index, 1);
  }

  closePopup() {
    this.close.emit();
  }

  saveData(data) {
    console.log(this.fieldArray);
    const nData = {};
    nData['name'] = data.name;
    nData['values'] = [data.value];
    this.fieldArray.forEach(elem => {
      if (elem.value && elem.value.length > 0) {
        nData['values'].push(elem.value);
      }
    });
    this.editMode ? this.edit.emit(nData) : this.save.emit(nData);
  }
  ngOnChanges() {
    console.log(this.data);
    if (this.data) {
      this.value = this.data.values[0];
      this.name = this.data.name;
      this.data.values.forEach((e, i) => {
        if (i > 0) {
          this.fieldArray.push({value: e});
        }
      });
    //   console.log()
    //   this.fieldArray = this.data.values.map((e, i) => {
    //     if (i > 0) {
    //       return {value: e};
    //     }
    //   });
    //   this.name = this.data.name;
    //   this.value = this.data.values[0];
      this.editMode = true;
    }
  }
  ngOnInit() {}

}
