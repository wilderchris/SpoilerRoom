import { Component, OnInit, Output } from '@angular/core';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  @Output() movies!: Movie[];

  constructor(private httpServ: HttpService) { }

  async ngOnInit(): Promise<void> {
    this.movies = await this.httpServ.getMovieAllNew();

  }

}
