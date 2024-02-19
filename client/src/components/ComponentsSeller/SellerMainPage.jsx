import * as React from "react";
import { Link, useHistory } from "react-router-dom/cjs/react-router-dom.min";
import logo from "../../logo.png";
// import SellerSidebar from "./sidebar";
import "./SellerProfile.css";
import SellerProfile from "./SellerProfile";
import Seller from "./Dashboard";
import MachineList from "./SellerProducts";
import OrderList from "./SellerOrderList";
import AddMachine from "./AddMachine";

const SellerMainPage = () => {
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
    machines: false,
    orders: false,
    addMachine: false
  });
  const toggleMenu = (key) => {
    setMenu((prevMenu) => ({
      ...Object.fromEntries(Object.entries(prevMenu).map(([k, v]) => [k, k === key]))
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
                  onClick={() => toggleMenu('profile')}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-user me-2"></i>My Profile
                </div>
                <div
                  onClick={() => toggleMenu('dashboard')}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-tachometer-alt me-2"></i>Dashboard
                </div>
                <div
                  onClick={() => toggleMenu('machines')}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-tractor me-2"></i>My Machines
                </div>
                <div
                  onClick={() => toggleMenu('orders')}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-chart-line me-2"></i>Order List
                </div>
                <div
                  onClick={() => toggleMenu('addMachine')}
                  style={{ cursor: "pointer" }}
                  className="list-group-item list-group-item-action bg-transparent second-text fw-bold"
                >
                  <i className="fas fa-plus me-2"></i>Add New Machine
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
          
          {menu.profile && <SellerProfile userId={userId} />}
          {menu.dashboard && <Seller userId={userId} />}
          {menu.machines && <MachineList userId={userId} /> }
          {menu.orders && <OrderList userId={userId} />}
          {menu.addMachine && <AddMachine userId={userId} />}
        </div>
      </section>
    </>
  );
};

export default SellerMainPage;
