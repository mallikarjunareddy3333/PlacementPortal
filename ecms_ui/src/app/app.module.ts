import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginRegisterComponent } from './login-register/login-register.component';
import { StudentComponent } from './student/student.component';

import { UserService } from './_services/user.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";
import { TokenInterceptor } from "./_helpers/interceptor";
import { AdminComponent } from './admin/admin.component';

@NgModule({
    declarations: [
        AppComponent,
        LoginRegisterComponent,
        StudentComponent,
        AdminComponent
    ],

    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        AppRoutingModule
    ],
    providers: [UserService, {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true}],
    bootstrap: [AppComponent]
})
export class AppModule { }
