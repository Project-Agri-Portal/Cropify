import { useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./Register.css";
import registerService from "../../../services/login.service";
// import { Tabs, Tab } from "react-bootstrap";
// import CustomerFields from "./CustomerFields/CustomerFields";
// import FarmerFields from './FarmerFields/FarmerFields';
// import SellerFields from './SellerFields/SellerFields';

function Register() {
  const [bgColor, setBgColor] = useState("#bde3ff");
  const [btnOnFocus, setBtnOnFocus] = useState("customer");

  const history = useHistory();
  // Method to change the color of the form div and the respective tab
  // const ChangeBgColor = (key) => {
  //   if (key === "customer") {
  //     setBgColor("#bde3ff");
  //     setBtnOnFocus("customer");
  //   }
  //   else if (key === "farmer") {
  //     setBgColor("#aff4c6");
  //     setBtnOnFocus("farmer");
  //   }
  //   else if (key === "seller") {
  //     setBgColor("#ffc7c2");
  //     setBtnOnFocus("seller");
  //   }
  // }

  const register = async (e) => {
    e.preventDefault();

    const formData = new FormData(e.target);
    console.log(formData);
    const userData = {
      firstName: formData.get("firstName"),
      lastName: formData.get("lastName"),
      mobileNo: formData.get("mobileNo"),
      email: formData.get("email"),
      password: formData.get("password"),
      userAddress: {
        city: formData.get("city"),
        state: formData.get("state"),
        pincode: formData.get("pincode"),
        fullAddress: formData.get("fullAddress"),
      },
      userType: formData.get("userType"),
      aadharNo: "111111111111",   // To change
      panNo: "1111111111",        // To change
      status: "",
    };

    await registerService.registerUser(userData)
      .then((res) => {
        if (res.status === 201) {
          console.log(res.data);
          history.replace("/login");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <>
      <h1 className="my-5">User Sign Up</h1>
      <div
        className="w-50 rounded main-register-div"
        style={{ backgroundColor: bgColor }}
      >
        <Form
          className="text-start px-3 fs-5"
          method="POST"
          onSubmit={register}
        >
          <Row className="mb-3">
            <Form.Group as={Col} controlId="formUserFirstName">
              <Form.Label>First Name</Form.Label>
              <Form.Control
                type="text"
                name="firstName"
                placeholder="Enter first name"
              />
            </Form.Group>

            <Form.Group as={Col} controlId="formUserLastName">
              <Form.Label>Last Name</Form.Label>
              <Form.Control
                type="text"
                name="lastName"
                placeholder="Enter last name"
              />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col} controlId="formUserEmail">
              <Form.Label>Email</Form.Label>
              <Form.Control
                type="email"
                name="email"
                placeholder="Enter email"
              />
            </Form.Group>

            <Form.Group as={Col} controlId="formUserPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control
                type="password"
                name="password"
                placeholder="Password"
              />
            </Form.Group>
          </Row>

          <Row className="mb-3">
            <Form.Group as={Col} controlId="formUserMobile">
              <Form.Label>Mobile</Form.Label>
              <Form.Control
                type="text"
                name="mobileNo"
              />
            </Form.Group>

            <Form.Group as={Col} controlId="formUserType">
              <Form.Label>Register as</Form.Label>
              <Form.Check
                inline
                type="radio"
                name="userType"
                label="Customer"
                value="CUSTOMER"
              />
              <Form.Check
                inline
                type="radio"
                name="userType"
                label="Farmer"
                value="FARMER"
              />
              <Form.Check
                inline
                type="radio"
                name="userType"
                label="Seller"
                value="SELLER"
              />
            </Form.Group>
          </Row>

          <Form.Group className="mb-3" controlId="formUserAddress1">
            <Form.Label>Address</Form.Label>
            <Form.Control name="fullAddress" placeholder="1234 Main St" />
          </Form.Group>

          <Row className="mb-3">
            <Form.Group as={Col} controlId="formUserCity">
              <Form.Label>City</Form.Label>
              <Form.Control name="city" />
            </Form.Group>

            <Form.Group as={Col} controlId="formUserState">
              <Form.Label>State</Form.Label>
              <Form.Select name="state" defaultValue="Choose...">
                <option>Choose...</option>
                <option>Maharashtra</option>
                <option>Gujarat</option>
                <option>Rajasthan</option>
              </Form.Select>
            </Form.Group>

            <Form.Group as={Col} controlId="formUserZip">
              <Form.Label>Pincode</Form.Label>
              <Form.Control
                type="number"
                name="pincode"
                placeholder="eg: 440015"
              />
            </Form.Group>
          </Row>

          <center>
            <Row className="w-25">
              <Form.Group className="mb-3 text-start" id="formUserCheckbox">
                <Form.Check type="checkbox" label="I am Customer" />
              </Form.Group>

              <Button variant="success" size="lg" type="submit">
                Register
              </Button>
            </Row>
          </center>
        </Form>
        {/* <Tabs
          defaultActiveKey='customer'
          id='login-tabs'
          className='mb-4'
          onSelect={(key) => { ChangeBgColor(key) }}
          justify
        > */}
        {/* Customer tab and it's content */}
        {/* <Tab eventKey='customer' title='Customer'
            tabClassName={'customer-btn ' + (btnOnFocus === "customer" ? 'customer-active' : '')}>
            <CustomerFields />
          </Tab> */}

        {/* Farmer tab and it's content */}
        {/* <Tab eventKey='farmer' title='Farmer'
            tabClassName={'farmer-btn ' + (btnOnFocus === "farmer" ? 'farmer-active' : '')}>
            <FarmerFields />
          </Tab> */}

        {/* Seller tab and it's content */}
        {/* <Tab eventKey='seller' title='Seller'
            tabClassName={'seller-btn ' + (btnOnFocus === "seller" ? 'seller-active' : '')}>
            <SellerFields />
          </Tab>*/}
        {/* </Tabs>   */}
      </div>
    </>
  );
}

export default Register;
