import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SiteMainRouter } from './main.component';

describe('MainComponent', () => {
  let component: SiteMainRouter;
  let fixture: ComponentFixture<SiteMainRouter>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SiteMainRouter ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SiteMainRouter);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
