import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import "./Cart.css";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import { useHistory } from "react-router-dom";
import NavBar from "../Common/NavBar";
import Footer from "../Common/Footer";
import { ToastContainer, toast } from "react-toastify";
import CartProduct from "../../../services/ordercart.service";
import { useEffect, useState } from "react";

const Orders = () => {
  const [order, setOrder] = useState([]);
  const [total, setTotal] = useState(0);
  const [deliveryDate, setDeliveryDate] = useState();

  const onload = async () => {
    const customer = parseInt(localStorage.getItem("userId"));
    await CartProduct.allOrder(customer)
      .then((result) => {
        setOrder(result["data"]);
        console.log(result);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const history = useHistory(); // Get access to the history object
  useEffect(() => {
    const userId = localStorage.getItem("userId");

    // Check if userId is empty, and redirect to login if true
    if (!userId) {
      history.push("/login"); // Redirect to the login page
    } else {
      onload();
    }
  }, [history]);

  const deleteOrder = async (orderId, price, name) => {
    setTotal(total - price);
    await CartProduct.deleteOrder(orderId)
      .then((result) => {
        toast.warn(name + " Order Cancel");
        onload();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const calculateTotal = () => {
    let totalAmount = 0;
    order.forEach((product) => {
      totalAmount += parseFloat(product["totalPrice"]);
    });
    setTotal(totalAmount);
  };

  useEffect(() => {
    onload();
  }, []);

  useEffect(() => {
    calculateTotal();
  }, [order]);

  return (
    <>
      <NavBar></NavBar>
      {order.length == 0 ? (
        <>
          <div style={{ height: 200 }}></div>
          <div className="h-100 d-flex align-items-center justify-content-center">
          <h1>No Orders</h1>
          </div>
          <div style={{ height: 200 }}></div>
        </>
      ) : (
        <>
          <div style={{ height: 60 }}></div>
          <div className="fs-3">Your Total : {total}</div>
          <div style={{ height: 30 }}></div>
          <div className="container">
            <table class="table table-hover text-center">
              <thead>
                <tr>
                  <th scope="col">Order Id</th>
                  <th scope="col">Product Name</th>
                  <th scope="col">Quantity</th>
                  <th scope="col">Price</th>
                  <th scope="col">Total Price</th>
                  <th scope="col">Delivery Date</th>
                  <th scope="col">Cancel Order</th>
                </tr>
              </thead>
              {order.map((it) => {
                return (
                  <>
                    <tbody>
                      <tr>
                        <th scope="row">{it["orderId"]}</th>
                        <td>{it["farmProductName"]}</td>
                        <td>{it["quantity"]}</td>
                        <td>{it["totalPrice"] / it["quantity"]}</td>
                        <td>{it["totalPrice"]}</td>
                        <td>{it["deliveryDate"]}</td>
                        <td>
                          <button type="button" class="btn btn-danger" onClick={() => deleteOrder(it['oid'], it['totalPrice'], it['farmProductName'])}>
                            Cancel
                          </button>
                        </td>
                      </tr>
                    </tbody>
                  </>
                );
              })}
            </table>
          </div>
        </>
      )}
      <ToastContainer></ToastContainer>
      <div style={{ height: 120 }}></div>
      <Footer></Footer>
    </>
  );
};

export default Orders;
