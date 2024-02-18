// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Link } from "react-router-dom/cjs/react-router-dom.min";
import "./SellerProducts.css";
import SellerProducts from '../../services/seller.service';
import { useState } from "react";
import { useEffect } from "react";

function ProductList() {

  const [productList,setProductList] = useState([]);

    const onload = (userId) => {
    SellerProducts.getSellerMachinery(userId).then((result) => {
      setProductList(result.data);
      console.log(result);
    }).catch((error) => {
      console.log(error);
    })
  }

  const deleteProduct = (id) => {
    SellerProducts.deleteSellerMachine(id).then((result)=>{
      console.log(result);
      const userId= localStorage.getItem('userId');
      onload(userId);
    }).catch((error)=>{
      console.log(error);
    })
  }


  useEffect(() => {
    const userId= localStorage.getItem('userId');
    onload(userId);
  },[])

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
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-tachometer-alt me-2"></i>Dashboard
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text active"
            >
              <i className="fas fa-project-diagram me-2"></i>Products
            </Link>
            <Link
              to="/seller/orderlist"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-chart-line me-2"></i>Order List
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-paperclip me-2"></i>Available Stock
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-shopping-cart me-2"></i>Store Mng
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-gift me-2"></i>Products
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-comment-dots me-2"></i>Chat
            </Link>
            <Link
              to="#"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-map-marker-alt me-2"></i>Outlet
            </Link>
            <Link
              to="/"
              className="list-group-item list-group-item1 list-group-item-action bg-transparent text-danger fw-bold"
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
              <i className="fas fa-project-diagram me-2"></i>
              <h2 className="fs-2 m-0">Products</h2>
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

          {/* <!-- Product List Here--> */}
          <link
            rel="stylesheet"
            to="SellerProducts.css"
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
          />
          <link
            rel="stylesheet"
            to="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css"
            integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc="
            crossorigin="anonymous"
          />

          <div className="container">
            <div className="row align-items-center">
              <div className="col-md-6">
                <div className="mb-3">
                  <h5 className="card-title">
                    My Products To Sell
                    <span className="text-muted fw-normal ms-2">(10)</span>
                  </h5>
                </div>
              </div>
              <div className="col-md-6">
                <div className="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3">
                  <div>
                    <ul className="nav nav-pills">
                      <li className="nav-item">
                        <Link
                          aria-current="page"
                          to="#"
                          className="router-link-active router-link-exact-active nav-link active"
                          data-bs-toggle="tooltip"
                          data-bs-placement="top"
                          title=""
                          data-bs-original-title="List"
                          aria-label="List"
                        >
                          <i className="bx bx-list-ul"></i>
                        </Link>
                      </li>
                      <li className="nav-item">
                        <Link
                          to="#"
                          className="nav-link"
                          data-bs-toggle="tooltip"
                          data-bs-placement="top"
                          title=""
                          data-bs-original-title="Grid"
                          aria-label="Grid"
                        >
                          <i className="bx bx-grid-alt"></i>
                        </Link>
                      </li>
                    </ul>
                  </div>
                  <div>
                    <Link
                      to="#"
                      data-bs-toggle="modal"
                      data-bs-target=".add-new"
                      className="btn btn-primary"
                    >
                      <i className="bx bx-plus me-1"></i> Add New Products
                    </Link>
                  </div>
                  {/* <div className="dropdown">
                    <Link
                      className="btn btn-link text-muted py-1 font-size-16 shadow-none dropdown-toggle"
                      to="#"
                      role="button"
                      data-bs-toggle="dropdown"
                      aria-expanded="false"
                    >
                      <i className="bx bx-dots-horizontal-rounded"></i>
                    </Link>
                    <ul className="dropdown-menu dropdown-menu-end">
                      <li>
                        <Link className="dropdown-item" to="SellerProfile.html">
                          Go To Profile
                        </Link>
                      </li>
                      <li>
                        <Link className="dropdown-item" to="#">
                          Settings
                        </Link>
                      </li>
                      <li>
                        <Link className="dropdown-item" to="#">
                          Log Out
                        </Link>
                      </li>
                    </ul>
                  </div> */}
                </div>
              </div>
            </div>
            <div className="row">
              <div className="col-lg-12">
                <div className="">
                  <div className="table-responsive">
                    <table className="table project-list-table table-nowrap align-middle table-borderless">
                      <thead>
                        <tr>
                          <th scope="col">Machine ID</th>
                          <th scope="col">Machine Name</th>
                          <th scope="col">Total Quantity</th>
                          <th scope="col">Available Quantity</th>
                          <th scope="col">Machine Price</th>
                          <th scope="col">Machine Description</th>
                          <th scope="col" style={{ width: "200px;" }}>
                            Action
                          </th>
                        </tr>
                      </thead>
                      <tbody>

                        {productList.map((prod) => {
                          return (
                            <tr>
                          <td>{prod['machineId']}</td>
                          <td>
                            <span>{prod['machineName']}</span>
                          </td>
                          <td>{prod['quantity']}</td>
                          <td>{prod['availQuantity']}</td>
                          <td>{prod['price']}</td>
                          <td>{prod['description']}</td>
                          <td>
                            <ul className="list-inline mb-0">
                              <li className="list-inline-item">
                                <Link
                                  to=""
                                  data-bs-toggle="tooltip"
                                  data-bs-placement="top"
                                  title="Edit"
                                  className="px-2 text-primary"
                                >
                                  <i className="bx bx-pencil font-size-18"></i>
                                </Link>
                              </li>
                              <li className="list-inline-item">
                                <Link
                                  to="/seller/productlist"
                                  data-bs-toggle="tooltip"
                                  data-bs-placement="top"
                                  title="Delete"
                                  className="px-2 text-danger"
                                >
                                  <i className="bx bx-trash-alt font-size-18" onClick={() => { deleteProduct(prod['sellerMachineDetailsId'])}}></i>
                                </Link>
                              </li>
                            </ul>
                          </td>
                        </tr>
                          );
                        })}

                        


                      </tbody>
                    </table>
                  </div>


                </div>
              </div>
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
                    <li className="page-item disabled">
                      <Link to="#" className="page-link">
                        <i className="mdi mdi-chevron-left"></i>
                      </Link>
                    </li>
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
                    {/* <!-- <li className="page-item"><Link to="#" className="page-link">3</Link></li>
                                <li className="page-item"><Link to="#" className="page-link">4</Link></li>
                                <li className="page-item"><Link to="#" className="page-link">5</Link></li> --> */}
                    <li className="page-item">
                      <Link to="#" className="page-link">
                        <i className="mdi mdi-chevron-right"></i>
                      </Link>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>

          {/* <!-- Product List Here--> */}
        </div>

        {/* </div> */}
        {/* <!-- /#page-content-wrapper --> */}
      </div>
    </>
  );
}
export default ProductList;
