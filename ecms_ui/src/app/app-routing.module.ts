import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AuthGuard } from './_guard/auth.guard';
import { Role } from './_models/Role';

const routes: Routes = [
  { 
    path:'', 
    component:AppComponent 
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
