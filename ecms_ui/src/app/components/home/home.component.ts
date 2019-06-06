import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { Router } from "@angular/router";

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    constructor(private formBuilder: FormBuilder, private router:Router, private userService: UserService) { }

    loginForm: FormGroup;
    registerForm: FormGroup;
    showSuccessMsg = false;
    showErrMsg = false;
    error_message: '';
    invalidLogin: boolean = false;

    ngOnInit() {

        this.showSuccessMsg = false,
        this.showErrMsg = false,
        this.error_message = '',

        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        }),

        this.registerForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required],
            passwordConfirm: ['', Validators.required],
            email: ['', Validators.required],
            phone: ['', Validators.required]
        });

        if( window.localStorage.getItem('token') ) {
            this.router.navigate(['student']);
            return;
        }

    }

    createUser() {
        
        if (this.registerForm.invalid) {
            return;
        }

        const registerPayload = {
            username: this.registerForm.controls.username.value,
            password: this.registerForm.controls.password.value,
            passwordConfirm: this.registerForm.controls.passwordConfirm.value,
            email: this.registerForm.controls.email.value,
            phone: this.registerForm.controls.phone.value,
            role_name: 'ROLE_USER'
        };

        this.userService.createUser(registerPayload).subscribe(
            res => {
                this.showSuccessMsg = true;
                this.showErrMsg = false;
                this.registerForm.reset();
            },
            err => {
                this.showSuccessMsg = false;
                this.showErrMsg = true;
                const errorMessages = new Array<{ propName: string; errors: string }>();

                if (err.status === 400) {
                    err.error.errors.forEach(prop => {
                        const values = prop.split(':');
                        errorMessages.push({ propName: values[0], errors: values[1] });
                    });

                    errorMessages.forEach(prop => {
                        const formControl = this.registerForm.get(prop.propName);
                        if (formControl) {
                            // activate the error message
                            formControl.setErrors({
                                serverError: prop.errors
                            });
                        } else {
                            this.error_message += prop.errors;
                        }
                    });
                }
            });
        }

        login() {

            if (!this.loginForm.valid) {
                return;
            }

            const loginPayload = {
                username: this.loginForm.controls.username.value,
                password: this.loginForm.controls.password.value
            };

            this.userService.loginUser(loginPayload).subscribe(data => {
                if(data.status === 200) {
                    window.localStorage.setItem('token', data.result.token);
                    this.router.navigate(['student']);
                }else {
                    this.invalidLogin = true;
                    alert(data.message);
                }
            });

        }
    }
