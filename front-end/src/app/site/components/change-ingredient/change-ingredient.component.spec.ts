import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeIngredientComponent } from './change-ingredient.component';

describe('ChangeIngredientComponent', () => {
  let component: ChangeIngredientComponent;
  let fixture: ComponentFixture<ChangeIngredientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangeIngredientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeIngredientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
