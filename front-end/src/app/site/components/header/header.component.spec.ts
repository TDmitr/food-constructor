import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderSiteComponent } from './header.component';

describe('HeaderSiteComponent', () => {
  let component: HeaderSiteComponent;
  let fixture: ComponentFixture<HeaderSiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderSiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderSiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
