import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { AuthenticationService } from '../../_services/authentication.service';

@Component({
  selector: 'student-app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  home_component: boolean; 
  profile_component: boolean;

  constructor(private router: Router, private authenticationService: AuthenticationService) { 
  }

  ngOnInit() {
    this.home_component = true;
    this.profile_component = false;
  }

  logout(){
    this.authenticationService.logout();
    this.router.navigate([this.authenticationService.getReturnUrl()]);
  }

}
