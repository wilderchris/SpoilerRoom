import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { MatBottomSheet } from '@angular/material/bottom-sheet';
import { BottomSheetComponent } from 'src/app/components/bottom-sheet/bottom-sheet.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{
  @Output() login: EventEmitter<any> = new EventEmitter();
  usernameInput!: string;
  passwordInput!: string;

  constructor(private userServ: UserService, private bottomSheet: MatBottomSheet) { }

  ngOnInit(): void {
    // console.log("login component");
   // this.openBottomSheet();
  }
  // openBottomSheet(): void {

    // this.bottomSheet.open(BottomSheetComponent, {
      // data: { login: [this.usernameInput, this.passwordInput] },
    
//} );

  }

  // logIn() {
  //   this.userServ.logIn(this.usernameInput, this.passwordInput).then(resp => {
  //     this.login.emit();
  //   });
  //   console.log(this.usernameInput + "  : " + this.passwordInput);
  // }

// }