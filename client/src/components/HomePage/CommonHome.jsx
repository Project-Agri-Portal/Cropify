import { Link } from "react-router-dom";
import * as React from "react";
import { Container, Navbar, Nav, Carousel } from "react-bootstrap";
import logo from "../../logo.png";
import heroBg1 from "../../assets/hero-section-bg-2.jpg";
import heroBg2 from "../../assets/hero-section-bg-3.jpg";
import support from "../../assets/support.svg";
import vegetable from "../../assets/vegetable.svg";
import freshFood from "../../assets/fresh-food.svg";
import organic from "../../assets/organic-product.svg";
import "./CommonHome.css";
import TeamSection from "../Shop/ShopBody/TeamSection";
import Footer from "../Shop/Common/Footer";

function CommonHome() {
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

      <Carousel data-bs-theme="light" pause="false">
        <Carousel.Item>
          <div className="main-hero-div">
            <img className="hero-img" src={heroBg2} alt="hero section" />
            <div className="col-5 hero-text">
              <h1>Providing customers with natural produce</h1>
            </div>
          </div>
        </Carousel.Item>
        <Carousel.Item>
          <div className="main-hero-div">
            <img className="hero-img" src={heroBg1} alt="hero section" />
            <div className="col-4 hero-text">
              <h1>Helping farmers increase profits</h1>
            </div>
          </div>
        </Carousel.Item>
      </Carousel>

      <section className="features-section">
        <div className="container">
          <div className="row">
            <div className="col-12">
              <div className="row justify-vertical">
                <div className="col-12 col-lg-4">
                  <div className="service-heading">
                    <h4>Our Features</h4>
                    <h2>We Provide Best Services</h2>
                    <p className="text-muted">
                      Lorem, ipsum dolor sit amet consectetur adipisicing elit.
                      Omnis, eum corporis tenetur, asperiores, magni autem
                      commodi id assumenda sit itaque odio consequuntur.
                    </p>
                  </div>
                </div>
                <div className="col-12 col-lg-8">
                  <div className="row text-start">
                    <div className="col-12 col-md-6 col-lg-6 my-3">
                      <div className="service-item">
                        <img
                          className="my-2"
                          src={vegetable}
                          alt="veggie logo"
                        />
                        <h4 className="my-3">Vegetable Care</h4>
                        <p className="text-muted">
                          Lorem ipsum dolor sit amet consectetur adipisicing
                          elit. Obcaecati recusandae ab quo rerum nemo, eaque
                          deleniti consequatur ducimus.
                        </p>
                      </div>
                    </div>
                    <div className="col-12 col-md-6 col-lg-6 my-3">
                      <div className="service-item">
                        <img className="my-2" src={freshFood} alt="food logo" />
                        <h4 className="my-3">Fresh Food</h4>
                        <p className="text-muted">
                          Lorem ipsum, dolor sit amet consectetur adipisicing
                          elit. In ullam totam temporibus quasi repellendus ab
                          dolor libero ipsam esse et.
                        </p>
                      </div>
                    </div>
                    <div className="col-12 col-md-6 col-lg-6 my-3">
                      <div className="service-item">
                        <img
                          className="my-2"
                          src={organic}
                          alt="organic logo"
                        />
                        <h4 className="my-3">Organic Products</h4>
                        <p className="text-muted">
                          Lorem ipsum dolor sit amet, consectetur adipisicing
                          elit. Rem dignissimos aspernatur dolorem labore
                          consequatur culpa aperiam minima.
                        </p>
                      </div>
                    </div>
                    <div className="col-12 col-md-6 col-lg-6 my-3">
                      <div className="service-item">
                        <img
                          className="my-2"
                          src={support}
                          alt="support logo"
                        />
                        <h4 className="my-3">24x7 Support</h4>
                        <p className="text-muted">
                          Lorem ipsum dolor sit amet consectetur adipisicing
                          elit. Id, tempore assumenda dolor accusamus
                          voluptates, rem eligendi numquam dicta.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <TeamSection></TeamSection>
      <Footer></Footer>
    </>
  );
}

export default CommonHome;
