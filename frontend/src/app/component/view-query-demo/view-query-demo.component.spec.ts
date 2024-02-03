import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewQueryDemoComponent } from './view-query-demo.component';

describe('ViewQueryDemoComponent', () => {
  let component: ViewQueryDemoComponent;
  let fixture: ComponentFixture<ViewQueryDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewQueryDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewQueryDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
