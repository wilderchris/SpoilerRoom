import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { HttpService } from 'src/app/services/http.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {
  loggedInUser!: User;
  showLogin!: boolean;

  constructor(private userServ: UserService,
    private router: Router,
    private http: HttpService) { }

  ngOnInit(): void {
    this.setup();
  }

  setup() {
    this.userServ.checkLogin().then(resp => {
      this.loggedInUser = this.userServ.loggedInUser;
      this.showLogin=false;
      // console.log(this.loggedInUser);
    });
  }

  logOut() {
    this.userServ.logOut();
    this.loggedInUser.id = 0;
    this.router.navigateByUrl('/');
  }

  getPlants() {
  console.log(  this.http.getAllPlants() );
  }

}
