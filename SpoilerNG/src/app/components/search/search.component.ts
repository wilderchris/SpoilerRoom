import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {
  value = '';
  
 // @Output() movies!: Movie[];

  async submitSearch(value: string): Promise<void> { 
    this.value = value; 
   this.http.movies = await this.http.getMovieByQuery(this.value);
   //console.log(this.movies);

   this.router.navigateByUrl('slider');

  }

  constructor(private http: HttpService, private router: Router) { }

  ngOnInit(): void {
  }

}
