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

const deleteAgriProduct = (productId) => {
    return app.delete('agriProducts/' + productId);
}

const addAgriProducts = (product) => {
    return app.post("agriProducts/", product);
}

export default {getAgriProducts, deleteAgriProduct, addAgriProducts};