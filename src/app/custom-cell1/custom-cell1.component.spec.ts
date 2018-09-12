import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomCell1Component } from './custom-cell1.component';

describe('CustomCell1Component', () => {
  let component: CustomCell1Component;
  let fixture: ComponentFixture<CustomCell1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomCell1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomCell1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
