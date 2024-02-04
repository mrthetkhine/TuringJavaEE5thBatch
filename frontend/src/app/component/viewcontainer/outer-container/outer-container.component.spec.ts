import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OuterContainerComponent } from './outer-container.component';

describe('OuterContainerComponent', () => {
  let component: OuterContainerComponent;
  let fixture: ComponentFixture<OuterContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OuterContainerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OuterContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
