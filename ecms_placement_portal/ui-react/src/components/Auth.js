import { useState, useRef } from 'react';
import {useDispatch} from 'react-redux';
import classes from './Auth.module.css';
import authService from '../services/auth.service';

import { authActions } from '../store/auth';

const Auth = () => {

    const usernameInputRef = useRef();
    const passwordInputRef = useRef();

    const [username, setUsername] = useState('');
    const [password, setEnteredPassword] = useState('');

    const dispatch = useDispatch();

    const loginHandler = (event) => {
        event.preventDefault();

        if ( username === "") {
            usernameInputRef.current.focus();
        } else if ( password === "") {
            passwordInputRef.current.focus();
        } else {
            authService.login(username, password).then(data => {
                dispatch(authActions.login());
            });
        }
    };

    const usernameChangeHandler = (event) => {
        setUsername(usernameInputRef.current.value);
    }

    const passwordChangeHandler = (event) => {
        setEnteredPassword(passwordInputRef.current.value);
    }

    return (
        <main className={classes.auth}>
            <section>
                <form onSubmit={loginHandler}>
                    <div className={classes.control}>
                        <label htmlFor='username'>Username</label>
                        <input ref={usernameInputRef} type='name' onChange={usernameChangeHandler} id='username' value={username} />
                    </div>
                    <div className={classes.control}>
                        <label htmlFor='password'>Password</label>
                        <input ref={passwordInputRef} onChange={passwordChangeHandler} type='password' id='password' value={password} />
                    </div>
                    <button>Login</button>
                </form>
            </section>
        </main>
    );
};

export default Auth;