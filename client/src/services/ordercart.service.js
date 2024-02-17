import axios from 'axios';

const app = axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

const addToCart = (customerId, cart) => {
    return app.post('cartfarmproduct/' + customerId, cart);
}

const showCart = (customerId) => {
    return app.get('cartfarmproduct/'+ customerId);
}

export default {addToCart, showCart};