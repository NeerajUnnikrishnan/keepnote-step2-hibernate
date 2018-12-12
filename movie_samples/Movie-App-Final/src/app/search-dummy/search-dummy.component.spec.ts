import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchDummyComponent } from './search-dummy.component';

describe('SearchDummyComponent', () => {
  let component: SearchDummyComponent;
  let fixture: ComponentFixture<SearchDummyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchDummyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchDummyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
