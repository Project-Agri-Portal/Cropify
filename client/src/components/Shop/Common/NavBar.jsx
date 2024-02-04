import React, { useState } from "react";
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../../../../node_modules/bootstrap/dist/js/bootstrap.bundle";
import "./NavBar.css";
import { Link } from "react-router-dom/cjs/react-router-dom.min";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg fixed-top">
      <div className="container-fluid">
        <Link className={`navbar-brand me-auto`} to="/">
          CROPIFY
        </Link>
        <div
          className={`offcanvas offcanvas-end }`}
          tabIndex="-1"
          id="offcanvasNavbar"
          aria-labelledby="offcanvasNavbarLabel"
        >
          <div className="offcanvas-header">
            <h5 className="offcanvas-title" id="offcanvasNavbarLabel">
              Logo
            </h5>
            <button
              type="button"
              className="btn-close"
              aria-label="Close"
            ></button>
          </div>
          <div className="offcanvas-body">
            <ul className="navbar-nav justify-content-center flex-grow-1 pe-3">
              <li className="nav-item">
                {/* <a className="nav-link mx-lg-2 active" aria-current="page" href="#">
                  Home
                </a> */}
                <Link to="/home/customer" className="nav-link mx-lg-2 active">
                  Home
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link mx-lg-2" to="#">
                  Shop
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link mx-lg-2" to="shop/about">
                  About Us
                </Link>
              </li>
              <li className="nav-item">
                {/* <a className="nav-link mx-lg-2" href="#">
                  Contact
                </a> */}
                <Link to="/contact" className="nav-link mx-lg-2">
                  Contact
                </Link>
              </li>
              <li className="nav-item">
                {/* <a className="nav-link mx-lg-2" href="#">
                  Contact
                </a> */}
                <Link to="/blog" className="nav-link mx-lg-2">
                  Blog
                </Link>
              </li>
            </ul>
          </div>
        </div>
        <Link to="/login" className="login-button">
          Log In
        </Link>
        <button
          className="navbar-toggler pe-0"
          type="button"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
      </div>
    </nav>
  );
};

export default Navbar;
