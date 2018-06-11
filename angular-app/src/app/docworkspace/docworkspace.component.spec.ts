import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocworkspaceComponent } from './docworkspace.component';

describe('DocworkspaceComponent', () => {
  let component: DocworkspaceComponent;
  let fixture: ComponentFixture<DocworkspaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocworkspaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocworkspaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
