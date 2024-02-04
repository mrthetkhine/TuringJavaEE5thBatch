import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InnerItemComponent } from './inner-item.component';

describe('InnerItemComponent', () => {
  let component: InnerItemComponent;
  let fixture: ComponentFixture<InnerItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InnerItemComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(InnerItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
