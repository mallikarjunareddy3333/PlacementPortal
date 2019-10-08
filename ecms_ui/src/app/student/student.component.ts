import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    console.log("app-student-constructor");
   }

  ngOnInit() {
    console.log("app-student-ngoninit");
  }

  logout(){
    this.authenticationService.logout();
  }

}
