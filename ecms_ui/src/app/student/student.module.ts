import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { StudentRoutingModule } from './student-routing-module';

@NgModule({
  declarations: [
    HeaderComponent, 
    HomeComponent, 
    ProfileComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule
  ]
})

export class StudentModule { }
