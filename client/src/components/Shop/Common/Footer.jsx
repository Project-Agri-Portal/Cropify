import React, { useState } from 'react';
import { Link } from 'react-router-dom/cjs/react-router-dom.min';
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import "./NavBar.css"

const Footer = () => {
  return (
    <footer className="bg-light text-dark pt-5 pb-4">
      <div style={{ height: "50px" }}></div>
      {/* <!-- Footer First --> */}
      <div className="container text-center text-md-left">
        <div className="row text-center text-md-left">
          <div className="col-md-3 col xl-3 mx-auto mt-3">
            <h5 className="text-uppercase mb-4 font-weight-bold text-info">
              Agriculture Portal
            </h5>
            <p>
              "Empowering farmers through technology: Our Agriculture Portal
              cultivates a seamless ecosystem where farmers can not only sell
              their harvest but also harvest knowledge. Whether it's sharing
              products, insights, or machinery, we're sowing the seeds of
              collaboration for a thriving agricultural community."
            </p>
          </div>

          {/* <!-- Footer Second --> */}
          <div className="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
            <h5 className="text-uppercase mb-4 font-weight-bold text-info">
              Menu
            </h5>
            <p>
              <Link to="/home/customer" className="text-dark" style={{ textdecoration: "none" }}>
                Shop
              </Link>
            </p>
            <p>
              <Link to="/shop/about" className="text-dark" style={{ textdecoration: "none" }}>
                About Us
              </Link>
            </p>
            <p>
              <Link to="/blog" className="text-dark" style={{ textdecoration: "none" }}>
                Blogs
              </Link>
            </p>
            <p>
              <Link to="/contact" className="text-dark" style={{ textdecoration: "none" }}>
                Contact us
              </Link>
            </p>
          </div>

          {/* <!-- Footer Third --> */}
          <div className="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
            <h5 className="text-uppercase mb-4 font-weight-bold text-info">
              Help
            </h5>
            <p>
              <Link to="#" className="text-dark" style={{ textdecoration: "none" }}>
                Shopping Information
              </Link>
            </p>
            <p>
              <Link to="#" className="text-dark" style={{ textdecoration: "none" }}>
                Return and Exchange
              </Link>
            </p>
            <p>
              <Link to="#" className="text-dark" style={{ textdecoration: "none" }}>
                Terms & Condition
              </Link>
            </p>
            <p>
              <Link to="#" className="text-dark" style={{ textdecoration: "none" }}>
                FAQ's
              </Link>
            </p>
          </div>

          {/* <!-- Footer Fourth --> */}
          <div className="col-lg-2 mx-auto mt-3">
            <h5 className="text-uppercase mb-4 font-weight-bold text-info">
              Have a Questions?
            </h5>
            <p>
              {/* <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  className="bi bi-geo-alt"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M12.166 8.94c-.524 1.062-1.234 2.12-1.96 3.07A31.493 31.493 0 0 1 8 14.58a31.481 31.481 0 0 1-2.206-2.57c-.726-.95-1.436-2.008-1.96-3.07C3.304 7.867 3 6.862 3 6a5 5 0 0 1 10 0c0 .862-.305 1.867-.834 2.94M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10"
                  />
                  <path
                    d="M8 8a2 2 0 1 1 0-4 2 2 0 0 1 0 4m0 1a3 3 0 1 0 0-6 3 3 0 0 0 0 6"
                  />
                </svg> */}
              <Link to="#" className="text-dark" style={{ textdecoration: "none" }}>
                Sunbeam Farm Innovations, Phase-II, Hinjewadi
              </Link>
            </p>
            <p>
              {/* <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  className="bi bi-telephone"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z"
                  />
                </svg> */}
              <Link to="#" className="text-dark" style={{ textdecoration: "none" }}>
                +91-1234567890
              </Link>
            </p>
            <p>
              {/* <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  className="bi bi-envelope"
                  viewBox="0 0 16 16"
                >
                  <path
                    d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"
                  />
                </svg> */}
              <Link to="#" className="text-dark" style={{ textdecoration: "none" }}>
                sunbeam@gmail.com
              </Link>
            </p>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;