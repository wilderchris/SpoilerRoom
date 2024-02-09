import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogActions, MatDialogClose, MatDialogTitle, MatDialogContent, MatDialogRef, MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {
  form!: FormGroup;
  id?: string;
  title!: string;
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

    this.title = 'Register';
    if (this.id) {
      // edit mode
      this.title = 'Edit Account';
      this.loading = true;
      // this.accountService.getById(this.id)
      // .pipe(first())
      // .subscribe(x => {
      //     this.form.patchValue(x);
      //     this.loading = false;
      // });
    }
  }
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(regDialog, {
      width: '250px',
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


  //   onSubmit() {
  //       this.submitted = true;

  //       // reset alerts on submit
  //       // this.alertService.clear();

  //       // stop here if form is invalid
  //       if (this.form.invalid) {
  //           return;
  //       }

  //       this.submitting = true;
  //       // this.saveUser()
  //       //     .pipe(first())
  //       //     .subscribe({
  //       //         next: () => {
  //                   // this.alertService.success('User saved', { keepAfterRouteChange: true });
  //               //     this.router.navigateByUrl('/users');
  //               // },
  //               // error: error => {
  //               //     this.alertService.error(error);
  //               //     this.submitting = false;
  //               // }
  //   //         })
  //   // }

  //   // private saveUser() {
  //       // create or update user based on id param
  //       // return this.id
  //           // ? this.accountService.update(this.id!, this.form.value)
  //           // : this.accountService.register(this.form.value);
  //   // }
  // }
}

@Component({
  selector: 'dialog-animations-example-dialog',
  templateUrl: './registrationDialog.html',
  standalone: true,
  imports: [MatButtonModule, MatDialogActions, MatDialogClose,
    MatDialogTitle, MatDialogContent, FormsModule, ReactiveFormsModule, CommonModule],
})
export class regDialog {
  usernameInput!: string;
  passwordInput!: string;
  login: any;
  form!: FormGroup;
  id?: string;
  title!: string;
  loading = false;
  submitting = false;
  submitted = false;
  user!: User;
  // @Output() login: EventEmitter<any> = new EventEmitter();

  constructor(public dialogRef: MatDialogRef<regDialog>,
    public userServ: UserService,
    private router: Router) { }

  register() {
    this.user.rank = { id: 1, rankTitle: "admin" };
    this.userServ.register(this.user).then(resp => {
      this.login.emit();

    });
  }


}