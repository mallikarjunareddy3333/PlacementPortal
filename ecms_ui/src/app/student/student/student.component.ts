import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { AuthenticationService } from '../../core/_services/authentication.service';

@Component({
  selector: 'student-app',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  home_component: boolean;
  display_profile_component: boolean; 
  contact_us: boolean;
  edit_profile_component:boolean;

  loggedInUser: string;

  constructor(private router: Router, private authenticationService: AuthenticationService) { 
  }

  ngOnInit() {
    this.home_component = true;
    this.display_profile_component = false;
    this.edit_profile_component = false;
    this.contact_us=false;

    this.loggedInUser = this.authenticationService.currentUserValue.username;

  }

  logout(){
    this.authenticationService.logout();
    this.router.navigate([this.authenticationService.getReturnUrl()]);
  }

}
