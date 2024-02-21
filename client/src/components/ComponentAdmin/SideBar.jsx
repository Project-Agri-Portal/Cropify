import React from "react";
import {
  BsCart3,
  BsGrid1X2Fill,
  BsFillArchiveFill,
  BsFillGrid3X3GapFill,
  BsPeopleFill,
  BsListCheck,
  BsBoxArrowLeft,
  BsMenuButtonWideFill,
  BsFillGearFill,
} from "react-icons/bs";
import "./MainLayout.css";
import logo from "../../logo.png";
import { Link, useHistory } from "react-router-dom/cjs/react-router-dom.min";

function SideBar({ openSidebarToggle, OpenSidebar }) {
  const history = useHistory();
  const handleLogout = () => {
    history.replace("/");
  };

  return (
    <aside
      id="sidebar"
      className={openSidebarToggle ? "sidebar-responsive" : ""}
    >
      <div className="sidebar-title">
        <div className="sidebar-brand">
          <img src={logo} alt="cropify logo" width={40} /> Cropify
        </div>
        <span className="icon close_icon" onClick={OpenSidebar}>
          X
        </span>
      </div>

      <ul className="text-start sidebar-list">
        <li className="sidebar-list-item">
          <BsGrid1X2Fill className="icon" />
          <Link to={"/admin"}>Dashboard</Link>
        </li>
        <li className="sidebar-list-item">
          <BsFillArchiveFill className="icon" />
          <Link to="/admin/product">Farm Products</Link>
        </li>
        <li className="sidebar-list-item">
          <BsFillArchiveFill className="icon" />
          <Link to="/admin/machinery">Machinery</Link>
        </li>
        <li className="sidebar-list-item">
          <BsFillArchiveFill className="icon" />
          <Link to="/admin/agriproduct">Agriculture Product</Link>
        </li>
        <li className="sidebar-list-item">
          <BsFillGrid3X3GapFill className="icon" />
          <Link to="/admin/seller">Seller</Link>
        </li>
        <li className="sidebar-list-item">
          <BsPeopleFill className="icon" />
          <Link to="/admin/farmer">Farmer</Link>
        </li>
        <li className="sidebar-list-item">
          <BsListCheck className="icon" />
          <Link to="/admin/addproduct">Add Product</Link>
        </li>
        <li
          className="sidebar-list-item"
          onClick={() => {
            handleLogout();
          }}
        >
          <BsBoxArrowLeft className="icon" />
          <Link to="/admin/addproduct">Log Out</Link>
        </li>
      </ul>
    </aside>
  );
}

export default SideBar;
