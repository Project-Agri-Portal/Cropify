import axios from "axios";

const app = axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

const getFarmProducts = () => {
    return app.get("farmProducts/");
}

export default {getFarmProducts};