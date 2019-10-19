import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoreRoutingModule } from './core-routing-module';
import { loginRegisterComponent } from './login-register/login-register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FooterComponent } from './footer/footer.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    loginRegisterComponent,
    FooterComponent,
    ContactComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CoreRoutingModule
  ],
  exports: [
    ContactComponent,
    FooterComponent
  ]
})
export class CoreModule { }
