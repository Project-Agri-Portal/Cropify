import { useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import { InputGroup, Form, Tabs, Tab, Button } from "react-bootstrap";
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle";
import "./Login.css";
// import axios from "axios";
import loginService from "../../../services/login.service";

function Login() {
  const [bgColor, setBgColor] = useState("#bde3ff");
  const [btnOnFocus, setBtnOnFocus] = useState("customer");

  const history = useHistory();
  // ---------- Controlled Input operation --------------
  // const [email, setEmail] = useState();
  // const [password, setPassword] = useState();
  // const emailChange = ({target:{value}}) => setEmail(value);
  // const passwordChange = ({target:{value}}) => setPassword(value);

  // -------------------------------------------------------------------------
  // Method to change the color of the form div and respective tab that is clicked
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

  // ---------- Login operation -------------------
  const userLogin = async (e) => {
    // -------- preventing the form's default behaviour ---------------
    e.preventDefault();

    // loaded the form-data in a FormData object and stored the target entity
    const loginData = new FormData(e.target);
    // console.log(loginData.get('email') + "-------" + loginData.get('password'));
    const credentials = {
      email: loginData.get("email"),
      password: loginData.get("password"),
    };

    // stored the required fields in an object and passed it to axios http method
    // using the imported file name 'backend'
    await loginService.loginUser(credentials)
      .then((res) => {
        console.log(res.data);
        // storing the user type (customer, farmer, seller)
        const userType = res.data['userType'] + "";

        // Redirecting to respective user type's home page on successfull login
        if (res.status === 200) {
          localStorage.setItem('userId', res.data['id']);
          history.replace("/home/" + userType.toLowerCase());
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <h1 className="my-5">User Sign In</h1>
      <div
        className="w-50 rounded main-login-div"
        style={{ backgroundColor: bgColor }}
      >
        <Form method="POST" onSubmit={userLogin}>
          <Tabs
            defaultActiveKey="customer"
            id="login-tabs"
            className="mb-5"
            // onSelect={(key) => { ChangeBgColor(key) }}
            justify
          >
            {/* Customer tab and it's content */}
            <Tab
              eventKey="customer"
              title="Customer"
              tabClassName={
                "customer-btn " +
                (btnOnFocus === "customer" ? "customer-active" : "")
              }
            >
              <InputGroup size="lg" className="mb-5 w-50">
                <InputGroup.Text className="w-25" id="email">
                  User Email
                </InputGroup.Text>
                <Form.Control
                  type="text"
                  name="email"
                  aria-label="email"
                  aria-describedby="email field"
                />
              </InputGroup>

              <InputGroup size="lg" className="mb-5 w-50">
                <InputGroup.Text className="w-25" id="password">
                  Password
                </InputGroup.Text>
                <Form.Control
                  type="password"
                  name="password"
                  aria-label="password"
                  aria-describedby="password field"
                />
              </InputGroup>

              <Button className="btn btn-dark btn-lg mb-3" type="submit">
                Login
              </Button>

              <p>
                New Customer?{" "}
                <Link to="/register" className="create-span">
                  Create account
                </Link>
              </p>
            </Tab>

            {/* Farmer tab and it's content */}
            {/* <Tab eventKey='farmer' title='Farmer'
            tabClassName={'farmer-btn ' + (btnOnFocus === "farmer" ? 'farmer-active' : '')}>
            <InputGroup size='lg' className='mb-5 w-50'>
              <InputGroup.Text className='w-25' id='username'>
                Username
              </InputGroup.Text>
              <Form.Control
                type='text'
                aria-label='username'
                aria-describedby='username field'
              />
            </InputGroup>

            <InputGroup size='lg' className='mb-5 w-50'>
              <InputGroup.Text className='w-25' id='password'>
                Password
              </InputGroup.Text>
              <Form.Control
                type='password'
                aria-label='password'
                aria-describedby='password field'
              />
            </InputGroup>

            <button className='btn btn-dark btn-lg mb-3'>
              <Link to="/home/farmer" className="text-decoration-none text-white">Login</Link>
            </button>

            <p>New Farmer? <Link to="/register" className='create-span'>Create account</Link></p>
          </Tab> */}

            {/* Seller tab and it's content */}
            {/* <Tab eventKey='seller' title='Seller'
            tabClassName={'seller-btn ' + (btnOnFocus === "seller" ? 'seller-active' : '')}>
            <InputGroup size='lg' className='mb-5 w-50'>
              <InputGroup.Text className='w-25' id='username'>
                Username
              </InputGroup.Text>
              <Form.Control
                type='text'
                aria-label='username'
                aria-describedby='username field'
              />
            </InputGroup>

            <InputGroup size='lg' className='mb-5 w-50'>
              <InputGroup.Text className='w-25' id='password'>
                Password
              </InputGroup.Text>
              <Form.Control
                type='password'
                aria-label='password'
                aria-describedby='password field'
              />
            </InputGroup>

            <button className='btn btn-dark btn-lg mb-3'>
              <Link to="/home/seller" className="text-decoration-none text-white">Login</Link>
            </button>

            <p>New Seller? <Link to="/register" className='create-span'>Create account</Link></p>
          </Tab> */}
          </Tabs>
        </Form>
      </div>
    </>
  );
}

export default Login;
