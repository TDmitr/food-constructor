import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngredientsAddGroupComponent } from './add.component';

describe('IngredientsAddGroupComponent', () => {
  let component: IngredientsAddGroupComponent;
  let fixture: ComponentFixture<IngredientsAddGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngredientsAddGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngredientsAddGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
