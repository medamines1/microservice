import { TestBed } from '@angular/core/testing';

import { HttpIntercepterBearerAuthServiceService } from './http-intercepter-bearer-auth-service.service';

describe('HttpIntercepterBearerAuthServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpIntercepterBearerAuthServiceService = TestBed.get(HttpIntercepterBearerAuthServiceService);
    expect(service).toBeTruthy();
  });
});
