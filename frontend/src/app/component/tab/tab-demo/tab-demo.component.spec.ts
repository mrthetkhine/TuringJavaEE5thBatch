import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabDemoComponent } from './tab-demo.component';

describe('TabDemoComponent', () => {
  let component: TabDemoComponent;
  let fixture: ComponentFixture<TabDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TabDemoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TabDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
