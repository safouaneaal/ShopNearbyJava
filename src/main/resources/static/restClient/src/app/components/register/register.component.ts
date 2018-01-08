import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  id :string;
  constructor(private router:Router, private userservice:UserService) { }


  ngOnInit() {
    console.log('hit');
  }

  registerUser(e) {
    e.preventDefault();
    console.log(e);
    var username = e.target.elements[0].value;
    var email = e.target.elements[1].value;
    var password = e.target.elements[2].value;
    var confirmpassword = e.target.elements[3].value;
    if(password == confirmpassword) {
      this.userservice.adduser(username,email,password).subscribe((shops) => {}, (error) => {
      });
      this.userservice.setUserLoggedIn();
     // this.router.navigate(['users/'+username]);
    }
  }
}
