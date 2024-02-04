// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import "./SellerOrderList.css";

function OrderList() {
  return (
    <>
      <div className="d-flex" id="wrapper">
        {/* <!-- Sidebar --> */}
        <div className="bg-white" id="sidebar-wrapper">
          <div className="sidebar-heading text-center py-4 border-bottom">
            <Link to="/" className="primary-text fs-4 fw-bold text-uppercase">
              <i className="bx bxs-leaf"></i>
              {" "}
              Cropify
            </Link>
          </div>
          <div className="list-group list-group-flush my-3">
            <Link
              to="/home/seller"
              className="list-group-item list-group-item-action bg-transparent second-text active"
            >
              <i className="fas fa-tachometer-alt me-2"></i>Dashboard
            </Link>
            <Link
              to="/seller/productlist"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-project-diagram me-2"></i>Products
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-chart-line me-2"></i>Order List
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-paperclip me-2"></i>Available Stock
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-shopping-cart me-2"></i>Store Mng
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-gift me-2"></i>Products
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-comment-dots me-2"></i>Chat
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-map-marker-alt me-2"></i>Outlet
            </Link>
            <Link
              to="/"
              className="list-group-item list-group-item-action bg-transparent text-danger fw-bold"
            >
              <i className="fas fa-power-off me-2"></i>Logout
            </Link>
          </div>
        </div>
        {/* <!-- /#sidebar-wrapper --> */}

        {/* <!-- Page Content --> */}
        <div id="page-content-wrapper">
          <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
            <div className="d-flex align-items-center">
              <i
                className="fas fa-align-left primary-text fs-4 me-3"
                id="menu-toggle"
              ></i>
              <h2 className="fs-2 m-0">Order List</h2>
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
                  <Link
                    className="nav-link dropdown-toggle second-text fw-bold"
                    to="#"
                    id="navbarDropdown"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                    style={{ color: "rgb(11, 11, 10)" }}
                  >
                    <i className="fas fa-user me-2"></i>Seller Name
                  </Link>
                  <ul
                    className="dropdown-menu"
                    aria-labelledby="navbarDropdown"
                  >
                    <li>
                      <Link className="dropdown-item" to="/seller/profile">
                        My Profile
                      </Link>
                    </li>
                    <li>
                      <Link className="dropdown-item" to="#">
                        Settings
                      </Link>
                    </li>
                    <li>
                      <Link className="dropdown-item" to="#">
                        Logout
                      </Link>
                    </li>
                  </ul>
                </li>
              </ul>
            </div>
          </nav>

          <div className="container-fluid px-4">
            <div className="row my-5" style={{ opacity: "0.7;" }}>
              <h3 className="fs-4 mb-3 " style={{ color: "black;" }}>
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
                      <th scope="row">8</th>
                      <td>Wheat</td>
                      <td>Harish</td>
                      <td>Pune</td>
                      <td>5</td>
                      <td>27 Rs.</td>
                      <td>135 Rs.</td>
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
                  </tbody>
                </table>
              </div>

              <div className="row g-0 align-items-center pb-4">
                <div className="col-sm-6">
                  <div>
                    <p className="mb-sm-0">Showing 1 of 2</p>
                  </div>
                </div>
                <div className="col-sm-6">
                  <div className="float-sm-end">
                    <ul className="pagination mb-sm-0">
                      {/* <!-- <li className="page-item disabled">
                                        <Link to="#" className="page-link"><i className="mdi mdi-chevron-left"></i></Link>
                                    </li> --> */}
                      <li className="page-item active">
                        <Link to="#" className="page-link">
                          1
                        </Link>
                      </li>
                      <li className="page-item">
                        <Link to="#" className="page-link">
                          2
                        </Link>
                      </li>
                      <li className="page-item">
                        <Link to="#" className="page-link">
                          3
                        </Link>
                      </li>
                      <li className="page-item">
                        <Link to="#" className="page-link">
                          4
                        </Link>
                      </li>
                      <li className="page-item">
                        <Link to="#" className="page-link">
                          5
                        </Link>
                      </li>
                      {/* <!-- <li className="page-item">
                                        <Link to="#" className="page-link"><i className="mdi mdi-chevron-right"></i></Link>
                                    </li> --> */}
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* </div> */}
          {/* </div> */}
        </div>
        {/* // <!-- /#page-content-wrapper --> */}
      </div>
    </>
  );
}
export default OrderList;