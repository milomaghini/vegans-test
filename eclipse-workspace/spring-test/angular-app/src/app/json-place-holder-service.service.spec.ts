import { TestBed } from '@angular/core/testing';

import { JsonPlaceHolderServiceService } from './json-place-holder-service.service';

describe('JsonPlaceHolderServiceService', () => {
  let service: JsonPlaceHolderServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JsonPlaceHolderServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
