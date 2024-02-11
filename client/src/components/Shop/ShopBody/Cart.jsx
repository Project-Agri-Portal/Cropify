import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import "./Cart.css"
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import NavBar from "../Common/NavBar"
import Orange from "../../../assets/ShopImages/orange.png"

const Cart = () => {
  return (
    <>
    <NavBar></NavBar>
    <div style={{height:80}}></div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-10 col-11 mx-auto">
            <div className="row mt-5 gx-3">
              {/* <!-- left side div --> */}
              <div className="col-md-12 col-lg-8 col-11 mx-auto main_cart mb-lg-0 mb-5 shadow">
                <div className="card p-4">
                  <h2 className="py-4 font-weight-bold">Cart (2 items)</h2>
                  <div className="row">
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
                          <h1 className="mb-4 product_name">Tomato</h1>
                          <p className="mb-2">Category : Vegetable</p>
                          <p className="mb-2">Harvest data : today</p>
                          <p className="mb-3">Seller : Janak</p>
                        </div>
                        {/* <!-- quantity inc dec --> */}
                        <div className="col-6">
                          <ul className="pagination justify-content-end set_quantity">
                            <li className="page-item">
                              <button
                                className="page-link"
                                onclick="decreaseNumber('textbox','itemval')"
                              >
                                <i className="fas fa-minus"></i>
                              </button>
                            </li>
                            <li className="page-item">
                              <input
                                type="text"
                                name=""
                                className="page-link"
                                value="0"
                                id="textbox"
                              />
                            </li>
                            <li className="page-item">
                              <button
                                className="page-link"
                                onclick="increaseNumber('textbox','itemval')"
                              >
                                <i className="fas fa-plus"></i>
                              </button>
                            </li>
                          </ul>
                        </div>
                      </div>
                      {/* <!-- //remover move and price --> */}
                      <div className="row">
                        <div className="col-8 d-flex justify-content-between remove_wish">
                          <p>
                            <i className="fas fa-trash-alt delete_icon"></i>{" "}
                            REMOVE ITEM
                          </p>
                        </div>
                        <div className="col-4 d-flex justify-content-end price_money">
                          <h3>
                            $<span id="itemval">0.00 </span>
                          </h3>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <hr />

                <div className="card p-4">
                  {/* <!-- <h2 className="py-4 font-weight-bold">Cart (2 items)</h2> --> */}
                  <div className="row">
                    {/* <!-- cart images div --> */}
                    <div className="col-md-5 col-11 mx-auto bg-light d-flex justify-content-center align-items-center shadow product_img">
                      <img
                        src="http://localhost:3000/assets/ShopImages/orange.png"
                        className="img-fluid"
                        alt="cart img"
                      />
                    </div>

                    {/* <!-- cart product details --> */}
                    <div className="col-md-7 col-11 mx-auto px-4 mt-2">
                      <div className="row">
                        {/* <!-- product name  --> */}
                        <div className="col-6 card-title">
                          <h1 className="mb-4 product_name">Tomato</h1>
                          <p className="mb-2">Category : Vegetable</p>
                          <p className="mb-2">Harvest data : today</p>
                          <p className="mb-3">Seller : Janak</p>
                        </div>
                        {/* <!-- quantity inc dec --> */}
                        <div className="col-6">
                          <ul className="pagination justify-content-end set_quantity">
                            <li className="page-item">
                              <button
                                className="page-link"
                                onclick="decreaseNumber('textbox','itemval')"
                              >
                                <i className="fas fa-minus"></i>
                              </button>
                            </li>
                            <li className="page-item">
                              <input
                                type="text"
                                name=""
                                className="page-link"
                                value="0"
                                id="textbox"
                              />
                            </li>
                            <li className="page-item">
                              <button
                                className="page-link"
                                onclick="increaseNumber('textbox','itemval')"
                              >
                                <i className="fas fa-plus"></i>
                              </button>
                            </li>
                          </ul>
                        </div>
                      </div>
                      {/* <!-- //remover move and price --> */}
                      <div className="row">
                        <div className="col-8 d-flex justify-content-between remove_wish">
                          <p>
                            <i className="fas fa-trash-alt delete_icon"></i>{" "}
                            REMOVE ITEM
                          </p>
                        </div>
                        <div className="col-4 d-flex justify-content-end price_money">
                          <h3>
                            $<span id="itemval">0.00 </span>
                          </h3>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <hr />

                {/* <!-- 2nd cart product --> */}
                <div className="card p-4">
                  <div className="row">
                    {/* <!-- cart images div --> */}
                    <div className="col-md-5 col-11 mx-auto bg-light d-flex justify-content-center align-items-center shadow product_img">
                      <img
                        src="images/img3.png"
                        className="img-fluid"
                        alt="cart img"
                      />
                    </div>

                    {/* <!-- cart product details --> */}
                    <div className="col-md-7 col-11 mx-auto px-4 mt-2">
                      <div className="row">
                        {/* <!-- product name  --> */}
                        <div className="col-6 card-title">
                          <h1 className="mb-4 product_name">
                            Green Zara Shirt
                          </h1>
                          <p className="mb-2">SHIRT - Green</p>
                          <p className="mb-2">COLOR: Green</p>
                          <p className="mb-3">SIZE: M</p>
                        </div>
                        {/* <!-- quantity inc dec --> */}
                        <div className="col-6">
                          <ul className="pagination justify-content-end set_quantity">
                            <li className="page-item">
                              <button
                                className="page-link"
                                onclick="decreaseNumber('textbox1','itemval1')"
                              >
                                <i className="fas fa-minus"></i>
                              </button>
                            </li>
                            <li className="page-item">
                              <input
                                type="text"
                                name=""
                                className="page-link"
                                value="0"
                                id="textbox1"
                              />
                            </li>
                            <li className="page-item">
                              <button
                                className="page-link"
                                onclick="increaseNumber('textbox1','itemval1')"
                              >
                                <i className="fas fa-plus"></i>
                              </button>
                            </li>
                          </ul>
                        </div>
                      </div>
                      {/* <!-- //remover move and price --> */}
                      <div className="row">
                        <div className="col-8 d-flex justify-content-between remove_wish">
                          <p>
                            <i className="fas fa-trash-alt delete_icon"></i>{" "}
                            REMOVE ITEM
                          </p>
                        </div>
                        <div className="col-4 d-flex justify-content-end price_money">
                          <h3>
                            $<span id="itemval1">0.00 </span>
                          </h3>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              {/* <!-- right side div --> */}

              <div className="col-md-12 col-lg-4 col-11 mx-auto mt-lg-0 mt-md-5">
                <div className="right_side p-3 shadow bg-white">
                  <h2 className="product_name mb-5">The Total Amount Of</h2>
                  <div className="price_indiv d-flex justify-content-between">
                    <p>Product amount</p>
                    <p>
                      $<span id="product_total_amt">0.00</span>
                    </p>
                  </div>
                  <div className="price_indiv d-flex justify-content-between">
                    <p>Shipping Charge</p>
                    <p>
                      $<span id="shipping_charge">50.0</span>
                    </p>
                  </div>
                  <hr />
                  <div className="total-amt d-flex justify-content-between font-weight-bold">
                    <p>The total amount of (including VAT)</p>
                    <p>
                      $<span id="total_cart_amt">0.00</span>
                    </p>
                  </div>
                  {/* <button className="btn btn-primary text-uppercase">
                    Checkout
                  </button> */}
                  <Link className="btn btn-primary text-uppercase" to="/shop/cart/checkout">
                  Checkout
                  </Link>
                </div>
                {/* <!-- discount code part --> */}
                <div className="discount_code mt-3 shadow">
                  <div className="card">
                    <div className="card-body">
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
                <div classNameName="mt-3 shadow p-3 bg-white">
                  <div classNameName="pt-4">
                    <h5 className="mb-4">Expected delivery date</h5>
                    <p>July 27th 2020 - July 29th 2020</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Cart;
