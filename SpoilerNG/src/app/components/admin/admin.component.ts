import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs';
import { User } from 'src/app/models/user';

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

  constructor(
      private formBuilder: FormBuilder,
      private route: ActivatedRoute,
      private router: Router,
      // private accountService: AccountService,
      // private alertService: AlertService
  ) { }

  ngOnInit() {
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

  register(){
    this.user.rank = { id: 1, rankTitle: "admin" };
    console.log(this.user);
  }

  // convenience getter for easy access to form fields
  // get f() { return this.form.controls; }

  onSubmit() {
      this.submitted = true;

      // reset alerts on submit
      // this.alertService.clear();

      // stop here if form is invalid
      if (this.form.invalid) {
          return;
      }

      this.submitting = true;
      // this.saveUser()
      //     .pipe(first())
      //     .subscribe({
      //         next: () => {
                  // this.alertService.success('User saved', { keepAfterRouteChange: true });
              //     this.router.navigateByUrl('/users');
              // },
              // error: error => {
              //     this.alertService.error(error);
              //     this.submitting = false;
              // }
  //         })
  // }

  // private saveUser() {
      // create or update user based on id param
      // return this.id
          // ? this.accountService.update(this.id!, this.form.value)
          // : this.accountService.register(this.form.value);
  // }
}
}