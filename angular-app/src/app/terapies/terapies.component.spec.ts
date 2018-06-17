import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TerapiesComponent } from './terapies.component';

describe('TerapiesComponent', () => {
  let component: TerapiesComponent;
  let fixture: ComponentFixture<TerapiesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TerapiesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TerapiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
