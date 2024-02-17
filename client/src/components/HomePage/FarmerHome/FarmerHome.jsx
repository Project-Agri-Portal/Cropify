import { Container, Navbar, Nav } from "react-bootstrap";
import logo from "../../../logo.png";
import map from "../../../assets/Map.png";
import Footer from "../../Shop/Common/Footer";

function FarmerHome() {

  var paramArr = ["Temperature", "Soil Index", "Rainfall meter", "Humidity", "Wind Speed", "", "", "", "", "","",""];

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
            <Nav.Link href="/farmer/cropinfo" className="nav-link fs-4">
              Crop Info
            </Nav.Link>
            <Nav.Link href="/blog" className="nav-link fs-4">
              Blog
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <header className="container" style={{ height: "100vh" }}>
        <div className="d-flex" style={{ paddingTop: "5em" }}>
          <div className="">
            <img className="w-100" src={map} alt="india map" />
          </div>
          <div className="w-50 bg-secondary table-responsive">
            <table className="table table-bordered table-success table-striped fs-4">
              <thead>
                <tr>
                  <th>Parameter</th>
                  <th>Value</th>
                </tr>
              </thead>
              <tbody>
                {paramArr.map((param, i) => {
                  return (
                    <tr>
                      {param !== "" ?
                        <td>{param}</td> :
                        <td>Parameter-{i + 1}</td>
                      }
                      <td>Value-{i + 1}</td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </header>

      <Footer></Footer>
    </>
  );
}

export default FarmerHome;
