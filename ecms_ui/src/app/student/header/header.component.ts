import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { AuthenticationService } from '../../_services/authentication.service';

@Component({
  selector: 'student-app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    console.log("app-student-constructor");
   }

  ngOnInit() {
    console.log("app-student-ngoninit");
  }

  logout(){
    this.authenticationService.logout();
    this.router.navigate([this.authenticationService.getReturnUrl()]);
  }

}
