import {createSlice} from "@reduxjs/toolkit";

const initialAuthState = {
    isAuthenticated: localStorage.getItem('user') && JSON.parse(localStorage.getItem('user')).token ? true : false
};

const authSlice = createSlice({
    name: 'authentication',
    initialState: initialAuthState,
    reducers: {
        login(state) {
            state.isAuthenticated = true;
        },
        logout(state) {
            state.isAuthenticated = false;
        }
    }
});

export const authActions = authSlice.actions;

export default authSlice.reducer;