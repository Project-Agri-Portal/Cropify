import logo from "../../../logo.svg";
import { Container, Navbar, Nav, Tab, Tabs } from "react-bootstrap";
import farmer from "../../../assets/farmer.png";

function FarmerProfile() {
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

      <header style={{ height: "100vh" }}>
        <div className="container d-flex justify-content-around align-items-center">
          <div className="w-auto" style={{ height: "400px" }}>
            <img src={farmer} alt="farmer" className="w-100 h-100" />
          </div>
          <div className="text-start">
            <h3>Farmer Name</h3>
            <h5>User ID : 1234</h5>
            <h5>Age : 45</h5>
            <h5>Email : Abc@gmail.com</h5>
            <h5>Address : Nagpur</h5>
          </div>
        </div>

        <Tabs
          defaultActiveKey="profile"
          id="justify-tab-example"
          className="mb-3"
          justify
        >
          <Tab eventKey="home" title="About Me">
            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Officia,
            animi? Sed, delectus officiis. Accusantium quasi saepe nostrum,
            eaque architecto asperiores facilis eum alias, totam dolores unde
            fugiat atque, dolor reprehenderit.
          </Tab>
          <Tab eventKey="profile" title="Farm Info">
            Tab content for Farm Info
          </Tab>
          <Tab eventKey="longer-tab" title="Settings">
            <h3>Tab for Settings</h3>
          </Tab>
          <Tab eventKey="contact" title="Contact">
            <h3>Tab content for Contact</h3>
            <p>
              Lorem ipsum dolor sit, amet consectetur adipisicing elit.
              Quibusdam officiis libero aliquam minus, nihil nobis alias
              facilis, eveniet accusamus qui sequi tempora incidunt sunt
              exercitationem molestiae? Sapiente praesentium laboriosam
              nesciunt!
            </p>
          </Tab>
        </Tabs>
      </header>
      <footer className="w-100 bg-primary" style={{ height: "100px" }}></footer>
    </>
  );
}
export default FarmerProfile;