import "../../ComponentsSeller/SellerProfile.css";
import { useState } from "react";
import farmerService from "../../../services/farmer.service";
import { useEffect } from "react";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import { Button } from "react-bootstrap";

function FarmerProfile() {
  const [farmerProfile, setFarmerProfile] = useState([]);
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

    await farmerService
      .updateFarmerProfile(userId, updatedData)
      .then((res) => {
        onload(userId);
        setEnableEdit(false);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const onload = async (userId) => {
    await farmerService
      .getFarmerProfile(userId)
      .then((result) => {
        setFarmerProfile(result["data"]);
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
                          {farmerProfile["firstName"] +
                            "  " +
                            farmerProfile["lastName"]}
                        </h4>
                        <p className="text-secondary mb-1">
                          {farmerProfile["userType"]}
                        </p>
                        <p className="text-muted font-size-sm">
                          Status : {farmerProfile["status"]}
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

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
                            defaultValue={farmerProfile["firstName"]}
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
                            defaultValue={farmerProfile["lastName"]}
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
                            defaultValue={farmerProfile["email"]}
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
                            defaultValue={farmerProfile["mobileNo"]}
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
                      />{" "}
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
                          <button className="btn btn-primary">View More</button>
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
                          <button className="btn btn-primary">View More</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
export default FarmerProfile;
