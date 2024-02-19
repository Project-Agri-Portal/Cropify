import axios from "axios";

const app = axios.create({
    baseURL: 'http://localhost:8080/api/',
    headers: {
        'Content-Type': 'application/json'
    }
});

const getFarmProducts = () => {
    return app.get("/machinery/");
}

const deleteMachinery = (machineId) => {
    return app.delete('/machinery/' + machineId);
}

const addMachinery = (machinery) => {
    return app.post('machinery/', machinery);
}

export default {getFarmProducts, deleteMachinery, addMachinery};