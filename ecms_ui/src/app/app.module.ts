import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { StudentComponent } from './components/student/student.component';

import { UserService } from './services/user.service';
import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http";
import { TokenInterceptor } from "./core/interceptor";

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        StudentComponent
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
