import React, { useState } from 'react';
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import "./Welcome.css"
import UserProfile from './UserProfile';

const Welcome = () => {
    return(
      <>
      <div style={{height:"50px"}}></div>
        <section className="welcome text-center pb-5">
        <div className="container py-5">
          <div className="row py-5 text-white">
            <div className="col-lg-6 m-auto">
              <p className="m-0">Green Agriculture</p>
              <h1>Welcome to Organic</h1>
              <div className="line2 my-4"></div>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Voluptatum non deserunt excepturi pariatur sequi inventore
                facere harum laboriosam? Quas animi blanditiis nesciunt cum.
                Fuga velit corporis ex, nihil fugit deserunt non quo culpa
                saepe! Minima.
              </p>
            </div>
          </div>

          <div className="row">
            <div className="col-lg-4 rotate-scale-up">
              <div className="card py-3" id='welcomeid'>
                <div className="card-body">
                  <span
                    ><svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      className="bi bi-shop-window icon"
                      id='welcomeimgid'
                      viewBox="0 0 16 16"
                    >
                      <path
                        d="M2.97 1.35A1 1 0 0 1 3.73 1h8.54a1 1 0 0 1 .76.35l2.609 3.044A1.5 1.5 0 0 1 16 5.37v.255a2.375 2.375 0 0 1-4.25 1.458A2.371 2.371 0 0 1 9.875 8 2.37 2.37 0 0 1 8 7.083 2.37 2.37 0 0 1 6.125 8a2.37 2.37 0 0 1-1.875-.917A2.375 2.375 0 0 1 0 5.625V5.37a1.5 1.5 0 0 1 .361-.976l2.61-3.045zm1.78 4.275a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0 1.375 1.375 0 1 0 2.75 0V5.37a.5.5 0 0 0-.12-.325L12.27 2H3.73L1.12 5.045A.5.5 0 0 0 1 5.37v.255a1.375 1.375 0 0 0 2.75 0 .5.5 0 0 1 1 0M1.5 8.5A.5.5 0 0 1 2 9v6h12V9a.5.5 0 0 1 1 0v6h.5a.5.5 0 0 1 0 1H.5a.5.5 0 0 1 0-1H1V9a.5.5 0 0 1 .5-.5m2 .5a.5.5 0 0 1 .5.5V13h8V9.5a.5.5 0 0 1 1 0V13a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V9.5a.5.5 0 0 1 .5-.5"
                      />
                    </svg>
                  </span>
                  <h2>Always fresh</h2>
                  <p>Lorem ipsum dolor sit.</p>
                </div>
              </div>
            </div>

            <div className="col-lg-4 rotate-scale-up">
              <div className="card py-3" id='welcomeid'>
                <div className="card-body">
                  <span>
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      className="bi bi-flower2 icon"
                      id='welcomeimgid'
                      viewBox="0 0 16 16"
                    >
                      <path
                        d="M8 16a4 4 0 0 0 4-4 4 4 0 0 0 0-8 4 4 0 0 0-8 0 4 4 0 1 0 0 8 4 4 0 0 0 4 4m3-12c0 .073-.01.155-.03.247-.544.241-1.091.638-1.598 1.084A2.987 2.987 0 0 0 8 5c-.494 0-.96.12-1.372.331-.507-.446-1.054-.843-1.597-1.084A1.117 1.117 0 0 1 5 4a3 3 0 0 1 6 0m-.812 6.052A2.99 2.99 0 0 0 11 8a2.99 2.99 0 0 0-.812-2.052c.215-.18.432-.346.647-.487C11.34 5.131 11.732 5 12 5a3 3 0 1 1 0 6c-.268 0-.66-.13-1.165-.461a6.833 6.833 0 0 1-.647-.487m-3.56.617a3.001 3.001 0 0 0 2.744 0c.507.446 1.054.842 1.598 1.084.02.091.03.174.03.247a3 3 0 1 1-6 0c0-.073.01-.155.03-.247.544-.242 1.091-.638 1.598-1.084m-.816-4.721A2.99 2.99 0 0 0 5 8c0 .794.308 1.516.812 2.052a6.83 6.83 0 0 1-.647.487C4.66 10.869 4.268 11 4 11a3 3 0 0 1 0-6c.268 0 .66.13 1.165.461.215.141.432.306.647.487M8 9a1 1 0 1 1 0-2 1 1 0 0 1 0 2"
                      />
                    </svg>
                  </span>
                  <h2>Always fresh</h2>
                  <p>Lorem ipsum dolor sit.</p>
                </div>
              </div>
            </div>

            <div className="col-lg-4 rotate-scale-up">
              <div className="card py-3" id='welcomeid'>
                <div className="card-body">
                  <span>
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      className="bi bi-gift icon"
                      id='welcomeimgid'
                      viewBox="0 0 16 16"
                    >
                      <path
                        d="M3 2.5a2.5 2.5 0 0 1 5 0 2.5 2.5 0 0 1 5 0v.006c0 .07 0 .27-.038.494H15a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a1.5 1.5 0 0 1-1.5 1.5h-11A1.5 1.5 0 0 1 1 14.5V7a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h2.038A2.968 2.968 0 0 1 3 2.506zm1.068.5H7v-.5a1.5 1.5 0 1 0-3 0c0 .085.002.274.045.43a.522.522 0 0 0 .023.07M9 3h2.932a.56.56 0 0 0 .023-.07c.043-.156.045-.345.045-.43a1.5 1.5 0 0 0-3 0zM1 4v2h6V4zm8 0v2h6V4zm5 3H9v8h4.5a.5.5 0 0 0 .5-.5zm-7 8V7H2v7.5a.5.5 0 0 0 .5.5z"
                      />
                    </svg>
                  </span>
                  <h2>Always fresh</h2>
                  <p>Lorem ipsum dolor sit.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      </>
    );
};

export default Welcome;