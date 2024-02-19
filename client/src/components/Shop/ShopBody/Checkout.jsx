import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import { useLocation } from "react-router-dom";
import "./Checkout.css"
import Navbar from "../Common/NavBar";
import Footer from "../Common/Footer";
import { useHistory } from 'react-router-dom';
import { ToastContainer, toast } from "react-toastify";
import { useEffect, useState } from "react";
import UserDetails from "../../../services/user.service";
import Ordercart from "../../../services/ordercart.service";

const Checkout = () => {

    const [customer, setCustomer] = useState([]);
    const [state, setState] = useState();
    const [city, setCity] = useState();
    const [pincode, setPincode] = useState();
    const [address, setAddress] = useState();

    const history = useHistory();

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const totalAmount = parseFloat(searchParams.get("totalAmount"));

    const onload = async() => {
        const customer = parseInt(localStorage.getItem("userId"));
        await UserDetails.getCustomer(customer)
                    .then((result) => {
                        setCustomer(result['data'])
                        setState(result['data']['userAddress']['state'])
                        setCity(result['data']['userAddress']['city'])
                        setPincode(result['data']['userAddress']['pincode'])
                        setAddress(result['data']['userAddress']['fullAddress'])
                        console.log(result);
                    })
                    .catch((error) => {
                        console.log(error);
                    })
    }

    const order = async() => {
        const customer = parseInt(localStorage.getItem("userId"));
        await Ordercart.order(customer, totalAmount)
                .then((result) => {
                    toast.success("WOhooooooo Order on the way");
                    console.log(result);
                    history.push('/shop/orders');
                })
                .catch((error) => {
                    console.log(error);
                })
    }

    useEffect(() => {
        onload();
    },[])

    return(
        <div>
        <Navbar></Navbar>
        <div style={{height:80}}></div>
        <section className="ftco-section">
            <div className="container">
                <div className="row justify-content-center">
                    <div className="col-xl-7 ftco-animate mt-5 pt-3">
                        <form action="#" className="billing-form">
                            <h3 className="mb-4 billing-heading">Billing Details</h3>
                            <div className="row align-items-end">
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="firstname">First Name</label>
                                        <input type="text" className="form-control" placeholder="" value={customer['firstName']}/>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="lastname">Last Name</label>
                                        <input type="text" className="form-control" placeholder="" value={customer['lastName']}/>
                                    </div>
                                </div>
                                <div className="w-100"></div>
                                <div className="col-md-12">
                                    <div className="form-group">
                                        <label for="country">State</label>
                                        <input type="text" name="" id="" value={state}/>
                                        <div className="select-wrap">
                                            <div className="icon"><span className="ion-ios-arrow-down"></span></div>
                                            {/* <input type="text" name="" id="" value={customer['state']}/> */}
                                        </div>
                                    </div>
                                </div>
                                <div className="w-100"></div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="streetaddress">Street Address</label>
                                        <input type="text" className="form-control" value={address}/>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <input type="text" className="form-control" placeholder="Apartment, suite, unit, etc. (optional)"/>
                                    </div>
                                </div>
                                <div className="w-100"></div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="towncity">Town / City</label>
                                        <input type="text" className="form-control" placeholder="" value={city}/>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="postcodezip">Postcode / ZIP *</label>
                                        <input type="text" className="form-control" placeholder="" value={pincode}/>
                                    </div>
                                </div>
                                <div className="w-100"></div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="phone">Phone</label>
                                        <input type="text" className="form-control" placeholder="" value={customer['mobileNo']}/>
                                    </div>
                                </div>
                                <div className="col-md-6">
                                    <div className="form-group">
                                        <label for="emailaddress">Email Address</label>
                                        <input type="text" className="form-control" placeholder="" value={customer['email']}/>
                                    </div>
                                </div>
                                <div className="w-100"></div>
                                <div className="col-md-12">
                                    <div className="form-group mt-4">
                                        <div className="radio">
                                            {/* <label className="mr-3"><input type="radio" name="optradio"/> Create an Account? </label> */}
                                            <label>Ship to a different address { }<a href="" className="address-link">Click here</a></label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div className="col-xl-5">
                        <div className="row mt-5 pt-3">
                            <div className="col-md-12">
                                <div className="cart-detail cart-total p-3 p-md-4">
                                    <h3 className="billing-heading mb-4">Cart Total</h3>
                                    <p className="d-flex">
                                        <span>Subtotal</span>
                                        <span>₹ {totalAmount-50}</span>
                                    </p>
                                    <p className="d-flex">
                                        <span>Delivery </span>
                                        <span>  ₹ 50.00</span>
                                    </p>
                                    <p className="d-flex">
                                        <span>Discount</span>
                                        <span>  ₹ 0.00</span>
                                    </p>
                                    <hr/>
                                    <p className="d-flex total-price">
                                        <span>Total</span>
                                        <span>₹ {totalAmount}</span>
                                    </p>
                                </div>
                                <div className="cart-detail p-3 p-md-4 mt-5 pt-3 mb-5">
                                    
                                    <h3 className="billing-heading mb-4">Payment Method</h3>
                                    <div className="form-group">
                                        <div className="col-md-12">
                                            <div className="radio">
                                                <label><input type="radio" name="optradio" className="mr-2"/> Direct Bank Transfer</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <div className="col-md-12">
                                            <div className="radio">
                                                <label><input type="radio" name="optradio" className="mr-2"/> Check Payment</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <div className="col-md-12">
                                            <div className="radio">
                                                <label><input type="radio" name="optradio" className="mr-2 mb-3"/> Paypal</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <div className="col-md-12">
                                            <div className="checkbox">
                                                <label><input type="checkbox" value="" className="mr-2 mb-3"/> I have read and accept the terms and conditions</label>
                                            </div>
                                        </div>
                                    </div>
                                    <p><a href="#" className="btn btn-primary" onClick={() => {order()}}>ordered</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <ToastContainer></ToastContainer>
        <Footer></Footer>
    </div>
    
    );
};

export default Checkout;