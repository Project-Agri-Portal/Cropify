import axios from "axios";

const app = axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

const getAgriProducts = () => {
    return app.get("agriProducts/");
}

export default {getAgriProducts};