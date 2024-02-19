import { Link, useHistory } from "react-router-dom";
// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./SellerProfile.css";
import { useState } from "react";
import sellerService from "../../services/seller.service";
import { useEffect } from "react";
// import logo from "../../logo.png";
import SellerSidebar from "./sidebar";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import { Button } from "react-bootstrap";

function SellerProfile() {
  const history = useHistory();

  // Loggin out user and clearing the storages
  // function logoutUser() {
  //   localStorage.clear();
  //   sessionStorage.clear();
  //   history.replace("/");
  // }
  // const [userId, setUserId] = useState();
  const [sellerProfile, setSellerProfile] = useState([]);
  const [enableEdit, setEnableEdit] = useState(false);

  const updateInfo = async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    const updatedData = {
      firstName: formData.get("firstName"),
      lastName: formData.get("lastName"),
      email: formData.get("email"),
      mobileNo: formData.get("mobileNo"),
    };

    let userId;
    if (sessionStorage.getItem("userId")) {
      userId = sessionStorage.getItem("userId");
    } else if (localStorage.getItem("userId")) {
      userId = localStorage.getItem("userId");
    }

    await sellerService
      .updateSellerProfile(userId, updatedData)
      .then((res) => {
        onload(userId);
        setEnableEdit(false);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const onload = async (userId) => {
    await sellerService
      .getSellerProfile(userId)
      .then((result) => {
        setSellerProfile(result["data"]);
        console.log(result["data"]);
      })
      .catch((error) => {
        console.log(error);
        console.log("in error");
      });
  };

  useEffect(() => {
    let userId;
    if (sessionStorage.getItem("userId")) {
      userId = sessionStorage.getItem("userId");
    } else if (localStorage.getItem("userId")) {
      userId = localStorage.getItem("userId");
    }
    onload(userId);
  }, []);

  return (
    <>
      <div className="d-flex" id="wrapper">
        {/* <!-- Sidebar --> */}
        <SellerSidebar />

        {/* <!-- /#sidebar-wrapper --> */}
        {/* ======================================================================================================== */}

        {/* <!-- Nav Bar --> */}

        <div id="page-content-wrapper">
          <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
            <div className="d-flex align-items-center">
              <i className="fas fa-user me-2"></i>
              <h2 className="fs-2 m-0">My Profile</h2>
            </div>
          </nav>

          <br />
          {/* =================================================================================================== */}

          {/* <!-- Seller Profile Here--> */}

          <div className="container" style={{ color: "black" }}>
            <div className="main-body">
              <div className="row gutters-sm">
                <div className="col-md-4 mb-3">
                  <div className="profileDetail">
                    <div className="profileDetail-body">
                      <div className="d-flex flex-column align-items-center text-center">
                        <img
                          src="https://bootdey.com/img/Content/avatar/avatar7.png"
                          alt="Admin"
                          className="rounded-circle"
                          width="150"
                        />
                        <div className="mt-3" style={{ color: "black" }}>
                          <h4>
                            {sellerProfile["firstName"] +
                              "  " +
                              sellerProfile["lastName"]}
                          </h4>
                          <p className="text-secondary mb-1">
                            {sellerProfile["userType"]}
                          </p>
                          <p className="text-muted font-size-sm">
                            Status : {sellerProfile["status"]}
                          </p>
                          {/* <button className="btn btn-primary">Likes</button>
                          {"  "}
                          <button className="btn btn-primary">Reviews</button> */}
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                {/* ======================================================================================================= */}
                {/* Links Facebook insta ans all  */}

                {/* <div
                  className="profileDetail mt-3"
                  style={{ backgroundColor: "burlywood" }}
                >
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
                          strokeWidth="2"
                          strokeLinecap="round"
                          strokeLinejoin="round"
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
                          strokeWidth="2"
                          strokeLinecap="round"
                          strokeLinejoin="round"
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
                          strokeWidth="2"
                          strokeLinecap="round"
                          strokeLinejoin="round"
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
                          strokeWidth="2"
                          strokeLinecap="round"
                          strokeLinejoin="round"
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
                          strokeWidth="2"
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          className="feather feather-facebook mr-2 icon-inline text-primary"
                        >
                          <path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path>
                        </svg>
                        Facebook
                      </h6>
                      <span className="text-secondary">Facebook.com</span>
                    </li>
                  </ul>
                </div> */}

                {/* =================================================================================================== */}

                {/* Profile Detail Name and all */}

                <div className="col-md-8">
                  <div className="profileDetail mb-3">
                    <div className="profileDetail-body">
                      <Form method="PUT" onSubmit={updateInfo}>
                        <Form.Group
                          as={Row}
                          className="mb-3"
                          controlId="formPlaintextFirstName"
                        >
                          <Form.Label column sm="2">
                            First Name
                          </Form.Label>
                          <Col sm="10">
                            <Form.Control
                              plaintext={!enableEdit}
                              readOnly={!enableEdit}
                              name="firstName"
                              defaultValue={sellerProfile["firstName"]}
                            />
                          </Col>
                        </Form.Group>
                        <Form.Group
                          as={Row}
                          className="mb-3"
                          controlId="formPlaintextLastName"
                        >
                          <Form.Label column sm="2">
                            Last Name
                          </Form.Label>
                          <Col sm="10">
                            <Form.Control
                              plaintext={!enableEdit}
                              readOnly={!enableEdit}
                              name="lastName"
                              defaultValue={sellerProfile["lastName"]}
                            />
                          </Col>
                        </Form.Group>

                        <Form.Group
                          as={Row}
                          className="mb-3"
                          controlId="formPlaintextEmail"
                        >
                          <Form.Label column sm="2">
                            Email
                          </Form.Label>
                          <Col sm="10">
                            <Form.Control
                              plaintext={!enableEdit}
                              readOnly={!enableEdit}
                              name="email"
                              defaultValue={sellerProfile["email"]}
                            />
                          </Col>
                        </Form.Group>

                        <Form.Group
                          as={Row}
                          className="mb-3"
                          controlId="formPlaintextMobile"
                        >
                          <Form.Label column sm="2">
                            Mobile
                          </Form.Label>
                          <Col sm="10">
                            <Form.Control
                              plaintext={!enableEdit}
                              readOnly={!enableEdit}
                              name="mobileNo"
                              defaultValue={sellerProfile["mobileNo"]}
                            />
                          </Col>
                        </Form.Group>

                        <Button
                          onClick={() => setEnableEdit(true)}
                          hidden={enableEdit}
                        >
                          Edit
                        </Button>
                        <Button
                          as="input"
                          type="submit"
                          value="Update"
                          hidden={!enableEdit}
                        />
                        {' '}
                        <Button
                          variant="danger"
                          onClick={() => setEnableEdit(false)}
                          hidden={!enableEdit}
                        >
                          Cancel
                        </Button>
                      </Form>
                    </div>
                  </div>

                  {/* ====================================================================================================== */}

                  <div className="row gutters-sm">
                    <div className="col-sm-6 mb-3">
                      <div className="profileDetail h-100">
                        <div className="profileDetail-body">
                          <h6 className="d-flex align-items-center mb-3">
                            <i className="material-icons text-info mr-2"></i>
                            Product Reviews
                          </h6>
                          <small>Wheat</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "80%" }}
                              aria-valuenow="80"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Rice</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "72%" }}
                              aria-valuenow="72"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Bajra</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "89%" }}
                              aria-valuenow="89"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Makka</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "55%" }}
                              aria-valuenow="55"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Fruits</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "66%" }}
                              aria-valuenow="66"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <div>
                            <button className="btn btn-primary">
                              View More
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div className="col-sm-6 mb-3">
                      <div className="profileDetail h-100">
                        <div className="profileDetail-body">
                          <h6 className="d-flex align-items-center mb-3">
                            <i className="material-icons text-info mr-2"></i>
                            Stock Remaining
                          </h6>
                          <small>Wheat</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "80%" }}
                              aria-valuenow="80"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Rice</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "72%" }}
                              aria-valuenow="72"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Bajra</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "89%" }}
                              aria-valuenow="89"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Makka</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "55%" }}
                              aria-valuenow="55"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <small>Fruits</small>
                          <div
                            className="progress mb-3"
                            style={{ height: "5px" }}
                          >
                            <div
                              className="progress-bar bg-primary"
                              role="progressbar"
                              style={{ width: "66%" }}
                              aria-valuenow="66"
                              aria-valuemin="0"
                              aria-valuemax="100"
                            ></div>
                          </div>
                          <div>
                            <button className="btn btn-primary">
                              View More
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
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
export default SellerProfile;
