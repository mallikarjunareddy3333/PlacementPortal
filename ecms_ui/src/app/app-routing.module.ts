import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { AuthGuard } from './_guard/auth.guard';
import { Role } from './_models/Role';
import { StudentComponent } from './student/student.component';
import { StudentHomeComponent } from './student/student-home/student-home.component';
import { ProfileComponent } from './student/profile/profile.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  { 
    path:'', 
    component:LoginRegisterComponent 
  },
  {
    path: 'student',
    canActivate: [AuthGuard],
    data: { 
      roles: [Role.User] 
    },
    loadChildren: './student/student.module#StudentModule'
  },
  { 
    path: '**', 
    redirectTo: '' 
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
