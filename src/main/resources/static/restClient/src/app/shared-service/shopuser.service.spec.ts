import { TestBed, inject } from '@angular/core/testing';

import { ShopuserService } from './shopuser.service';

describe('ShopuserService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ShopuserService]
    });
  });

  it('should be created', inject([ShopuserService], (service: ShopuserService) => {
    expect(service).toBeTruthy();
  }));
});
