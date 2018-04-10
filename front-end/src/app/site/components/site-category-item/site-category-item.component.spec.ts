import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SiteCategoryItemComponent } from './site-category-item.component';

describe('SiteCategoryItemComponent', () => {
  let component: SiteCategoryItemComponent;
  let fixture: ComponentFixture<SiteCategoryItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SiteCategoryItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SiteCategoryItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
