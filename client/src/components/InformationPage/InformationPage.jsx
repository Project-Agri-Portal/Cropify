import * as React from "react";
import { Container, Navbar, Nav } from "react-bootstrap";
import logo from "../../logo.png";
import FarmerHome from "../HomePage/FarmerHome/FarmerHome";
import Footer from "../Shop/Common/Footer";
import MainWeather from "./MainWeather";
import { Link } from "react-router-dom/cjs/react-router-dom.min";

function InformationPage() {
  return (
    <>
      <Navbar className="bg-success bg-opacity-75" sticky="top">
        <Container>
          <Link to="/">
            <Navbar.Brand
              className="d-flex align-items-center gap-1"
            >
              <img
                className="d-inline-block object-fit-cover"
                src={logo}
                width="40"
                height="40"
                alt="cropify logo"
              />
              <span className="fs-4 text-white">CROPIFY</span>
            </Navbar.Brand>
          </Link>

          {/* Login and Register links */}
          <Nav className="d-flex gap-3">
            <Nav.Link as={Link} to="/home/customer" className="nav-link fs-5">
              Shop
            </Nav.Link>
            <Nav.Link as={Link} to="/home/information" className="nav-link fs-5">
              Information
            </Nav.Link>
            <Nav.Link as={Link} to="/login" className="nav-link fs-5">
              Login
            </Nav.Link>
            <Nav.Link as={Link} to="/register" className="nav-link fs-5">
              Register
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <section className="my-5">
        <h1 className="my-5 text-body-secondary fw-semibold">
          Farming information at your fingertips!
        </h1>
        <FarmerHome></FarmerHome>
      </section>

      <section className="my-5">
        <h1 className="my-5 text-body-secondary fw-semibold">Weather Index</h1>
        <MainWeather></MainWeather>
      </section>

      <Footer></Footer>
    </>
  );
}

export default InformationPage;
