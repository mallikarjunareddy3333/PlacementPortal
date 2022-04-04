import axios from "axios";

const USER_API_URL = "http://localhost:9090/api/v1/users/";
const TOKEN_API_URL = "http://localhost:9090/api/v1/token/";

const register = (username, password, passwordConfirm, email, phone, role_name) => {
    return axios.post(USER_API_URL+ "register", {
        username: username,
        password: password, 
        passwordConfirm: passwordConfirm,
        email: email,
        phone: phone,
        role_name: role_name
    });
};

const login = (username, password) => {
    return axios.post(TOKEN_API_URL + "generate", {
        username: username,
        password: password
    }).then((response) => {
        if(response.data.result.token) {
            localStorage.setItem("user", JSON.stringify(response.data.result));
        }
        return response.data.result;
    });
};

const logout = () => {
    localStorage.removeItem("user");
};

const authService = {
    register, login, logout
}

export default authService;