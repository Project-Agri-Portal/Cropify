// import { Link } from "react-router-dom/cjs/react-router-dom.min";
import { Container, Navbar, Nav } from "react-bootstrap";
import logo from '../../logo.svg';
import heroBg from '../../assets/hero-section-bg.jpg';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../../../node_modules/bootstrap/dist/js/bootstrap.bundle';
import './CommonHome.css';
import TeamSection from "../Shop/ShopBody/TeamSection";
import Footer from "../Shop/Common/Footer";

function CommonHome() {
  return (
    <>
      <Navbar className="bg-warning-subtle">
        <Container>
          <Navbar.Brand href="/home" className="d-flex align-items-center gap-1">
            <img className="d-inline-block object-fit-cover"
              src={logo} width="50" height="50"
              alt="cropify logo"
            />
            <span className="fs-3 text-black">CROPIFY</span>
          </Navbar.Brand>

          {/* Login and Register links */}
          <Nav className="d-flex gap-3">
            <Nav.Link href="/home/customer" className="nav-link fs-4">
              Shop
            </Nav.Link>
            <Nav.Link href="/login" className="nav-link fs-4">
              Login
            </Nav.Link>
            <Nav.Link href="/register" className="nav-link fs-4">
              Register
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <div className="main-hero-div">
        <img className="hero-img"
          src={heroBg}
          alt="hero section"
        />
        <div className="hero-text">
          <h2>Welcome</h2>
          <h2>To</h2>
          <h2>Cropify</h2>
        </div>
      </div>

      <TeamSection></TeamSection>
      <Footer></Footer>
    </>
  );
}

export default CommonHome;