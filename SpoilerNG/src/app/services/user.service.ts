import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  loggedInUser!:User;
  authHeaders = {'Content-type':'application/json','Token':''};
  regHeaders = {'Content-type':'application/json'};

  constructor(private http: HttpService) { }


  async checkLogin() {

    let token = localStorage.getItem('Token');
    if (token) {
      let resp = await fetch(this.http.url + '/user/' + token + '/auth');
      if (resp.status===200) {
        this.loggedInUser = await resp.json();
        // console.log(token);
      }
    }
  }

  async logIn(username:string,password:string): Promise<void> {
    let credentials = {
      'username':username,
      'passwd':password
    };

    let resp = await fetch(this.http.url + '/user/auth', {method:'POST',body:JSON.stringify(credentials),
    headers:this.regHeaders});

    if (resp.status===200) {
      let token = await resp.json();
      localStorage.setItem('Token', token);
      // console.log(resp);
    }
  }

  logOut(): void {
    localStorage.clear();
    this.loggedInUser;
  }

  async register(person:User): Promise<void> {
    let resp = await fetch(this.http.url + '/user', {method:'POST',body:JSON.stringify(person)});
    if (resp.status===200 || resp.status===201) {
      // TODO
    }
  }

  async updateUser(person:User): Promise<void> {
    if (person.id===this.loggedInUser.id) {
      let resp = await fetch(this.http.url + '/user/' + person.id, {method:'PUT',body:JSON.stringify(person)});
      if (resp.status===200) {
        this.loggedInUser = await resp.json();
      }
    }
  }
}