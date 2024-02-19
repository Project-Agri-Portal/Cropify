// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { Link,useHistory } from "react-router-dom/cjs/react-router-dom.min";
import "./SellerProducts.css";
import Machines from '../../services/seller.service';
import { useState } from "react";
import { useEffect } from "react";

function ProductList() {

  const history = useHistory();

  // Loggin out user and clearing the storages
  function logoutUser() {
    localStorage.clear();
    sessionStorage.clear();
    history.replace("/");
  }

const [machineList,setMachineList] = useState([]);
const [quantityList, setQuantityList] = useState({});


const onload = () =>{
    Machines.getAllMachinery().then((result) => {
        setMachineList(result.data);
        console.log(result);
    }).catch((error) => {
        console.log(error);
        
    })
}
 
const increase = (machineId) =>{
  setQuantityList((prevQuantityList) => ({
    ...prevQuantityList,
    [machineId]: (prevQuantityList[machineId] || 0) + 1,
  }));
}

const decrease = (machineId) =>{
  if (quantityList[machineId] > 0) {
    setQuantityList((prevQuantityList) => ({
      ...prevQuantityList,
      [machineId]: prevQuantityList[machineId] - 1,
    }));
  }
}


  useEffect(() => {
    
    onload();
  },[])

  return (
    <>
      <div className="d-flex" id="wrapper">

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
              <i className="fas fa-project-diagram me-2"></i> My Machines
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
           
            <p
              
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
            <div className="row align-item-left">
              <div className="col-md-6 ">
                <div className="mb-3">
                  <h5 className="card-title" style={{color:"black"}}>
                    Add Machinery
                  </h5>
                </div>
              </div>
              <div className="col-md-6">
                <div className="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3">
                  
                </div>
              </div>
            </div>
            <div className="row">
              <div className="col-lg-12">
                <div className="">
                  <div className="table-responsive">
                    <table className="table project-list-table table-nowrap align-middle table-borderless table-striped">
                      <thead>
                        <tr>
                          <th scope="col">Machine ID</th>
                          <th scope="col">Machine Name</th>
                          <th scope="col">Machine Type</th>
                          {/* <th scope="col">Available Quantity</th> */}
                          {/* <th scope="col">Machine Price</th> */}
                          {/* <th scope="col">Machine Description</th> */}
                          <th scope="col" style={{ width: "200px;" }}>
                            Action
                          </th>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>

                        {machineList.map((prod) => {
                          const machineId = prod['machineId'];
                          const quantity = quantityList[machineId] || 0;
                          return (
                            <tr>
                          <td>{prod['machineId']}</td>
                          <td>
                            <span>{prod['machineName']}</span>
                          </td>
                          <td>{prod['machineType']}</td>
                          
                          <td>
                            
                               <button className="btn btn-outline-primary" onClick={() => {increase(machineId)}}>+</button>
                                   {" "} {quantity}{" "}
                               <button className="btn btn-outline-primary" onClick={() => {decrease(machineId)}}>-</button>
       
                          </td>
                          <td>
                              <button className="btn btn-primary">Add</button>
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
