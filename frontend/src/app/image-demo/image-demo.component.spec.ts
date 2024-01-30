import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageDemoComponent } from './image-demo.component';

describe('ImageDemoComponent', () => {
  let component: ImageDemoComponent;
  let fixture: ComponentFixture<ImageDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ImageDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ImageDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
