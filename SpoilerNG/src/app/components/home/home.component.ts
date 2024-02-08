import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  //@Output() movies!: Movie[];

  constructor(private httpServ: HttpService, private router: Router) { }

  async ngOnInit(): Promise<void> {
    this.httpServ.movies = await this.httpServ.getMovieAllNew();
   this.router.navigateByUrl('slider');

  }

}
