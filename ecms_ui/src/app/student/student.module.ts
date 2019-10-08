import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentComponent } from './student.component';
import { StudentHomeComponent } from './student-home/student-home.component';
import { ProfileComponent } from './profile/profile.component';
import { StudentRoutingModule } from './student-routing-module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    StudentComponent, 
    StudentHomeComponent, 
    ProfileComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule
  ]
})

export class StudentModule { }
