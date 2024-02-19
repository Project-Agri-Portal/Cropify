import React, { useState } from 'react';
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import carousalImage from "../../../assets/ShopImages/fruit.jpg"
// import carousalImage1 from "../../../assets/ShopImages/in"
import "./Carousal.css"

const Carousal = () => {
    return(
        <>
        <div style={{height:30}}></div>
        <div id="carouselExampleCaptions" className="carousel slide">
        <div className="carousel-indicators"></div>
        <div className="carousel-inner rounded-4">
          <div className="carousel-item active" id="carousalimg">
            {/* <!-- <img src="./Photos/grapes-3623694_1280.jpg" className="d-block w-100" alt="..."> --> */}
            <img src={carousalImage} className="img-fluid" alt="..." />
            <div className="carousel-caption d-none d-md-block">
              <h5>First slide label</h5>
              <p>
                Some representative placeholder content for the first slide.
              </p>
            </div>
          </div>
          <div className="carousel-item" id="carousalimg">
            <img src="" className="d-block w-100" alt="..." />
            <div className="carousel-caption d-none d-md-block">
              <h5>Second slide label</h5>
              <p>
                Some representative placeholder content for the second slide.
              </p>
            </div>
          </div>
          <div className="carousel-item" id="carousalimg">
            <img src="" className="d-block w-100" alt="..." />
            <div className="carousel-caption d-none d-md-block">
              <h5>Third slide label</h5>
              <p>
                Some representative placeholder content for the third slide.
              </p>
            </div>
          </div>
        </div>
      </div>
      </>
    );
};

export default Carousal;