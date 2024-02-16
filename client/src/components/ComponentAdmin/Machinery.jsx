// ProductList.js
import React from 'react';
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Header from './Header'
import Sidebar from './SideBar'
import "./MainLayout.css";
import { useState } from 'react';
import { TableContainer, Table, TableHead, TableBody, TableRow, TableCell, Paper} from '@mui/material';
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import SendIcon from '@mui/icons-material/Send';
import Stack from '@mui/material/Stack';

const Machinery = () => {

  const [openSidebarToggle, setOpenSidebarToggle] = useState(false)

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle)
  }

  return (

    <div className='grid-container'>
        <Header OpenSidebar={OpenSidebar}/>
        <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar}/>
        {/* <Home /> */}
        {/* <ProductList></ProductList> */}
        <main className='main-container'>
      <TableContainer component={Paper} sx={{ maxWidth: '100%' }}>
        <Table aria-lable = 'smple table' sx={{ width: '100%' }}>
        <TableHead>
          <TableRow>
            <TableCell>Id</TableCell>
            <TableCell>First Name</TableCell>
            <TableCell>Last Name</TableCell>
            <TableCell>Email</TableCell>
            <TableCell>Delete</TableCell>
            <TableCell>Edit</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          <TableRow key={1} sx={{'&:last-child td, &:last-child th' : {border : 0}}}>
            <TableCell>1</TableCell>
            <TableCell>abc</TableCell>
            <TableCell>abc</TableCell>
            <TableCell>abc@gmail.com</TableCell>
            <TableCell>
            <Stack direction="row" spacing={2}>
      <Button variant="outlined" startIcon={<DeleteIcon />}>
        Delete
      </Button>
    </Stack>
            </TableCell>
            <TableCell>
            <Button variant="contained" endIcon={<SendIcon />}>
                Edit
            </Button>
            </TableCell>
          </TableRow>
        </TableBody>
        </Table>
      </TableContainer>
      </main>
      </div>
  );
};

export default Machinery;
