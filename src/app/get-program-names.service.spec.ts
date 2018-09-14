import { TestBed, inject } from '@angular/core/testing';

import { GetProgramNamesService } from './get-program-names.service';

describe('GetProgramNamesService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetProgramNamesService]
    });
  });

  it('should be created', inject([GetProgramNamesService], (service: GetProgramNamesService) => {
    expect(service).toBeTruthy();
  }));
});
