import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieUiComponent } from './movie-ui.component';

describe('MovieUiComponent', () => {
  let component: MovieUiComponent;
  let fixture: ComponentFixture<MovieUiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieUiComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MovieUiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
