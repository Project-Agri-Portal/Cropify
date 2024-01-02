import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "./Seller.css";

function Seller() {
  return (
    <>
      <div className="d-flex" id="wrapper">
        {/* <!-- Sidebar --> */}

        <div className="bg-white" id="sidebar-wrapper">
          <div className="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
            {" "}
            Cropify
          </div>
          <div className="list-group list-group-flush my-3">
            <a
              href="#"
              className="list-group-item list-group-item-action bg-transparent second-text active"
            >
              <i className="fas fa-tachometer-alt me-2"></i>Dashboard
            </a>
            <a
              href="/seller/productlist"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-project-diagram me-2"></i>Products
            </a>
            <a
              href="/seller/orderlist"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-chart-line me-2"></i>Order List
            </a>
            <a
              href="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-paperclip me-2"></i>Available Stock
            </a>
            <a
              href="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-shopping-cart me-2"></i>Store Mng
            </a>
            <a
              href="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-gift me-2"></i>Products
            </a>
            <a
              href="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-comment-dots me-2"></i>Chat
            </a>
            <a
              href="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-map-marker-alt me-2"></i>Outlet
            </a>
            <a
              href="#"
              className="list-group-item list-group-item-action bg-transparent text-danger fw-bold"
            >
              <i className="fas fa-power-off me-2"></i>Logout
            </a>
          </div>
        </div>
        {/* <!-- /#sidebar-wrapper --> */}

        {/* ------------------------------------------------------------------------------------------------------- */}

        {/* <!-- Nav Bar --> */}
        <div id="page-content-wrapper">
          <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
            <div className="d-flex align-items-center">
              <i
                className="fas fa-align-left primary-text fs-4 me-3"
                id="menu-toggle"
              ></i>
              <h2 className="fs-2 m-0">Dashboard</h2>
            </div>

            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>

            <div
              className="collapse navbar-collapse"
              id="navbarSupportedContent"
            >
              <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
                <li className="nav-item dropdown">
                  <a
                    className="nav-link dropdown-toggle second-text fw-bold"
                    href="#"
                    id="navbarDropdown"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                    style={{ color: "rgb(11, 11, 10)" }}
                  >
                    <i className="fas fa-user me-2"></i>Seller Name
                  </a>
                  <ul
                    className="dropdown-menu"
                    aria-labelledby="navbarDropdown"
                  >
                    <li>
                      <a className="dropdown-item" href="/seller/profile">
                        My Profile
                      </a>
                    </li>
                    <li>
                      <a className="dropdown-item" href="#">
                        Settings
                      </a>
                    </li>
                    <li>
                      <a className="dropdown-item" href="#">
                        Logout
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </nav>
          {/* ----------------------------------------------------------------------------------------------------- */}

          {/* <!-- Nav Bar --> */}

          <div className="container-fluid px-4">
            <div className="row g-3 my-2">
              <div className="col-md-3">
                <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                  <div>
                    <h3 className="fs-2">10</h3>
                    <p className="fs-5">My Selling Products</p>
                  </div>
                  <i className="fas fa-gift fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                </div>
              </div>
              <div className="col-md-3">
                <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                  <div>
                    <h3 className="fs-2">492000</h3>
                    <p className="fs-5">Sales</p>
                  </div>
                  <i className="fas fa-hand-holding-usd fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                </div>
              </div>
              <div className="col-md-3">
                <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                  <div>
                    <h3 className="fs-2">3899</h3>
                    <p className="fs-5">Delivery</p>
                  </div>
                  <i className="fas fa-truck fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                </div>
              </div>
              <div className="col-md-3">
                <div className="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                  <div>
                    <h3 className="fs-2">%25</h3>
                    <p className="fs-5">Increase</p>
                  </div>
                  <i className="fas fa-chart-line fs-1 primary-text border rounded-full secondary-bg p-3"></i>
                </div>
              </div>
            </div>

            {/* ---------------------------------------------------------------------------------------------------------- */}

            {/* Dashboard Table */}

            <div className="row my-5" style={{ opacity: "0.7" }}>
              <h3 className="fs-4 mb-3 " style={{ color: "black" }}>
                Recent Orders
              </h3>
              <div className="col">
                <table className="table bg-white rounded shadow-sm  table-hover">
                  <thead>
                    <tr>
                      <th scope="col" width="50">
                        #
                      </th>
                      <th scope="col">Product</th>
                      <th scope="col">Customer</th>
                      <th scope="col">City</th>
                      <th scope="col">Quantity(in kgs)</th>
                      <th scope="col">Price per kg</th>
                      <th scope="col"> Total Price</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row">1</th>
                      <td>Rice</td>
                      <td>Kash</td>
                      <td>Banglore</td>
                      <td>5</td>
                      <td>40 Rs.</td>
                      <td>200 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">2</th>
                      <td>Wheat</td>
                      <td>Harish</td>
                      <td>Pune</td>
                      <td>20</td>
                      <td>27 Rs.</td>
                      <td>540 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">3</th>
                      <td>Bajra</td>
                      <td>Kash</td>
                      <td>Banglore</td>
                      <td>5</td>
                      <td>40 Rs.</td>
                      <td>200 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">4</th>
                      <td>Wheat</td>
                      <td>Harish</td>
                      <td>Pune</td>
                      <td>10</td>
                      <td>27 Rs.</td>
                      <td>270 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">5</th>
                      <td>Rice</td>
                      <td>Kash</td>
                      <td>Banglore</td>
                      <td>5</td>
                      <td>40 Rs.</td>
                      <td>200 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">6</th>
                      <td>Jawar</td>
                      <td>Amol</td>
                      <td>Nagpur</td>
                      <td>10</td>
                      <td>37 Rs.</td>
                      <td>370 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">7</th>
                      <td>Rice</td>
                      <td>Kash</td>
                      <td>Banglore</td>
                      <td>5</td>
                      <td>40 Rs.</td>
                      <td>200 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">8</th>
                      <td>Wheat</td>
                      <td>Harish</td>
                      <td>Pune</td>
                      <td>5</td>
                      <td>27 Rs.</td>
                      <td>135 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">9</th>
                      <td>Wheat</td>
                      <td>Harish</td>
                      <td>Pune</td>
                      <td>5</td>
                      <td>27 Rs.</td>
                      <td>135 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">10</th>
                      <td>Rice</td>
                      <td>Kash</td>
                      <td>Banglore</td>
                      <td>5</td>
                      <td>40 Rs.</td>
                      <td>200 Rs.</td>
                    </tr>
                    <tr>
                      <th scope="row">11</th>
                      <td>Wheat</td>
                      <td>Harish</td>
                      <td>Pune</td>
                      <td>5</td>
                      <td>27 Rs.</td>
                      <td>135 Rs.</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>

            {/* Dashboard Table */}
          </div>
        </div>
      </div>
      {/* <!-- /#page-content-wrapper --> */}
    </>
  );
}

export default Seller;
