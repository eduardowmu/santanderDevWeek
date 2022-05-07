import { TestBed } from '@angular/core/testing';

import { MovimementacoesService } from './movimementacoes.service';

describe('MovimementacoesService', () => {
  let service: MovimementacoesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovimementacoesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
