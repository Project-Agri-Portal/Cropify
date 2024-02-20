import axios from "axios"; // handle http request

const app = axios.create({
  baseURL: "http://localhost:8080/api/",
  headers: {
    "content-type": "application/json",
  },
});

const getFarmerProfile = (userId) => {
  return app.get("users/" + userId);
};

const updateFarmerProfile = (userId, updatedInfo) => {
  return app.put("users/" + userId, updatedInfo);
};

const getAllFarmProducts = () => {
  return app.get("farmProducts/");
};

const getFarmerProducts = (userId) => {
    return app.get("farmproductdetails/productlist/" + userId);
};

const deleteFarmerProducts = (fpId) => {
    return app.delete("farmproductdetails/" + fpId);
};

const addFarmProduct = (userId, farmProduct) => {
    return app.post("farmproductdetails/add/" + userId, farmProduct);
};

const getFarmerOrderList = (userId) => {
    return app.get("orderfarmproductdetails/orderlist/" + userId);
};

const deleteOrder = (oid) => {
    return app.delete("orderfarmproductdetails/" + oid);
};

export default {
  getAllFarmProducts,
  getFarmerProducts,
  deleteFarmerProducts,
  getFarmerOrderList,
  updateFarmerProfile,
  getFarmerProfile,
  deleteOrder,
  addFarmProduct,
};
