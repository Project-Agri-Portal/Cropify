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
import util from "../../utils/machinery.json";
import logo from "../../logo.png";

function MachineryPage() {
  return (
    <>
      <Navbar className="bg-success bg-opacity-75" sticky="top">
        <Container>
          <Navbar.Brand
            href="/home"
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

          {/* Login and Register links */}
          <Nav className="d-flex gap-3">
            <Nav.Link href="/home/customer" className="nav-link fs-5">
              Shop
            </Nav.Link>
            <Nav.Link href="/home/information" className="nav-link fs-5">
              Information
            </Nav.Link>
            <Nav.Link href="/login" className="nav-link fs-5">
              Login
            </Nav.Link>
            <Nav.Link href="/register" className="nav-link fs-5">
              Register
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <section className="container my-5">
        <Tab.Container id="machinery-list" defaultActiveKey="#tillage">
          <Row>
            <Col sm={4}>
              <ListGroup defaultActiveKey="#tillage">
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
                      {value.map((machine) => {
                        return Object.entries(machine).map(([key, value]) => {
                          return (
                            <div key={key}>
                              <h3 className="text-secondary">{key}</h3>
                              {Object.entries(value).map(([dKey, dValue]) => {
                                return (
                                  <p key={dKey} className="text-dark">
                                    <span className="fw-bold">{dKey}:</span>{" "}
                                    {dValue}
                                  </p>
                                );
                              })}
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

export default MachineryPage;
