import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
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
  currentItem = this.movie2;
  constructor(private httpServ: HttpService, private router: Router) { }

  ngOnInit(): void {
    //  console.log(this.movie2);
  }
  myClickFunction() { // added

    this.httpServ.movie = this.movie2
    this.router.navigateByUrl('page');


  }
}
