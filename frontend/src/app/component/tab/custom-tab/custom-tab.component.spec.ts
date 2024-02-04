import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomTabComponent } from './custom-tab.component';

describe('CustomTabComponent', () => {
  let component: CustomTabComponent;
  let fixture: ComponentFixture<CustomTabComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomTabComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CustomTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
