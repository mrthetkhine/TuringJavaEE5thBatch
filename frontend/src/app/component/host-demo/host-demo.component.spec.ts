import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HostDemoComponent } from './host-demo.component';

describe('HostDemoComponent', () => {
  let component: HostDemoComponent;
  let fixture: ComponentFixture<HostDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HostDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HostDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
