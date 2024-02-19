import { Link } from "react-router-dom/cjs/react-router-dom.min";
import "./Seller.css";
import React from 'react';
// import Instructions from './Instructions.js'
// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";

const  sidebar = () => {
    return (
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
          <i className="fas fa-project-diagram me-2"></i>Products
        </Link>
        <Link
          to="/seller/orderlist"
          className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
        >
          <i className="fas fa-chart-line me-2"></i>Order List
        </Link>
        <Link
          to="#"
          className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
        >
          <i className="fas fa-paperclip me-2"></i>Available Stock
        </Link>
        <Link
          to="#"
          className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
        >
          <i className="fas fa-shopping-cart me-2"></i>Store Mng
        </Link>
        <Link
          to="#"
          className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
        >
          <i className="fas fa-gift me-2"></i>Products
        </Link>
        <Link
          to="#"
          className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
        >
          <i className="fas fa-comment-dots me-2"></i>Chat
        </Link>
        <Link
          to="#"
          className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
        >
          <i className="fas fa-map-marker-alt me-2"></i>Outlet
        </Link>
        <p
          // to="/"
          style={{ cursor: "pointer" }}
          className="list-group-item list-group-item-action bg-transparent text-danger fw-bold"
        >
          <i className="fas fa-power-off me-2"></i>Logout
        </p>
        </div>
      </div>
    </div>
    );
}

// export default {sidebar};
export default sidebar;