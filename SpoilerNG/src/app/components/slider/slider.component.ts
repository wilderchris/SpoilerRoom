import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.scss']
})
export class SliderComponent implements OnInit {
 @Input() movies!: Movie[];

  constructor(private httpServ: HttpService) { }

  async ngOnInit(): Promise<void> {
      this.movies = await this.httpServ.getMovieAllNew();

  }

}
