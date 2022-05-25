import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-movie-card',
  templateUrl: './movie-card.component.html',
  styleUrls: ['./movie-card.component.scss']
})
export class MovieCardComponent implements OnInit {
  @Input() movie2!: Movie;
  @Output() emits = new EventEmitter();
  urlString: string = "https://image.tmdb.org/t/p/w500";
  videoUrl: string = "https://www.youtube.com/watch?v="; 
  backImg: string = "https://protwo.s3.us-east-2.amazonaws.com/assets/wood.jpg";

  constructor(private httpServ: HttpService) { }

  ngOnInit(): void {
    //  console.log(this.movie2);
  }

}
