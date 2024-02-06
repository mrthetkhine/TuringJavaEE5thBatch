import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SizerComponent } from './sizer.component';

describe('SizerComponent', () => {
  let component: SizerComponent;
  let fixture: ComponentFixture<SizerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SizerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SizerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
