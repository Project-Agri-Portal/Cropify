import React from 'react'
import 
{BsCart3, BsGrid1X2Fill, BsFillArchiveFill, BsFillGrid3X3GapFill, BsPeopleFill, 
  BsListCheck, BsMenuButtonWideFill, BsFillGearFill}
 from 'react-icons/bs'
import "./MainLayout.css";
import { Link } from 'react-router-dom/cjs/react-router-dom.min';

function SideBar({openSidebarToggle, OpenSidebar}) {
  return (
    <aside id="sidebar" className={openSidebarToggle ? "sidebar-responsive": ""}>
        <div className='sidebar-title'>
            <div className='sidebar-brand'>
                <BsCart3  className='icon_header'/> Cropify
            </div>
            <span className='icon close_icon' onClick={OpenSidebar}>X</span>
        </div>

        <ul className='sidebar-list'>
            <li className='sidebar-list-item'>
            <BsGrid1X2Fill className='icon'/> 
                <Link to={"/admin"}>
                Dashboard
                </Link>
            </li>
            <li className='sidebar-list-item'>
            <BsFillArchiveFill className='icon'/>
                <Link to="/admin/product">
                Machinery
                </Link>
            </li>
            <li className='sidebar-list-item'>
            <BsFillArchiveFill className='icon'/>
                <Link to="/admin/machinery">
                 Farm Product
                </Link>
            </li>
            <li className='sidebar-list-item'>
            <BsFillArchiveFill className='icon'/>
                <Link to="/admin/agriproduct">
                 Agriculture Product
                </Link>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                    <BsFillGrid3X3GapFill className='icon'/> Seller
                </a>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                    <BsPeopleFill className='icon'/> Customers
                </a>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                    <BsListCheck className='icon'/> Admins
                </a>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                    <BsFillGearFill className='icon'/> Setting
                </a>
            </li>
            <li className='sidebar-list-item'>
                <a href="">
                <BsListCheck className='icon'/> Log Out
                </a>
            </li>
        </ul>
    </aside>
  )
}

export default SideBar
