// import { Link } from "react-router-dom/cjs/react-router-dom.min";
import { Container, Navbar, Nav } from "react-bootstrap";
import logo from '../../logo.svg';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../../../node_modules/bootstrap/dist/js/bootstrap.bundle';
import './CommonHome.css';

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
            <span className="fs-3">CROPIFY</span>
          </Navbar.Brand>

          <Nav className="d-flex gap-3">
            <Nav.Link href="/login" className="nav-link fs-4">
              Login
            </Nav.Link>
            <Nav.Link href="/register" className="nav-link fs-4">
              Register
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}

export default CommonHome;