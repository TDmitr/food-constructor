import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSecondStepComponent } from './add-second-step.component';

describe('AddSecondStepComponent', () => {
  let component: AddSecondStepComponent;
  let fixture: ComponentFixture<AddSecondStepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddSecondStepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSecondStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
