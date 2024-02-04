import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DynamicRenderDemoComponent } from './dynamic-render-demo.component';

describe('DynamicRenderDemoComponent', () => {
  let component: DynamicRenderDemoComponent;
  let fixture: ComponentFixture<DynamicRenderDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DynamicRenderDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DynamicRenderDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
