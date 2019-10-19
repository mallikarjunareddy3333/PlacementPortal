import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StudentComponent } from './student/student.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { StudentRoutingModule } from './student-routing-module';
import { CoreModule } from '../core/core.module';

@NgModule({
  declarations: [
    StudentComponent, 
    HomeComponent, 
    ProfileComponent
  ],
  imports: [
    CommonModule,
    StudentRoutingModule,
    CoreModule
  ]
})

export class StudentModule { }
