import React, { useState } from "react";
import logo from "../../../logo.png";
import { Container, Navbar, Nav, Carousel } from "react-bootstrap";
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../../../../node_modules/bootstrap/dist/js/bootstrap.bundle";
import "./NavBar.css";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const myNavbar = () => {
  const onLogout = () => {
    localStorage.removeItem("userId");
    toast.warn("LogOut");
  };

  return (
    // <nav className="my-navbar navbar-expand-lg fixed-top">
    //   <div className="container-fluid">
    //     <Link className={`my-navbar-brand me-auto`} to="/">
    //       CROPIFY
    //     </Link>
    //     <div
    //       className={`offcanvas offcanvas-end }`}
    //       tabIndex="-1"
    //       id="offcanvasNavbar"
    //       aria-labelledby="offcanvasNavbarLabel"
    //     >
    //       <div className="offcanvas-header">
    //         <h5 className="offcanvas-title" id="offcanvasNavbarLabel">
    //           Logo
    //         </h5>
    //         <button
    //           type="button"
    //           className="btn-close"
    //           aria-label="Close"
    //         ></button>
    //       </div>
    //       <div className="offcanvas-body">
    //         <ul className="navbar-nav justify-content-center flex-grow-1 pe-3">
    //           <li className="nav-item">
    //             {/* <a className="nav-link mx-lg-2 active" aria-current="page" href="#">
    //               Home
    //             </a> */}
    //             <Link to="/home/customer" className="nav-link mx-lg-2 active">
    //               Home
    //             </Link>
    //           </li>
    //           <li className="nav-item">
    //             <Link className="nav-link mx-lg-2" to="/shop/productsall">
    //               Shop
    //             </Link>
    //           </li>
    //           <li className="nav-item">
    //             <Link className="nav-link mx-lg-2" to="shop/about">
    //               About Us
    //             </Link>
    //           </li>
    //           <li className="nav-item">
    //             {/* <a className="nav-link mx-lg-2" href="#">
    //               Contact
    //             </a> */}
    //             <Link to="/contact" className="nav-link mx-lg-2">
    //               Contact
    //             </Link>
    //           </li>
    //           <li className="nav-item">
    //             {/* <a className="nav-link mx-lg-2" href="#">
    //               Contact
    //             </a> */}
    //             <Link to="/shop/cart" className="nav-link mx-lg-2">
    //               Cart
    //             </Link>
    //           </li>
    //           <li className="nav-item">
    //             {/* <a className="nav-link mx-lg-2" href="#">
    //               Contact
    //             </a> */}
    //             <Link to="/blog" className="nav-link mx-lg-2">
    //               Blog
    //             </Link>
    //           </li>
    //           <li className="nav-item">
    //             {/* <a className="nav-link mx-lg-2" href="#">
    //               Contact
    //             </a> */}
    //             <Link to="/" className="nav-link mx-lg-2">
    //               <a href="" onClick={onLogout}>Logout</a>
    //             </Link>
    //           </li>
    //         </ul>
    //       </div>
    //     </div>
    //     <Link to="/login" className="login-button">
    //       Profile
    //     </Link>
    //     <button
    //       className="my-navbar-toggler pe-0 "
    //       type="button"
    //       aria-label="Toggle navigation"
    //     >
    //       <span className="my-navbar-toggler-icon"></span>
    //     </button>
    //   </div>
    // </nav>
    <Navbar className="bg-success bg-opacity-75" sticky="top">
      <Container>
        <Navbar.Brand href="/home" className="d-flex align-items-center gap-1">
          <img
            className="d-inline-block object-fit-cover"
            src={logo}
            width="40"
            height="40"
            alt="cropify logo"
          />
          <span className="fs-4 text-white">CROPIFY</span>
        </Navbar.Brand>

        {/* Login and Register links */}
        <Nav className="d-flex gap-3">
          <Nav.Link href="/home/customer" className="nav-link fs-5">
            Home
          </Nav.Link>
          <Nav.Link href="/shop/productsall" className="nav-link fs-5">
            Shops
          </Nav.Link>
          <Nav.Link href="/shop/cart" className="nav-link fs-5">
            Cart
          </Nav.Link>
          <Nav.Link href="/contact" className="nav-link fs-5">
            Contact Us
          </Nav.Link>
        </Nav>
      </Container>
    </Navbar>
  );
};

export default myNavbar;
