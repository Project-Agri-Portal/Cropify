import * as React from "react";
import { Link, useHistory } from "react-router-dom/cjs/react-router-dom.min";
import logo from "../../logo.png";
// import Instructions from './Instructions.js'
// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";

const SellerSidebar = () => {
  const history = useHistory();

  // Loggin out user and clearing the storages
  function logoutUser() {
    localStorage.clear();
    sessionStorage.clear();
    history.replace("/");
  }

  return (
    <div className="bg-white" id="sidebar-wrapper">
      <div id="sidebar">
        <div className="sidebar-heading text-center py-4 border-bottom">
          <Link to="/" className="primary-text fs-4 fw-bold text-uppercase">
            <img src={logo} alt="cropify logo" width="40" height="40" />
            {' '}Cropify
          </Link>
        </div>
        <div className="text-start list-group list-group-flush my-3">
          <Link
            to="/home/seller"
            className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
          >
            <i className="fas fa-user me-2"></i>My Profile
          </Link>
          <Link
            to="/seller/dashboard"
            className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
          >
            <i className="fas fa-tachometer-alt me-2"></i>Dashboard
          </Link>
          <Link
            to="/seller/productlist"
            className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
          >
            <i className="fas fa-project-diagram me-2"></i>My Machines
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
            onClick={logoutUser}
            style={{ cursor: "pointer" }}
            className="list-group-item list-group-item-action bg-transparent text-danger fw-bold"
          >
            <i className="fas fa-power-off me-2"></i>Logout
          </p>
        </div>
      </div>
    </div>
  );
};

// export default {sidebar};
export default SellerSidebar;
