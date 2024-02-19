import axios from "axios";

const app = axios.create({
    baseURL: 'http://localhost:8080/api/users',
    headers: {
        'Content-Type': 'application/json'
    }
});

const getSellerList = (role) => {
    return app.get('/usertype/'+role);
}

const getFarmerList = (role) => {
    return app.get('/usertype/'+role);
}

const getCustomer = (customerId) => {
    return app.get('/'+customerId);
}

const updateStatus = (id, status) => {
    return app.put("/"+id+"/"+status);
}

export default {getSellerList, getFarmerList,getCustomer, updateStatus};