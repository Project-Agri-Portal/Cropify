import axios from "axios";

const app = axios.create({
    baseURL: 'http://localhost:8080/api/users',
    headers: {
        'Content-Type': 'application/json'
    }
});