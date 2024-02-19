// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Link,useHistory} from "react-router-dom/cjs/react-router-dom.min";
import "./SellerOrderList.css";
import MachineryOrderList from '../../services/seller.service';
import { useState } from "react";
import { useEffect } from "react";

function OrderList() {

  const history = useHistory();

  // Loggin out user and clearing the storages
  function logoutUser() {
    localStorage.clear();
    sessionStorage.clear();
    history.replace("/");
  }


  const [orderList,setOrderList] = useState([]);

  const onload = (userId) =>{
    MachineryOrderList.getMachineryOrderList(userId).then((result) =>{
      setOrderList(result.data);
      console.log(result);
    }).catch((error) => {
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
        {/* -- Sidebar  */}
        {/* <div className="bg-white" id="sidebar-wrapper">
        <div id="sidebar">
          <div className="sidebar-heading text-center py-4 border-bottom">
            <Link to="/" className="primary-text fs-4 fw-bold text-uppercase">
              <i className="bx bxs-leaf"></i>
              {" "}
              Cropify
            </Link>
          </div>
          <div className="list-group list-group-fluzsh my-3">
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
              <i className="fas fa-power-off me-2"
            ></i>Logout
            </Link>
          </div>
          </div>
      </div> */}


<div className="bg-white" id="sidebar-wrapper">
          <div id="sidebar">
          <div className="sidebar-heading text-center py-4 border-bottom">
            <Link to="/" className="primary-text fs-4 fw-bold text-uppercase">
              <i className="bx bxs-leaf"></i> Cropify
            </Link>
          </div>
          <div className="list-group list-group-flush my-3">
            <Link
              to="/home/seller"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-tachometer-alt me-2"></i>Dashboard
            </Link>
            <Link
              to="/seller/productlist"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-project-diagram me-2"></i>Machines
            </Link>
            <Link
              to="/seller/orderlist"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-chart-line me-2"></i>Order List
            </Link>
            
            <Link
              to="/seller/addproduct"
              className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
            >
              <i className="fas fa-gift me-2"></i>Add New Machine
            </Link>
            {/* <Link
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
            </Link> */}
            <p
              // to="/"
              onClick={logoutUser}
              style={{ cursor: "pointer" }}
              className="list-group-item list-group-item-action bg-transparent text-danger fw-bold"
            >
              <i className="fas fa-power-off me-2"></i>Logout
            </p>
            </div>
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
              <h2 className="fs-2 m-0">Your Order List </h2>
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
                      <Link className="dropdown-item" to="#"
                      onClick={logoutUser}>
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
              <h5 className="fs-4 mb-3 " style={{ color: "black;" }}>
                Current Orders
              </h5>
              <div className="col" >
                <table className="table bg-white rounded shadow-sm  table-hover table-dark table-striped">
                  <thead>
                    <tr>
                      <th scope="col" width="50">
                      Order Id
                      </th>
                      <th scope="col">Machine Id</th>
                      <th scope="col">Farmer Id</th>
                      <th scope="col">Order Date</th>
                      <th scope="col">Delivery Date</th>
                      <th scope="col">Quantity</th>
                      <th scope="col">Duration</th>
                      <th scope="col"> Total Bill</th>
                      <th scope="col"> Status</th>
                    </tr>
                  </thead>
                  <tbody>
                    {orderList.map((orders) => {
                      return (
                        <tr>
                          <td>{orders['orderId']}</td>
                          <th scope="row">{orders['machineId']} </th>
                         <td>{orders['farmerId']}</td>
                         <td>{orders['orderDate']}</td>
                         <td>{orders['deliveryDate']}</td>
                         <td>{orders['quantity']}</td>
                         <td>{orders['rentDuration']}</td>  
                          <td>{orders['totalPrice']}</td>
                          <td>{orders['orderStatus']}</td>
                    </tr>
                      );
                    })}
                    
                    
                  </tbody>
                </table>
              </div>

              {/* <div className="row g-0 align-items-center pb-4">
                <div className="col-sm-6">
                  
                </div>
                <div className="col-sm-6">
                  <div className="float-sm-end">
                    <ul className="pagination mb-sm-0">
                      
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
                      
                    </ul>
                  </div>
                </div>
              </div> */}
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
