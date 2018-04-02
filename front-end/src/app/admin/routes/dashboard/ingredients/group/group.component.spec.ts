import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientsGroupComponent } from './group.component';

describe('IngredientsGroupComponent', () => {
  let component: IngredientsGroupComponent;
  let fixture: ComponentFixture<IngredientsGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngredientsGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngredientsGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
