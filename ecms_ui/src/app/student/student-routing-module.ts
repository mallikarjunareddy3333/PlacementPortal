import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentComponent } from './student/student.component';

const routes: Routes = [
    {
        path: '',
        component: StudentComponent
    },
    {
        path: 'header',
        component: StudentComponent
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
export class StudentRoutingModule { }
