import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewChildDemoComponent } from './view-child-demo.component';

describe('ViewChildDemoComponent', () => {
  let component: ViewChildDemoComponent;
  let fixture: ComponentFixture<ViewChildDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewChildDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewChildDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
