import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../_services/user.service';
import { Router, ActivatedRoute } from "@angular/router";
import { AuthenticationService } from '../_services/authentication.service';
import { first } from 'rxjs/operators';

@Component({
    selector: 'app-login',
    templateUrl: './login-register.component.html',
    styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent implements OnInit {

    returnUrl: string;
    loginForm: FormGroup;
    registerForm: FormGroup;
    showSuccessMsg = false;
    showErrMsg = false;
    error_message: '';
    invalidLogin: boolean = false;

    constructor(
        private formBuilder: FormBuilder, 
        private router:Router, 
        private route: ActivatedRoute,
        private userService: UserService, 
        private authenticationService: AuthenticationService
    ) {        
        this.returnUrl = this.authenticationService.getReturnUrl();
        this.router.navigate([this.returnUrl]);
    }

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

        console.log(this.returnUrl);

        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || this.authenticationService.getReturnUrl();        
        
        this.router.navigate([this.returnUrl]);
        
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

            if (this.loginForm.invalid) {
                return;
            }

            const loginPayload = {
                username: this.loginForm.controls.username.value,
                password: this.loginForm.controls.password.value
            };

            this.authenticationService.login(loginPayload)
                .pipe(first())
                .subscribe(
                    data => {
                        console.log(this.returnUrl);
                        this.returnUrl = this.authenticationService.getReturnUrl();
                        this.router.navigate([this.returnUrl]);
                    },
                    error => {
                        this.invalidLogin = true;
                    });
        }

    }

    


