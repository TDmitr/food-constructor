import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddThirdStepComponent } from './add-third-step.component';

describe('AddThirdStepComponent', () => {
  let component: AddThirdStepComponent;
  let fixture: ComponentFixture<AddThirdStepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddThirdStepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddThirdStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
