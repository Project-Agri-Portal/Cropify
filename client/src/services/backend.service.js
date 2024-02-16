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

const loginCustomer = (credentials) => {
    return app.post('/users/login', credentials);
}

export default { getCustomer, loginCustomer };