import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DishIngredientsComponent } from './dish-ingredients.component';

describe('DishIngredientsComponent', () => {
  let component: DishIngredientsComponent;
  let fixture: ComponentFixture<DishIngredientsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DishIngredientsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DishIngredientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
