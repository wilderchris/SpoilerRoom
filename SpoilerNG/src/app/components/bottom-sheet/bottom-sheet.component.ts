import { Component, EventEmitter, Inject, OnInit, Output } from '@angular/core';
import { UserService } from '../../services/user.service';
import { MAT_BOTTOM_SHEET_DATA, MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import { MatListModule } from '@angular/material/list';
import { FormsModule } from '@angular/forms';  
import { BrowserModule } from '@angular/platform-browser';


@Component({
  selector: 'app-bottom-sheet',
  standalone: true,
  imports: [MatListModule, FormsModule, BrowserModule],
  template: 'passed in {{ data.login }}',
  templateUrl: './bottom-sheet.component.html',
  styleUrl: './bottom-sheet.component.scss'
})
export class BottomSheetComponent implements OnInit{

  @Output() login: EventEmitter<any> = new EventEmitter();
  usernameInput!:string;
  passwordInput!:string;

  constructor(@Inject(MAT_BOTTOM_SHEET_DATA) public data: {login: string[]},
              private userServ:UserService, 
              private _bottomSheetRef: MatBottomSheetRef<BottomSheetComponent>) {}
  ngOnInit(): void {

  }
  logIn() {
    this.userServ.logIn(this.usernameInput,this.passwordInput).then(resp => {
      this.login.emit();
    });

  }
  openLink(event: MouseEvent): void {
    this._bottomSheetRef.dismiss();
    event.preventDefault();
  }
}