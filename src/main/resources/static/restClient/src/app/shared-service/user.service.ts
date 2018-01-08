import { Injectable } from '@angular/core';
import {Headers, Http, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
//Catch Errors
import 'rxjs/add/operator/catch';
//Add Observable
import 'rxjs/add/observable/throw';

@Injectable()
export class UserService {
  private baseUrl:string='http://localhost:8060';
  private headers= new Headers({'Content-Type':'application/json'})
  private options= new RequestOptions({headers:this.headers});
  private isUserLoggedIn;
  public username;

  constructor(private _http:Http) {
    this.isUserLoggedIn = false;
  }

  setUserLoggedIn() {
    this.isUserLoggedIn = true;
    this.username = 'admin';
  }

  getUserLoggedIn() {
    return this.isUserLoggedIn;
  }
  adduser(name:string,email:string,password:string){
    return this._http.post(this.baseUrl+"/users?name="+name+"&email="+email+"&password="+password,this.options)
      .map((response:Response)=>response.json())
      .catch(this.errorHandler)
  }
  errorHandler(error:Response){
    return Observable.throw(error||"Server Error");
  }
}
