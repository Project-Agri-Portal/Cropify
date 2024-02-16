import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Orange from "../../../assets/ShopImages/orange.png"
import "./ProductList.css"
import Navbar from "../Common/NavBar"
import Footer from "../Common/Footer"
import FarmProducts from "../../../services/shop.service"
import { useHistory } from "react-router-dom"
import { useEffect, useState } from "react"
import { toast } from "react-toastify"

const ProductList = () => {

    const [farmProduct, setFarmProduct] = useState([]);
    const [farmProductDetails, setFarmProductDetails] = useState([]);
    const [quantities, setQuantities] = useState([]);

    const handleIncrement = (index) => {
        // Create a copy of the quantities array
        const newQuantities = [...quantities];
        // Increment the quantity for the specific product
        newQuantities[index] += 1;
        // Update the state
        setQuantities(newQuantities);
      };
    
      const handleDecrement = (index) => {
        // Create a copy of the quantities array
        const newQuantities = [...quantities];
        // Ensure quantity doesn't go below 1
        newQuantities[index] = Math.max(newQuantities[index] - 1, 1);
        // Update the state
        setQuantities(newQuantities);
      };

    const loadAllItems = async () => {
        await FarmProducts.getFarmProducts()
                        .then((result) => {
                            setFarmProduct(result['data'])
                            console.log(result);
                            console.log(result['data']);
                            toast.success("found")
                        })
                        .catch((error) => {
                            toast.warn("items")
                        })
        await FarmProducts.getFarmProductsDetails()
                            .then((result) => {
                                setFarmProductDetails(result['data'])
                                console.log(result);
                                const initialQuantities = result.data.map(() => 1);
                                setQuantities(initialQuantities);
                            })
    }

    const img = (id) => {
        return FarmProducts.getImg(id);
    }

    useEffect(() => {
        loadAllItems();
        console.log('hello use');
        toast.success("shop")
    }, []);

    return (

        <>

        <Navbar></Navbar>

        <div className="container py-5">
        <h1 className="text-center">Popular Products</h1>
        <div className="row row-cols-1 row-cols-md-3 g-4 py-5">

            {farmProduct.map((it, index) => {
                return (<div className="col" key={index}>
                <div className="card" id="card-id" style={{backgroundColor:"white"}}>
                {/* height:100 */}
                    <div className="imgcon" >
                    <img src={Orange} className="card-img-top" id="card-img-id" alt="..."/>
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">{it['farmProdName']}</h5>
                        <p className="card-text" id="card-text-id">{it['description']}</p>
                            <div style={{height:"10px"}}></div>
                            <p className="mb-1">Farmer name : {it['firstName']}</p>
                            <p className="mb-1">Availabe Quantity : {it['quantity']}</p>
                            <p className="cart-text mt-0">Expiry Date : {it['expiryDate']}</p>
                    </div>
                    <div className="mb-5 d-flex justify-content-around" id="btid">
                        <h3>₹{it['price']}</h3>
    <div className="btn-group" role="group">
  <button className="btn btn-primary animated-btn" onClick={() => handleDecrement(index)}>
    -
  </button>
  <span className="mx-2 quantity">{quantities[index]}</span>
  <button className="btn btn-success animated-btn" onClick={() => handleIncrement(index)}>
    +
  </button>
</div>
                        <button className="btn btn-primary" id="btnid">Add to Cart</button>
                    </div>
                </div>
            </div>)
            })}
        </div>
    </div>
    <Footer></Footer>
    </>
    );
};

export default ProductList;