import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewContainerDemoComponent } from './view-container-demo.component';

describe('ViewContainerDemoComponent', () => {
  let component: ViewContainerDemoComponent;
  let fixture: ComponentFixture<ViewContainerDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewContainerDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewContainerDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
