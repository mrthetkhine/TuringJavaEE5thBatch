import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaftContentComponent } from './leaft-content.component';

describe('LeaftContentComponent', () => {
  let component: LeaftContentComponent;
  let fixture: ComponentFixture<LeaftContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeaftContentComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LeaftContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
