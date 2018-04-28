import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-add-third-step-popup',
  templateUrl: './add-third-step-popup.component.html',
  styleUrls: ['./add-third-step-popup.component.sass']
})
export class AddThirdStepPopupComponent implements OnInit {
  @Output() closePopup = new EventEmitter<any>();

  constructor() { }

  close() {
    this.closePopup.emit();
  }

  ngOnInit() {
  }

}
