import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientsIndexGroupComponent } from './index.component';

describe('IngredientsIndexGroupComponent', () => {
  let component: IngredientsIndexGroupComponent;
  let fixture: ComponentFixture<IngredientsIndexGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngredientsIndexGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngredientsIndexGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
