import { Container, Navbar, Nav } from "react-bootstrap";
import logo from "../../../logo.svg";
import map from "../../../assets/Map.png";

function FarmerHome() {
  return (
    <>
      <Navbar className="bg-warning-subtle">
        <Container>
          <Navbar.Brand
            href="/home"
            className="d-flex align-items-center gap-1"
          >
            <img
              className="d-inline-block object-fit-cover"
              src={logo}
              width="50"
              height="50"
              alt="cropify logo"
            />
            <span className="fs-3">CROPIFY</span>
          </Navbar.Brand>

          {/* Login and Register links */}
          <Nav className="d-flex gap-3">
            <Nav.Link href="/farmer/profile" className="nav-link fs-4">
              Profile
            </Nav.Link>
            <Nav.Link href="/crop/wheat" className="nav-link fs-4">
              Crop Info
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <header className="container" style={{ height: "100vh" }}>
        <div className="d-flex" style={{ paddingTop: "10em" }}>
          <div className="">
            <img className="w-100" src={map} alt="india map" />
          </div>
          <div className="w-50 bg-secondary"></div>
        </div>
      </header>

      <footer className="w-100 bg-primary" style={{ height: "100px" }}></footer>
    </>
  );
}

export default FarmerHome;
