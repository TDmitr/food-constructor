import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddThirdStepPopupComponent } from './add-third-step-popup.component';

describe('AddThirdStepPopupComponent', () => {
  let component: AddThirdStepPopupComponent;
  let fixture: ComponentFixture<AddThirdStepPopupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddThirdStepPopupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddThirdStepPopupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
