import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { StudentComponent } from './student/student.component';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './_guard/auth.guard';


const routes: Routes = [
    { path:'', component:LoginRegisterComponent },
    { path: 'student', component:StudentComponent, canActivate: [AuthGuard],
    children: [
      {
        path: '**',
        redirectTo: ''
      }
    ] },
    { path: 'admin', component:AdminComponent, canActivate: [AuthGuard],
    children: [
      {
        path: '**',
        redirectTo: ''
      }
    ] },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
