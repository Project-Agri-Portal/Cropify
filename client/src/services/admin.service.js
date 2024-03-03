import axios from "axios";

const app = axios.create({
    baseURL: 'http://localhost:8080/api/admin',
    headers: {
        'Content-Type': 'application/json'
    }
});

const agricultureProductCount = () => {
    return app.get("/agriProdCount");
}

const farmProductCount = () => {
    return app.get("/farmerProdCount");
}

const machineryCount = () => {
    return app.get("/machineCount");
}

const sellerCount = () => {
    return app.get("/sellerCount");
}

const customerCount = () => {
    return app.get("/customerCount");
}

const farmerCount = () => {
    return app.get("/farmerCount");
}

const getFarmProducts = () => {
    return app.get("/machinery/");
}

export default {agricultureProductCount, 
                farmProductCount, 
                machineryCount, 
                sellerCount, 
                customerCount, 
                farmerCount,
                getFarmProducts
            };
