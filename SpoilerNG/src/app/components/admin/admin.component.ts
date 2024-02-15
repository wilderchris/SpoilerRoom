import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogActions, MatDialogClose, MatDialogTitle, MatDialogContent, MatDialogRef, MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  form!: FormGroup;
  id?: string;
  loading = false;
  submitting = false;
  submitted = false;
  user!: User;
  @Output() login: EventEmitter<any> = new EventEmitter();

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userServ: UserService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.openDialog('1000ms', '1000ms');

    this.id = this.route.snapshot.params['id'];

    // form with validation rules
    this.form = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      // password only required in add mode
      password: ['', [Validators.minLength(6), ...(!this.id ? [Validators.required] : [])]]
    });

     }
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(regDialog, {
    //  width: '2500px',
      enterAnimationDuration,
      exitAnimationDuration,
    });
  }

  register() {
    this.user.rank = { id: 1, rankTitle: "admin" };
    this.userServ.register(this.user).then(resp => {
      this.login.emit();

    });
  }


}

@Component({
  selector: 'dialog-animations-example-dialog',
  templateUrl: './registrationDialog.html',
  styleUrls: ['./admin.component.scss'],
   standalone: true,
  imports: [MatButtonModule, MatDialogActions, MatDialogClose,
    MatDialogTitle, MatDialogContent, FormsModule, MatCardModule,
    ReactiveFormsModule, CommonModule, MatFormFieldModule, MatIconModule,
    MatInputModule],
})
export class regDialog {
  usernameInput!: string;
  passwordInput!: string;
  login: any;
  form!: FormGroup;
  id?: string;
  hide = true;
  loading = false;
  submitting = false;
  submitted = false;
  user: User = {
    id: 0,
    username: '',
    passwd: '',
    firstName: 'ccc',
    lastName: '',
    rank: { id: 0, rankTitle: '' }
  };
  // @Output() login: EventEmitter<any> = new EventEmitter();

  constructor(public dialogRef: MatDialogRef<regDialog>,
    public userServ: UserService,
    private router: Router) { }

  register() {
    console.table(this.user);

    this.user.rank.id = 1;
    console.table(this.user);
    this.userServ.register(this.user).then(resp => {
      this.login.emit();

    });
  }


}