import axios from 'axios';

const app = axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

const getCustomer = (userId) => {
    return app.get(`/users/${userId}`);
}

const loginUser = (credentials) => {
    return app.post('/users/login', credentials);
}

const registerUser = (userData) => {
    return app.post('/users/', userData);
}

const exportModule = { getCustomer, loginUser, registerUser }
export default exportModule;