import * as React from "react";
import {
  Container,
  ListGroup,
  Row,
  Tab,
  Col,
  Navbar,
  Nav,
} from "react-bootstrap";
import util from "../../utils/crops.json";
import logo from "../../logo.png";
import { Link } from "react-router-dom/cjs/react-router-dom.min";

function CropsPage() {
  return (
    <>
      <Navbar className="bg-success bg-opacity-75" sticky="top">
        <Container>
          <Link to="/">
            <Navbar.Brand className="d-flex align-items-center gap-1">
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
            <Nav.Link
              as={Link}
              to="/home/information"
              className="nav-link fs-5"
            >
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

      <section className="container my-5">
        <Tab.Container id="crops-list" defaultActiveKey="#wheat">
          <Row>
            <Col sm={4}>
              <ListGroup defaultActiveKey="#wheat">
                {Object.entries(util).map(([key]) => {
                  return (
                    <ListGroup.Item
                      action
                      href={"#" + key.toLowerCase()}
                      key={key}
                    >
                      {key}
                    </ListGroup.Item>
                  );
                })}
              </ListGroup>
            </Col>

            <Col sm={8}>
              <Tab.Content className="text-start">
                {Object.entries(util).map(([key, value]) => {
                  return (
                    <Tab.Pane eventKey={"#" + key.toLowerCase()} key={key}>
                      {value.map((crop) => {
                        return Object.entries(crop).map(([key, value]) => {
                          return (
                            <div key={key}>
                              <h3 className="text-secondary">{key}</h3>
                              <p key={key} className="text-dark">
                                {value}
                              </p>
                              <hr />
                            </div>
                          );
                        });
                      })}
                    </Tab.Pane>
                  );
                })}
              </Tab.Content>
            </Col>
          </Row>
        </Tab.Container>
      </section>
    </>
  );
}

export default CropsPage;
