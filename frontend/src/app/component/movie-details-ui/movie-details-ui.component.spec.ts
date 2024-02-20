import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieDetailsUIComponent } from './movie-details-ui.component';

describe('MovieDetailsUIComponent', () => {
  let component: MovieDetailsUIComponent;
  let fixture: ComponentFixture<MovieDetailsUIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieDetailsUIComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MovieDetailsUIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
