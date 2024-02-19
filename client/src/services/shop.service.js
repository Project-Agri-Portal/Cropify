import axios from "axios";

const app = axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

const getFarmProducts = () => {
    return app.get('farmproductdetails/join');
}

const getImg = (id) => {
    return app.get('farmProducts/image/' + id)
}

const getFarmProductsDetails = () => {
    return app.get('farmproductdetails/all')
}

const deleteFarmProduct = (productId) => {
    return app.delete('farmProducts/' + productId);
}

export default {getFarmProducts, getFarmProductsDetails, getImg, deleteFarmProduct};