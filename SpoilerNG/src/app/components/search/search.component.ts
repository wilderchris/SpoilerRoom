import { Component, OnInit, Output } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogActions, MatDialogClose, MatDialogTitle, MatDialogContent, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Movie } from 'src/app/models/movie';
import { HttpService } from 'src/app/services/http.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit{
  value = '';
  

  constructor(private userServ:UserService, 
              public dialog: MatDialog,
              private http: HttpService, 
              private router: Router ) {}
  ngOnInit(): void {
    this.openDialog('1000ms', '1000ms');
    }
  
  // logIn() {
  //   this.userServ.logIn(this.usernameInput,this.passwordInput).then(resp => {
  //     this.login.emit();
  //   });
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(DialogAnimations, {
      width: '250px',
      enterAnimationDuration,
      exitAnimationDuration,
    });
  }


  async submitSearch(value: string): Promise<void> { 
    this.value = value; 
   this.http.movies = await this.http.getMovieByQuery(this.value);
   console.log(this.http.movies);

   this.router.navigateByUrl('slider');

  }
}
  
@Component({
  selector: 'dialog',
  templateUrl: './dialog.html',
  styleUrl: './search.component.scss',
  standalone: true,
  imports: [MatButtonModule, MatDialogActions, MatDialogClose, 
    MatDialogTitle, MatDialogContent, FormsModule, ReactiveFormsModule],
})
export class DialogAnimations {
  value = '';
  constructor(public dialogRef: MatDialogRef<DialogAnimations>,
    public userServ: UserService,
    public http: HttpService,
    private router: Router) {}



    async submitSearch(value: string): Promise<void> { 
      this.value = value; 
     this.http.movies = await this.http.getMovieByQuery(this.value);
     //console.log(this.movies);
  
     this.router.navigateByUrl('slider');
  
    }
      
}


// implements OnInit {
//   value = '';
  
//  // @Output() movies!: Movie[];

//   async submitSearch(value: string): Promise<void> { 
//     this.value = value; 
//    this.http.movies = await this.http.getMovieByQuery(this.value);
//    //console.log(this.movies);

//    this.router.navigateByUrl('slider');

//   }

//   constructor(private http: HttpService, private router: Router) { }

//   ngOnInit(): void {
//   }

// }
