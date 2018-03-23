import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFirstStepComponent } from './add-first-step.component';

describe('AddFirstStepComponent', () => {
  let component: AddFirstStepComponent;
  let fixture: ComponentFixture<AddFirstStepComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFirstStepComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFirstStepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
