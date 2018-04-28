import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DishConstructorComponent } from './dish-constructor.component';

describe('DishConstructorComponent', () => {
  let component: DishConstructorComponent;
  let fixture: ComponentFixture<DishConstructorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DishConstructorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DishConstructorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
