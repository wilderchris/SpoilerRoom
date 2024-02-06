import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-my-page',
  templateUrl: './my-page.component.html',
  styleUrls: ['./my-page.component.scss']
})
export class MyPageComponent implements OnInit {

  constructor(private http: HttpService) { }

 async ngOnInit(): Promise<void> {

   this.http.movies = await this.http.getMovieGenre('80');

  }

}
