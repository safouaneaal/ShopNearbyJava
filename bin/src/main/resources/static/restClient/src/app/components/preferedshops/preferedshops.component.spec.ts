import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreferedshopsComponent } from './preferedshops.component';

describe('PreferedshopsComponent', () => {
  let component: PreferedshopsComponent;
  let fixture: ComponentFixture<PreferedshopsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreferedshopsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreferedshopsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
