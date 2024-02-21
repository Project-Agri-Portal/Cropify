import "./Cart.css";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import NavBar from "../Common/NavBar";
import { ToastContainer, toast } from "react-toastify";
import CartProduct from "../../../services/ordercart.service";
import Orange from "../../../assets/ShopImages/orange.png";
import { useEffect, useState } from "react";

const Cart = () => {
  const [cart, setCart] = useState([]);
  const [total, setTotal] = useState(0);
  const [deliveryDate, setDeliveryDate] = useState();

  const onload = async () => {
    const customer = parseInt(sessionStorage.getItem("userId"));
    await CartProduct.showCart(customer)
      .then((result) => {
        console.log(result["data"]);
        setCart(result["data"]);
        setDeliveryDate(result["data"][0]["deliveryDate"]);
      })
      .catch((error) => {
        console.log("error");
        console.log(error);
      });
  };

  const deleteCart = async (cartId, price) => {
    setTotal(total - price);
    await CartProduct.deleteCart(cartId)
      .then((result) => {
        toast.warn("Product deleted");
        onload();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const calculateTotal = () => {
    let totalAmount = 0;
    cart.forEach((product) => {
      totalAmount += parseFloat(product.totalAmount);
    });
    setTotal(totalAmount);
  };

  useEffect(() => {
    onload();
  }, []);

  useEffect(() => {
    calculateTotal();
  }, [cart]);

  // const customer = parseInt(sessionStorage.getItem("userId"));

  return (
    <>
      <NavBar></NavBar>

      <div style={{ height: 80 }}></div>
      {cart.length === 0 ? (
        <>
          <div style={{ height: 200 }}></div>
          <h1>Your cart is empty.</h1>
        </>
      ) : (
        <div className="container-fluid main-div">
          <div className="row">
            <div className="col-md-10 col-11 mx-auto">
              <div className="row mt-5 gx-3">
                {/* <!-- left side div --> */}
                <div className="col-md-12 col-lg-8 col-11 mx-auto main_cart mb-lg-0 mb-5 shadow">
                  <div
                    className="card p-4"
                    style={{ backgroundColor: "white" }}
                  >
                    <div className="row">
                      {cart.map((product) => {
                        return (
                          <>
                            {/* <!-- cart images div --> */}
                            <div className="col-md-5 col-11 mx-auto bg-light d-flex justify-content-center align-items-center shadow product_img">
                              <img
                                src={Orange}
                                className="img-fluid"
                                alt="cart img"
                              />
                            </div>

                            {/* <!-- cart product details --> */}
                            <div className="col-md-7 col-11 mx-auto px-4 mt-2">
                              <div className="row">
                                {/* <!-- product name  --> */}
                                <div className="col-6 card-title">
                                  <h2 className="mb-4 text-center">
                                    {product["farmProductName"]}
                                  </h2>
                                  {product["quantity"] && (
                                    <h5>Quantity: {product["quantity"]}</h5>
                                  )}
                                  {product["farmerId"] && (
                                    <p className="mb-3">
                                      Farmer ID: {product["farmerId"]}
                                    </p>
                                  )}
                                </div>
                                <div className="col-6"></div>
                              </div>
                              {/* <!-- //remover move and price --> */}
                              <div className="row">
                                <div className="col-8 d-flex justify-content-between remove_wish">
                                  <p
                                    onClick={() => {
                                      deleteCart(
                                        product["cid"],
                                        product["totalAmount"]
                                      );
                                    }}
                                    className="delete_icon"
                                  >
                                    <i className="fas fa-trash-alt delete_icon"></i>{" "}
                                    REMOVE ITEM
                                  </p>
                                </div>
                                <div className="col-4 d-flex justify-content-end price_money">
                                  <h3>
                                    ₹
                                    <span id="itemval">
                                      {product["totalAmount"]}
                                    </span>
                                  </h3>
                                </div>
                              </div>
                            </div>
                            <div style={{ height: 40 }}></div>
                          </>
                        );
                      })}
                    </div>
                  </div>
                  <hr />
                </div>

                {/* <!-- right side div --> */}

                <div className="col-md-12 col-lg-4 col-11 mx-auto mt-lg-0 mt-md-5">
                  <div className="right_side p-3 shadow bg-white">
                    <h2 className="product_name mb-5">The Total Amount Of</h2>
                    <div className="price_indiv d-flex justify-content-between">
                      <p>Product amount</p>
                      <p>
                        ₹<span id="product_total_amt">{total}</span>
                      </p>
                    </div>
                    <div className="price_indiv d-flex justify-content-between">
                      <p>Shipping Charge</p>
                      <p>
                        ₹<span id="shipping_charge">50.0</span>
                      </p>
                    </div>
                    <hr />
                    <div className="total-amt d-flex justify-content-between font-weight-bold">
                      <p>The total amount of (including VAT)</p>
                      <p>
                        ₹<span id="total_cart_amt">{total + 50}</span>
                      </p>
                    </div>
                    {/* <button className="btn btn-primary text-uppercase">
                    Checkout
                  </button> */}
                    <Link
                      className="btn btn-primary text-uppercase"
                      to={{
                        pathname: "/shop/cart/checkout",
                        search: `?totalAmount=${total}`,
                      }}
                    >
                      Checkout
                    </Link>
                  </div>
                  {/* <!-- discount code part --> */}
                  <div className="discount_code mt-3">
                    <div className="card">
                      <div
                        className="card-body"
                        style={{ backgroundColor: "white" }}
                      >
                        <a
                          className="d-flex justify-content-between"
                          data-toggle="collapse"
                          href="#collapseExample"
                          aria-expanded="false"
                          aria-controls="collapseExample"
                        >
                          Add a discount code (optional)
                          <span>
                            <i className="fas fa-chevron-down pt-1"></i>
                          </span>
                        </a>
                        <div className="collapse" id="collapseExample">
                          <div className="mt-3">
                            <input
                              type="text"
                              name=""
                              id="discount_code1"
                              className="form-control font-weight-bold"
                              placeholder="Enter the discount code"
                            />
                            <small id="error_trw" className="text-dark mt-3">
                              code is thapa
                            </small>
                          </div>
                          <button
                            className="btn btn-primary btn-sm mt-3"
                            onclick="discount_code()"
                          >
                            Apply
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>

                  {/* <!-- discount code ends --> */}
                  <div className="mt-3 shadow p-3 bg-white">
                    <div className="pt-4">
                      <h5 className="mb-4">
                        Expected delivery date : {deliveryDate}
                      </h5>
                      <p></p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
      <ToastContainer></ToastContainer>
    </>
  );
};

export default Cart;
