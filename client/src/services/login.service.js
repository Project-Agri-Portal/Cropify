import axios from 'axios';

const app = axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

const getCustomer = () => {
    return app.get('/users/');
}

const loginUser = (credentials) => {
    return app.post('/users/login', credentials);
}

const registerUser = (userData) => {
    return app.post('/users/', userData);
}

export default { getCustomer, loginUser, registerUser };