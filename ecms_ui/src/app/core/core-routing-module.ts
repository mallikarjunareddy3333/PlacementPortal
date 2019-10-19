import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { loginRegisterComponent } from './login-register/login-register.component';
import { AuthGuard } from '../_guard/auth.guard';
import { Role } from '../_models/Role';

const routes: Routes = [
    { 
        path:'',
        component: loginRegisterComponent
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
        path: 'student',
        canActivate: [AuthGuard],
        data: { 
          roles: [Role.User] 
        },
        loadChildren: './admin/admin.module#AdminModule'
    },
    { 
        path: '**', 
        redirectTo: '' 
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class CoreRoutingModule { }
