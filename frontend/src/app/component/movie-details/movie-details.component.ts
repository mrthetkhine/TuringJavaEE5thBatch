import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-movie-details',
  standalone: true,
  imports: [],
  templateUrl: './movie-details.component.html',
  styleUrl: './movie-details.component.css'
})
export class MovieDetailsComponent {
  @Input() id!:string;
  ngOnInit(){
    console.info("id:",this.id);
  }
}
