import { Component, EventEmitter, Inject, OnInit, Output } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MatListModule } from '@angular/material/list';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';  
import { CommonModule } from '@angular/common';
// import { BrowserModule } from '@angular/platform-browser';
import {
  MatDialog,
  MatDialogRef,
  MatDialogActions,
  MatDialogClose,
  MatDialogTitle,
  MatDialogContent,
} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-bottom-sheet',
  standalone: true,
  imports: [MatListModule, FormsModule],
  template: 'passed in {{ data.login }}',
  templateUrl: './bottom-sheet.component.html',
  styleUrl: './bottom-sheet.component.scss'
})
export class BottomSheetComponent implements OnInit{

  

  constructor(private userServ:UserService, 
              public dialog: MatDialog ) {}
  ngOnInit(): void {
    this.openDialog('1000ms', '1000ms');
    }
  
  // logIn() {
  //   this.userServ.logIn(this.usernameInput,this.passwordInput).then(resp => {
  //     this.login.emit();
  //   });
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(DialogAnimationsExampleDialog, {
      width: '250px',
      enterAnimationDuration,
      exitAnimationDuration,
    });
  }
}
  // }
  // openLink(event: MouseEvent): void {
  //   this._bottomSheetRef.dismiss();
  //   event.preventDefault();
  // }
// }
@Component({
  selector: 'dialog-animations-example-dialog',
  templateUrl: './dialog-animation-example-dialog.html',
  standalone: true,
  imports: [MatButtonModule, MatDialogActions, MatDialogClose, 
    MatDialogTitle, MatDialogContent, FormsModule, ReactiveFormsModule],
})
export class DialogAnimationsExampleDialog {
  usernameInput!: string;
  passwordInput!: string;
  login: any;
  constructor(public dialogRef: MatDialogRef<DialogAnimationsExampleDialog>,
    public userServ: UserService) {}

  logIn() {
      this.userServ.logIn(this.usernameInput, this.passwordInput).then(resp => {
        this.login.emit();
      });
      console.log(this.usernameInput + "  : " + this.passwordInput);
    }
  
  
}
