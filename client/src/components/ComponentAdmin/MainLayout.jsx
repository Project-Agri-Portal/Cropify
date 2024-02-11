import React from 'react'
import { useState } from 'react'
import Header from './Header'
import Sidebar from './SideBar'
import Home from './Home'
import "./MainLayout.css";

function MainLayout() {
    
    const [openSidebarToggle, setOpenSidebarToggle] = useState(false)

    const OpenSidebar = () => {
      setOpenSidebarToggle(!openSidebarToggle)
    }
  
    return (
      <div className='grid-container'>
        <Header OpenSidebar={OpenSidebar}/>
        <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar}/>
        <Home />
      </div>
    )
}

export default MainLayout
