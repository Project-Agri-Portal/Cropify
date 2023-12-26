import { useState } from 'react';
import { InputGroup, Form, Tabs, Tab } from 'react-bootstrap';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../../../node_modules/bootstrap/dist/js/bootstrap.bundle';
import './Login.css';

function Login() {
  const [bgColor, setBgColor] = useState("#bde3ff");
  const [btnOnFocus, setBtnOnFocus] = useState("customer");

  const ChangeBgColor = (key) => {
    if (key === "customer") {
      setBgColor("#bde3ff");
      setBtnOnFocus("customer");
    }
    else if (key === "farmer") {
      setBgColor("#aff4c6");
      setBtnOnFocus("farmer");
    }
    else if (key === "seller") {
      setBgColor("#ffc7c2");
      setBtnOnFocus("seller");
    }
  }

  return (
    <>
      <h1 className='my-5'>User Sign In</h1>
      <div className='w-50 rounded mainFormDiv' style={{ "backgroundColor": bgColor }}>

        <Tabs
          defaultActiveKey='customer'
          id='login-tabs'
          className='mb-5'
          onSelect={(key) => { ChangeBgColor(key) }}
          justify
        >
          <Tab eventKey='customer' title='Customer' 
            tabClassName={'customer-btn ' + (btnOnFocus === "customer" ? 'customer-active' : '')}>
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

            <button className='btn btn-dark btn-lg'>
              Login
            </button>
          </Tab>

          <Tab eventKey='farmer' title='Farmer' 
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

            <button className='btn btn-dark btn-lg'>
              Login
            </button>
          </Tab>

          <Tab eventKey='seller' title='Seller'
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

            <button className='btn btn-dark btn-lg'>
              Login
            </button>
          </Tab>
        </Tabs>

      </div>
    </>
  );
}

export default Login;