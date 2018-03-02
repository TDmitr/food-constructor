import { TestBed, inject } from '@angular/core/testing';

import { NgDataJsonserviceService } from './ng-data-jsonservice.service';

describe('NgDataJsonserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NgDataJsonserviceService]
    });
  });

  it('should be created', inject([NgDataJsonserviceService], (service: NgDataJsonserviceService) => {
    expect(service).toBeTruthy();
  }));
});
