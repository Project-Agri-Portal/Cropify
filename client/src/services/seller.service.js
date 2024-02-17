import axios from 'axios';  // handle http request

const app= axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'content-type':'application/json'
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

const getMachineryOrderList = (userId) =>{
    return app.get('ordermachinerydetails/orderlist/'+userId)
}


export default {getSellerProfile,getSellerMachinery,deleteSellerMachine,getMachineryOrderList};