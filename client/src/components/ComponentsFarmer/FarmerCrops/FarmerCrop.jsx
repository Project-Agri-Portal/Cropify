import { Container, Navbar, Nav, Breadcrumb, ListGroup } from "react-bootstrap";
import logo from "../../../logo.svg";
import wheat from "../../../assets/wheat.png";
import Footer from "../../Shop/Common/Footer";

function FarmerCrop() {
  const alertClicked = () => {
    alert("You clicked the third ListGroupItem");
  };

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
            <span className="fs-3 text-black">CROPIFY</span>
          </Navbar.Brand>

          {/* Login and Register links */}
          <Nav className="d-flex gap-3">
            <Nav.Link href="/farmer/profile" className="nav-link fs-4">
              Profile
            </Nav.Link>
            <Nav.Link href="/crop/wheat" className="nav-link fs-4">
              Crop Info
            </Nav.Link>
            <Nav.Link href="/blog" className="nav-link fs-4">
              Blog
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <header className="mx-5 mt-5" style={{ height: "100vh" }}>
        <Breadcrumb>
          <Breadcrumb.Item href="#">Home</Breadcrumb.Item>
          <Breadcrumb.Item href="https://getbootstrap.com/docs/4.0/components/breadcrumb/">
            Agriculture
          </Breadcrumb.Item>
          <Breadcrumb.Item href="#">Cereals</Breadcrumb.Item>
          <Breadcrumb.Item active>Wheat</Breadcrumb.Item>
        </Breadcrumb>

        <div className="mt-5 d-flex gap-3">
          <div className="d-flex flex-column gap-5 w-25">
            <div style={{ height: "350px" }}>
              <img
                className="object-fit-none h-100 w-auto"
                src={wheat}
                alt="wheat"
              />
            </div>
            <div>
              <ListGroup defaultActiveKey="#link1">
                <ListGroup.Item action href="#link1">
                  Link 1
                </ListGroup.Item>
                <ListGroup.Item action href="#link2">
                  Link 2
                </ListGroup.Item>
                <ListGroup.Item action href="#link3" onClick={alertClicked}>
                  Link 3
                </ListGroup.Item>
                <ListGroup.Item action href="#link4">
                  Link 4
                </ListGroup.Item>
              </ListGroup>
            </div>
          </div>
          <div className="text-start">
            <h3>Wheat</h3>
            <p>
              Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quia
              magnam totam perferendis. Quo, voluptate praesentium? Mollitia et
              cupiditate suscipit beatae eligendi doloribus eveniet aliquam
              voluptates at quidem, rerum est veniam! Lorem ipsum dolor sit amet
              consectetur, adipisicing elit. Esse inventore, ex, id ullam
              tempora veritatis delectus dolorum voluptatibus possimus, sint eum
              vero earum consectetur quam rerum. Ab nulla officia eius?
            </p>
          </div>
        </div>
      </header>

      <Footer></Footer>
    </>
  );
}

export default FarmerCrop;
