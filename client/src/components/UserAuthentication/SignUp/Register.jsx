import { useState } from 'react';
import { Tabs, Tab } from 'react-bootstrap';
import '../../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../../../../node_modules/bootstrap/dist/js/bootstrap.bundle';
import './Register.css';
import CustomerFields from './CustomerFields/CustomerFields';
import FarmerFields from './FarmerFields/FarmerFields';
import SellerFields from './SellerFields/SellerFields';

function Login() {
  const [bgColor, setBgColor] = useState("#bde3ff");
  const [btnOnFocus, setBtnOnFocus] = useState("customer");

  // Method to change the color of the form div and the respective tab
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
      <h1 className='my-5'>User Sign Up</h1>
      <div className='w-50 rounded main-register-div' style={{ "backgroundColor": bgColor }}>

        <Tabs
          defaultActiveKey='customer'
          id='login-tabs'
          className='mb-4'
          onSelect={(key) => { ChangeBgColor(key) }}
          justify
        >
          {/* Customer tab and it's content */}
          <Tab eventKey='customer' title='Customer'
            tabClassName={'customer-btn ' + (btnOnFocus === "customer" ? 'customer-active' : '')}>
            <CustomerFields />
          </Tab>

          {/* Farmer tab and it's content */}
          <Tab eventKey='farmer' title='Farmer'
            tabClassName={'farmer-btn ' + (btnOnFocus === "farmer" ? 'farmer-active' : '')}>
            <FarmerFields />
          </Tab>

          {/* Seller tab and it's content */}
          <Tab eventKey='seller' title='Seller'
            tabClassName={'seller-btn ' + (btnOnFocus === "seller" ? 'seller-active' : '')}>
            <SellerFields />
          </Tab>
        </Tabs>

      </div>
    </>
  );
}

export default Login;