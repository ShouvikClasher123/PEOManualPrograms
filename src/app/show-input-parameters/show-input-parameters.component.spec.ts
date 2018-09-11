import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowInputParametersComponent } from './show-input-parameters.component';

describe('ShowInputParametersComponent', () => {
  let component: ShowInputParametersComponent;
  let fixture: ComponentFixture<ShowInputParametersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowInputParametersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowInputParametersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
