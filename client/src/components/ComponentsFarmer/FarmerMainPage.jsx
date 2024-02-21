import * as React from "react";
import { Link, useHistory } from "react-router-dom/cjs/react-router-dom.min";
import logo from "../../logo.png";
import "../ComponentsSeller/SellerProfile.css";
import FarmerProfile from "./FarmerProfile/FarmerProfile";
import FarmerDashboard from "./Dashboard";
import FarmerProductList from "./FarmerProducts";
import AddFarmProduct from "./AddProduct";
import FarmerOrderList from "./FarmerOrderList";
import RentMachine from "./RentMachine";


const FarmerMainPage = () => {
  const history = useHistory();

  const [userId, setUserId] = React.useState();
  React.useEffect(() => {
    if (sessionStorage.getItem("userId")) {
      setUserId(sessionStorage.getItem("userId"));
    } else if (localStorage.getItem("userId")) {
      setUserId(localStorage.getItem("userId"));
    }
  }, []);

  const [menu, setMenu] = React.useState({
    profile: true,
    dashboard: false,
    products: false,
    orders: false,
    addProduct: false,
    rentMachine : false
  });
  const toggleMenu = (key) => {
    setMenu((prevMenu) => ({
      ...Object.fromEntries(
        Object.entries(prevMenu).map(([k, v]) => [k, k === key])
      ),
    }));
  };
  // const [dashboard, setDashboard] = React.useState(false);

  // Loggin out user and clearing the storages
  function logoutUser() {
    localStorage.clear();
    sessionStorage.clear();
    history.replace("/");
  }

  return (
    <>
      <section className="container-fluid">
        <div className="d-flex" id="wrapper">
          <div className="bg-white" id="sidebar-wrapper">
            <div id="sidebar">
              <div className="sidebar-heading text-center py-4 border-bottom">
                <Link
                  to="/"
                  className="primary-text fs-4 fw-bold text-uppercase"
                >
                  <img src={logo} alt="cropify logo" width="40" height="40" />{" "}
                  Cropify
                </Link>
              </div>
              <div className="text-start list-group list-group-flush my-3">
                <div
                  onClick={() => toggleMenu("profile")}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-user me-2"></i>My Profile
                </div>
                <div
                  onClick={() => toggleMenu("dashboard")}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-tachometer-alt me-2"></i>Dashboard
                </div>
                <div
                  onClick={() => toggleMenu("products")}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-tractor me-2"></i>My Products
                </div>
                <div
                  onClick={() => toggleMenu("orders")}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-chart-line me-2"></i>Order List
                </div>
                <div
                  onClick={() => toggleMenu("addProduct")}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-plus me-2"></i>Add New Product
                </div>
                <div
                  onClick={() => toggleMenu("rentMachine")}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-tractor me-2"></i>Rent Machine
                </div>

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

          {menu.profile && <FarmerProfile userId={userId} />}
          {menu.dashboard && <FarmerDashboard userId={userId} />}
          {menu.products && <FarmerProductList userId={userId} />}
          {menu.orders && <FarmerOrderList userId={userId} />}
          {menu.addProduct && <AddFarmProduct userId={userId} />}
          {menu.rentMachine && <RentMachine userId={userId} />}
        </div>
      </section>
    </>
  );
};

export default FarmerMainPage;
