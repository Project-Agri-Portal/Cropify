// ProductList.js
import React from 'react';
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Header from './Header'
import Sidebar from './SideBar'
import Product from "../../services/agriproduct.service"
import { ToastContainer, toast } from "react-toastify";
import { useEffect } from 'react';
import "./MainLayout.css";
import { useState } from 'react';
import { TableContainer, Table, TableHead, TableBody, TableRow, TableCell, Paper} from '@mui/material';
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import SendIcon from '@mui/icons-material/Send';
import Stack from '@mui/material/Stack';

const AgricultureProduct = () => {

  const [openSidebarToggle, setOpenSidebarToggle] = useState(false)
  const [productList, setProductList] = useState([]);

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle)
  }

  const onload = async () => {
    await Product.getAgriProducts()
                      .then((result) => {
                        setProductList(result['data'])
                        console.log(result['data']);
                      })
                      .catch((error)=> {
                        console.log(error);
                      })
  }

  const deleteProduct = (prodId) => {
    Product.deleteAgriProduct(prodId)
      .then((result) => {
        console.log(result["data"]);
        toast.success('Farm product delete')
        onload();
      })
      .catch((error) => {
        console.log(error);
      });
  };

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
        <TableCell className='text-center'>Product Id</TableCell>
        <TableCell className='text-center'>Product Name</TableCell>
        <TableCell className='text-center'>Product Type</TableCell>
        <TableCell className='text-center'>Delete Product</TableCell>
        <TableCell className='text-center'>Edit Product</TableCell>
      </TableRow>
    </TableHead>
    <TableBody>

      {productList.map((product) => {
          return (
            <TableRow key={1} sx={{'&:last-child td, &:last-child th' : {border : 0}}}>
          <TableCell className='text-center'>{product['agriProductId']}</TableCell>
          <TableCell className='text-center'>{product['agriProductName']}</TableCell>
          <TableCell className='text-center'>{product['agriProductType']}</TableCell>
          <TableCell className='text-center'>
          <Stack direction="row" spacing={2} className='center d-flex justify-content-center'>
            <Button variant="outlined" startIcon={<DeleteIcon />} onClick={() => {deleteProduct(product['agriProductId'])}}>
              Delete
            </Button>
          </Stack>
          </TableCell>
          <TableCell className='text-center d-flex justify-content-center'>
          <Button variant="contained" endIcon={<SendIcon />}>
              Edit
          </Button>
          </TableCell>
        </TableRow>
          );
      })};

    </TableBody>
    </Table>
  </TableContainer>
  </main>
  <ToastContainer></ToastContainer>
  </div>
  );
};

export default AgricultureProduct;
