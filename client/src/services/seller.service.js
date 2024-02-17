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

const getSellerMachinery = (userId) =>{
    return app.get('sellerMachinery/productlist/'+userId);
}

const deleteSellerMachine = (sellerMachineId) =>{
    return app.delete('sellerMachinery/'+sellerMachineId);
}


export default {getSellerProfile,getSellerMachinery,deleteSellerMachine};