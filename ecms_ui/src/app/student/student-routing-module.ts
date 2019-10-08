import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentHomeComponent } from './student-home/student-home.component';
import { ProfileComponent } from './profile/profile.component';
import { StudentComponent } from './student.component';

const routes: Routes = [
    {
        path: '',
        component: StudentComponent
    },
    {
        path: 'student',
        component: StudentComponent
    },
    {
        path: 'home',
        component: StudentHomeComponent
    },
    {
        path: 'profile',
        component: ProfileComponent
    }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
