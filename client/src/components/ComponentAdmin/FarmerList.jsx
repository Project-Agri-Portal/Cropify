// ProductList.js
import React from 'react';
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Header from './Header'
import Sidebar from './SideBar';
import Product from "../../services/user.service"
import { useEffect } from 'react';
import "./MainLayout.css";
import { useState } from 'react';
import { TableContainer, Table, TableHead, TableBody, TableRow, TableCell, Paper} from '@mui/material';
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import SendIcon from '@mui/icons-material/Send';
import Stack from '@mui/material/Stack';

const FarmerList = () => {

  const [openSidebarToggle, setOpenSidebarToggle] = useState(false)
  const [productList, setProductList] = useState([]);

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle)
  }

  const onload = async () => {
    await Product.getFarmerList('Farmer')
                      .then((result) => {
                        setProductList(result['data'])
                        console.log(result['data']);
                      })
                      .catch((error)=> {
                        console.log(error);
                      })
  }

  useEffect(() => {
    onload();
    console.log("use");
  }, [])

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
        <TableCell className='text-center'>Farmer Id</TableCell>
        <TableCell className='text-center'>Farmer Name</TableCell>
        <TableCell className='text-center'>Email</TableCell>
        <TableCell className='text-center'>Mobile No</TableCell>
        <TableCell className='text-center'>Status</TableCell>
        <TableCell className='text-center'>Block</TableCell>
      </TableRow>
    </TableHead>
    <TableBody>

      {productList.map((product) => {
          return (
            <TableRow key={1} sx={{'&:last-child td, &:last-child th' : {border : 0}}}>
          <TableCell className='text-center'>{product['id']}</TableCell>
          <TableCell className='text-center'>{product['firstName']}</TableCell>
          <TableCell className='text-center'>{product['email']}</TableCell>
          <TableCell className='text-center'>{product['mobileNo']}</TableCell>
          <TableCell className='text-center'>{product['status']}</TableCell>
          <TableCell className='text-center'>
          <Stack direction="row" spacing={2} className='center d-flex justify-content-center btn-danger'>
            <Button variant="outlined" startIcon={<DeleteIcon />} style={{borderColor:'red', color:'red'}}>
              Block Farmer
            </Button>
          </Stack>
          </TableCell>
        </TableRow>
          );
      })};

    </TableBody>
    </Table>
  </TableContainer>
  </main>
  </div>
  );
};

export default FarmerList;
