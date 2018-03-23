import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-third-step',
  templateUrl: './add-third-step.component.html',
  styleUrls: ['./add-third-step.component.sass']
})
export class AddThirdStepComponent implements OnInit {
  isPopup = false;

  constructor() { }

  closePopup() {
    this.isPopup = false;
  }

  openPopup() {
    this.isPopup = true;
  }

  ngOnInit() {
  }

}
