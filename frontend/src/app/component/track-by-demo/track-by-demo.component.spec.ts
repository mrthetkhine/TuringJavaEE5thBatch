import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackByDemoComponent } from './track-by-demo.component';

describe('TrackByDemoComponent', () => {
  let component: TrackByDemoComponent;
  let fixture: ComponentFixture<TrackByDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrackByDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TrackByDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
