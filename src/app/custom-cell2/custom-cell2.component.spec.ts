import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomCell2Component } from './custom-cell2.component';

describe('CustomCell2Component', () => {
  let component: CustomCell2Component;
  let fixture: ComponentFixture<CustomCell2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomCell2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomCell2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
