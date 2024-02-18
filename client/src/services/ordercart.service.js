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

const deleteCart = (cartId) => {
    return app.delete('cartfarmproduct/'+ cartId)
}

const order = (customerId, totalPrice) => {
    return app.post('orderfarmproductdetails/'+ customerId + '/' + totalPrice);
}

export default {addToCart, showCart,deleteCart,order};