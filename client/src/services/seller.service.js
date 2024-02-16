import axios from 'axios';  // handle http request

const app= axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'content-type':'apllication/json'
    }
});

const getSellerProfile = (userId) =>{
    return app.get('users/'+userId);
}

export default {getSellerProfile};