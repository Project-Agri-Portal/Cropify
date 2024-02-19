// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Link,useHistory } from "react-router-dom/cjs/react-router-dom.min";
import "./SellerProfile.css";
import { useState } from "react";
import Seller from "../../services/seller.service";
import { useEffect } from "react";
import sidebar from "./sidebar";

function SellerEdit() {


  const history = useHistory();

  // Loggin out user and clearing the storages
  function logoutUser() {
    localStorage.clear();
    sessionStorage.clear();
    history.replace("/");
  }
 



  const [sellerProfile, setSellerProfile] = useState([]);
  const [email, setEmail] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [mobileNo, setMobileNo] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [pincode, setPincode] = useState("");


  const onload = async (userId) => {
    await Seller.getSellerProfile(userId)
      .then((result) => {
        setSellerProfile(result["data"]);
        setEmail(result["data"]['email'])
        setFirstName(result["data"]['firstName'])
        setLastName(result["data"]['lastName'])
        setLastName(result["data"]['lastName'])
        setMobileNo(result["data"]['mobileNo'])
        setCity(result["data"]['userAddress']['city'])
        setState(result["data"]['userAddress']['state'])
        setPincode(result["data"]['userAddress']['pincode'])
        console.log(result["data"]);
      })
      .catch((error) => {
        console.log(error);
        console.log("in error");
      });
  };


  

  const firstNameChange = (e) => {
    setFirstName(e.target.value)
  }

  const lastNameChange = (e) => {
    setLastName(e.target.value)
  }

  const emailChange = (e) => {
    setEmail(e.target.value)
  }
  

  const mobileChange = (e) => {
    setMobileNo(e.target.value)
  }


  
  const cityChange = (e) => {
    setCity(e.target.value)
  }

  const stateChange = (e) => {
    setState(e.target.value)
  }

  const pincodeChange = (e) => {
    setPincode(e.target.value)
  }



  // const updateData = async () => {
  //   try {
  //     const userId = localStorage.getItem("userId");

  //     await Seller.updateSellerProfile(userId, {
  //       firstName: firstName,
  //       lastName: lastName,
  //       email: email,
  //       mobileNo: mobileNo,
  //       userAddress: {
  //         city: city,
  //         state: state,
  //         pincode: pincode,
  //       },
  //     });

  //     // Redirect to the seller dashboard after successful update
  //     // history.push("/home/seller");
  //   } catch (error) {
  //     console.log("Error updating profile:", error);
  //   }
  // };


  useEffect(() => {
    const userId = localStorage.getItem("userId");
    onload(userId);
  }, []);


  // const updateData = async(req,res) => {
  //   // const {userId,firstName,lastName,email,mobileNo,city,pincode,state} = req.body;
  //   // console.log(result["data"]);
  //   // await Seller.updateSellerProfile(userId).then
  //   try{
  //     await Seller.updateSellerProfile({userId},{
  //       $set:{
  //         firstName:firstName,
  //         lastName:lastName,
  //         email:email,
  //         mobileNo:mobileNo,
  //         city:city,
  //         pincode:pincode,
  //         state:state
  //       }
  //     })

  //     return res.json({status:"ok",data:"update"})
  //   } catch(error){
  //     return res.json({status:"error",data:error})
  //   }
  // }


  return (
    <>
      <div className="d-flex" id="wrapper">
        {/* <!-- Sidebar --> */}
        



<div className="bg-white" id="sidebar-wrapper">
          <div id="sidebar">
          <div className="sidebar-heading text-center py-4 border-bottom">
            <Link to="/" className="primary-text fs-4 fw-bold text-uppercase">
              <i className="bx bxs-leaf"></i> Cropify
            </Link>
          </div>
          <div className="list-group list-group-flush my-3">
            <Link
              to="/home/seller"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-tachometer-alt me-2"></i>Dashboard
            </Link>
            <Link
              to="/seller/productlist"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-project-diagram me-2"></i>Machines
            </Link>
            <Link
              to="/seller/orderlist"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-chart-line me-2"></i>Order List
            </Link>
            
            <Link
              to="/seller/addproduct"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-gift me-2"></i>Add New Machine
            </Link>
           
            <p
              // to="/"
              onClick={logoutUser}
              style={{ cursor: "pointer" }}
              className="list-group-item list-group-item-action bg-transparent text-danger fw-bold"
            >
              <i className="fas fa-power-off me-2"></i>Logout
            </p>
            </div>
          </div>
        </div>


        {/* <!-- /#sidebar-wrapper --> */}

        {/* <!-- Nav Bar --> */}
        <div id="page-content-wrapper">
          <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
            <div className="d-flex align-items-center">
              <i className="fas fa-project-diagram me-2"></i>
              <h2 className="fs-2 m-0">My Profile</h2>
            </div>

            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>

            <div
              className="collapse navbar-collapse"
              id="navbarSupportedContent"
            >
              <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
                <li className="nav-item dropdown">
                  <Link
                    className="nav-link dropdown-toggle second-text fw-bold"
                    to="#"
                    id="navbarDropdown"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                    style={{ color: "rgb(11, 11, 10)" }}
                  >
                    <i className="fas fa-user me-2"></i>{sellerProfile.firstName}   {sellerProfile.lastName}
                  </Link>
                  <ul
                    className="dropdown-menu"
                    aria-labelledby="navbarDropdown"
                  >
                    <li>
                      <Link className="dropdown-item" to="#">
                        My Profile
                      </Link>
                    </li>
                    <li>
                      <Link className="dropdown-item" to="#">
                        Settings
                      </Link>
                    </li>
                    <li>
                      <Link className="dropdown-item" to="#">
                        Logout
                      </Link>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </nav>
          <br />

          {/* <!-- Seller Profile Here--> */}
          <div className="container">
            <div className="main-body">
              <div className="row gutters-sm">
                <div className="col-md-4 mb-3">
                  <div className="card">
                    <div className="card-body">
                      <div className="d-flex flex-column align-items-center text-center">
                        <img
                          src="https://bootdey.com/img/Content/avatar/avatar7.png"
                          alt="Admin"
                          className="rounded-circle"
                          width="150"
                        />
                        <div className="mt-3">
                          <h4>{sellerProfile['firstName']} {sellerProfile['lastName']}</h4>
                          <p className="text-secondary mb-1">
                          {sellerProfile["userType"]}
                          </p>
                          <p className="text-muted font-size-sm">
                            {sellerProfile['status']}
                          </p>
                          <button className="btn btn-primary mr-4">Likes</button>
                          {"  "}
                          <button className="btn btn-primary ml-2">
                            Reviews
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div className="card mt-3">
                    <ul className="list-group list-group-flush">
                      <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                        <h6 className="mb-0">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            stroke-width="2"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            className="feather feather-globe mr-2 icon-inline"
                          >
                            <circle cx="12" cy="12" r="10"></circle>
                            <line x1="2" y1="12" x2="22" y2="12"></line>
                            <path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path>
                          </svg>
                          Website
                        </h6>
                        <span className="text-secondary">
                          https://mywebsite.com
                        </span>
                      </li>
                      <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                        <h6 className="mb-0">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            stroke-width="2"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            className="feather feather-github mr-2 icon-inline"
                          >
                            <path d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path>
                          </svg>
                          Github
                        </h6>
                        <span className="text-secondary">mygit</span>
                      </li>
                      <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                        <h6 className="mb-0">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            stroke-width="2"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            className="feather feather-twitter mr-2 icon-inline text-info"
                          >
                            <path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path>
                          </svg>
                          Twitter
                        </h6>
                        <span className="text-secondary">myTwitter</span>
                      </li>
                      <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                        <h6 className="mb-0">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            stroke-width="2"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            className="feather feather-instagram mr-2 icon-inline text-danger"
                          >
                            <rect
                              x="2"
                              y="2"
                              width="20"
                              height="20"
                              rx="5"
                              ry="5"
                            ></rect>
                            <path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path>
                            <line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line>
                          </svg>
                          Instagram
                        </h6>
                        <span className="text-secondary">myInsta</span>
                      </li>
                      <li className="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                        <h6 className="mb-0">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            stroke="currentColor"
                            stroke-width="2"
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            className="feather feather-facebook mr-2 icon-inline text-primary"
                          >
                            <path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path>
                          </svg>
                          Facebook
                        </h6>
                        <span className="text-secondary">Facebook.com</span>
                      </li>
                    </ul>
                  </div>
                </div>


                <div className="col-lg-8">
                  <div className="card">
                    <div className="card-body">
                      <div className="row mb-3">
                        <div className="col-sm-3">
                          <h6 className="mb-2">First Name</h6>
                        </div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="text"
                            className="form-control"
                            value={firstName}
                            onChange={firstNameChange}
                          />
                        </div>
                      </div>


                      <div className="row mb-3">
                        <div className="col-sm-3">
                          <h6 className="mb-2">Last Name</h6>
                        </div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="text"
                            className="form-control"
                            value={lastName}
                            onChange={lastNameChange}
                          />
                        </div>
                      </div>


                      <div className="row mb-3">
                        <div className="col-sm-3">
                          <h6 className="mb-0">Email</h6>
                        </div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="text"
                            className="form-control"
                            value={email}
                            onChange={emailChange}
                          />
                        </div>
                      </div>


                     


                      <div className="row mb-3">
                        <div className="col-sm-3">
                          <h6 className="mb-0">Mobile</h6>
                        </div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="text"
                            className="form-control"
                            value={mobileNo}
                            onChange={mobileChange}
                          />
                        </div>
                      </div>


                      <div className="row mb-3">
                        <div className="col-sm-3">
                          <h6 className="mb-0">Pincode</h6>
                        </div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="text"
                            className="form-control"
                            value={pincode}
                            onChange={pincodeChange}
                          />
                        </div>
                      </div>


                      <div className="row mb-3">
                        <div className="col-sm-3">
                          <h6 className="mb-0">City</h6>
                        </div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="text"
                            className="form-control"
                            value={city}
                            onChange={cityChange}
                          />
                        </div>
                      </div>



                      <div className="row mb-3">
                        <div className="col-sm-3">
                          <h6 className="mb-0">State</h6>
                        </div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="text"
                            className="form-control"
                            value={state}
                            onChange={stateChange}
                          />
                        </div>
                      </div>



                      
                      

                      <div className="row">
                        <div className="col-sm-3"></div>
                        <div className="col-sm-9 text-secondary">
                          <input
                            type="button"
                            className="btn btn-primary"
                            value="Update"
                            // onClick={updateData}
                            to="/home/seller"
                          />
                           {/* <Link to="/home/seller" className="btn btn-primary"
                                                >Update</Link> */}
                        </div>
                      </div>


                    </div>
                  </div>
                  <br />

                  
                </div>
              </div>
            </div>
          </div>
          {/* <!--  Seller Profile Here--> */}
        </div>
      </div>
    </>
  );
}

export default SellerEdit;