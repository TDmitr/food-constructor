import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SiteCategoryItemInfoComponent } from './site-category-item-info.component';

describe('SiteCategoryItemInfoComponent', () => {
  let component: SiteCategoryItemInfoComponent;
  let fixture: ComponentFixture<SiteCategoryItemInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SiteCategoryItemInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SiteCategoryItemInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
