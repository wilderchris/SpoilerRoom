import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.scss']
})
export class PageComponent implements OnInit {
 movie!: Movie;
 @ViewChild('scrollMe')
  private myScrollContainer!: ElementRef;
 urlString: string = "https://image.tmdb.org/t/p/w500";
 videoUrl!: string;// = "https://www.youtube.com/watch?v=" + this.movie.key;
  trustedUrl!: any;

  constructor(private http: HttpService, private sanitizer: DomSanitizer) { }
  ngOnInit(): void {
    this.scrollToBottom();
    this.movie = this.http.movie;
    console.log(this.movie);
    this.videoUrl = "https://www.youtube.com/watch?v=" + this.movie.key;
    //console.log(this.videoUrl);
    this.trustedUrl = this.sanitizer.bypassSecurityTrustUrl(this.videoUrl);
  }
  ngAfterViewChecked() {        
    this.scrollToBottom();        
} 

  scrollToBottom(): void {
    try {
        this.myScrollContainer.nativeElement.scrollTop = this.myScrollContainer.nativeElement.scrollHeight;
    } catch(err) { }                 
}
}
