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

const addFarmProducts = (product) => {
    return app.post("farmProducts/", product);
}

const getImage = (imgId) => {
    return app.get('farmProducts/image/'+imgId);
}

export default {getFarmProducts,addFarmProducts};