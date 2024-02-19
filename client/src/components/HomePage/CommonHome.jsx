import * as React from "react";
import { Link } from "react-router-dom";
import { Container, Navbar, Nav, Carousel } from "react-bootstrap";
import logo from "../../logo.png";
import heroBg1 from "../../assets/hero-section-bg-2.jpg";
import heroBg2 from "../../assets/hero-section-bg-3.jpg";
import support from "../../assets/support.svg";
import vegetable from "../../assets/vegetable.svg";
import freshFood from "../../assets/fresh-food.svg";
import organic from "../../assets/organic-product.svg";
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../../../node_modules/bootstrap/dist/js/bootstrap.bundle";
import "./CommonHome.css";
import TeamSection from "../Shop/ShopBody/TeamSection";
import Footer from "../Shop/Common/Footer";

function CommonHome() {
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
            <div class="col-12">
              <div class="row justify-vertical">
                <div class="col-12 col-lg-4">
                  <div class="service-heading">
                    <h4>Our Features</h4>
                    <h2>We Provide Our Best Services</h2>
                    <p class="text-muted">
                      Replacing a maintains the amount of lines. When replacing
                      a selection. help agencies to define their new business
                      objectives and then create.
                    </p>
                  </div>
                </div>
                <div class="col-12 col-lg-8">
                  <div class="row text-start">
                    <div class="col-12 col-md-6 col-lg-6 my-3">
                      <div class="service-item">
                        <img class="my-2" src={vegetable} alt="Image" />
                        <h4 class="my-3">Vegetable Care</h4>
                        <p class="text-muted">
                          Replacing a maintains the amount of lines. When
                          replacing a selection.
                        </p>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-6 my-3">
                      <div class="service-item">
                        <img class="my-2" src={freshFood} alt="Image" />
                        <h4 class="my-3">Fresh Food</h4>
                        <p class="text-muted">
                          Replacing a maintains the amount of lines. When
                          replacing a selection.
                        </p>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-6 my-3">
                      <div class="service-item">
                        <img class="my-2" src={organic} alt="Image" />
                        <h4 class="my-3">Organic Products</h4>
                        <p class="text-muted">
                          Replacing a maintains the amount of lines. When
                          replacing a selection.
                        </p>
                      </div>
                    </div>
                    <div class="col-12 col-md-6 col-lg-6 my-3">
                      <div class="service-item">
                        <img class="my-2" src={support} alt="Image" />
                        <h4 class="my-3">24x7 Support</h4>
                        <p class="text-muted">
                          Replacing a maintains the amount of lines. When
                          replacing a selection.
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
