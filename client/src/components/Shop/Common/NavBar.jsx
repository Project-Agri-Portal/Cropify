import React from "react";
import logo from "../../../logo.png";
import { Container, Navbar, Nav } from "react-bootstrap";
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../../../../node_modules/bootstrap/dist/js/bootstrap.bundle";
import "./NavBar.css";
// import Orders from "../ShopBody/Orders";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const myNavbar = () => {
  const onLogout = () => {
    sessionStorage.removeItem("userId");
    localStorage.removeItem("userId");
    toast.warn("LogOut");
  };

  return (
    <Navbar className="bg-success bg-opacity-75" sticky="top">
      <Container>
        <Navbar.Brand as={Link} to="/home" className="d-flex align-items-center gap-1">
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
          <Nav.Link as={Link} to="/home/customer" className="nav-link fs-5">
            Home
          </Nav.Link>
          <Nav.Link as={Link} to="/shop/productsall" className="nav-link fs-5">
            Shops
          </Nav.Link>
          <Nav.Link as={Link} to="/shop/orders" className="nav-link fs-5">
            Orders
          </Nav.Link>
          <Nav.Link as={Link} to="/shop/cart" className="nav-link fs-5">
            Cart
          </Nav.Link>
          <Nav.Link as={Link} to="/contact" className="nav-link fs-5">
            Contact Us
          </Nav.Link>
          <Nav.Link
            as={Link} to="/home"
            className="nav-link fs-5"
            onClick={() => {
              onLogout();
            }}
          >
            Logout
          </Nav.Link>
          <Nav.Link as={Link} to="/shop/profile" className="nav-link fs-5">
            Profile
          </Nav.Link>
        </Nav>
      </Container>
      <ToastContainer></ToastContainer>
    </Navbar>
  );
};

export default myNavbar;
