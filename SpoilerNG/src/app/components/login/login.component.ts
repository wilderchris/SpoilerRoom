import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  @Output() login: EventEmitter<any> = new EventEmitter();
  usernameInput!:string;
  passwordInput!:string;
  
  constructor(private userServ:UserService) { }


  ngOnInit(): void {
  }

  logIn() {
    this.userServ.logIn(this.usernameInput,this.passwordInput).then(resp => {
      this.login.emit();
    });
console.log(this.usernameInput + "  : " + this.passwordInput);
  }
  openModal() {
    
      const modal = document.querySelector('.modal');
      if (modal) {
        modal.classList.add('show');
      }
    
  }

  closeModal() {
    // Code to close the login pop up
  }
 
}