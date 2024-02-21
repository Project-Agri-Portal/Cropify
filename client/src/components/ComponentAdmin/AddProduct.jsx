import React, { useState } from 'react';
import Header from './Header';
import Sidebar from './SideBar';
import Machinery from "../../services/machinery.service"
import FarmProduct from "../../services/farmproduct.service"
import AgriProduct from "../../services/agriproduct.service"
import { ToastContainer, toast } from "react-toastify";
import { BsJustify } from 'react-icons/bs';
import { TextField, Button, MenuItem } from '@mui/material';
import { Link } from 'react-router-dom';
import './MainLayout.css';

function AddProduct() {
  const [openSidebarToggle, setOpenSidebarToggle] = useState(false);
  const [productName, setProductName] = useState('');
  const [productType, setProductType] = useState('');
  const [productCategory, setProductCategory] = useState('');

  const OpenSidebar = () => {
    setOpenSidebarToggle(!openSidebarToggle);
  };

  const handleProductSubmit = (e) => {
    e.preventDefault();

    // Perform your logic to add the product
    console.log({
      productName,
      productType,
      productCategory,
    });

    if(productCategory === "farmerProduct"){
        const product = {
            farmProductName: productName,
            farmProductType: productType.toUpperCase(),
        }
        FarmProduct.addFarmProducts(product)
                    .then((result) => {
                        console.log(result);
                        toast.success('Farmer Product added')
                    })
                    .catch((error) => {
                        console.log(error);
                    })
    }
    else if(productCategory === "machine"){
        console.log("in machinery");
        const product = {
            machineName: productName,
            machineType: productType.toUpperCase(),
        }
        Machinery.addMachinery(product)
            .then((result) => {
                console.log(result);
                toast.success("Machinery Added")
            })
            .catch((error) => {
                console.log(error);
            })
    }
    else{
        const product = {
            agriProductName: productName,
            agriProductType: productType.toUpperCase(),
        }
        AgriProduct.addAgriProducts(product)
                    .then((result) => {
                        console.log(result);
                        toast.success("Agriculture Product Added")
                    })
                    .catch((error) => {
                        console.log(error);
                    })
    }

    // Reset the form fields
    setProductName('');
    setProductType('');
    setProductCategory('');
  };

  return (
    <div className='grid-container'>
      <Header OpenSidebar={OpenSidebar} />
      <Sidebar openSidebarToggle={openSidebarToggle} OpenSidebar={OpenSidebar} />

      <div className='content'>
        <div className='centered-form-container'>
          <form className='centered-form' onSubmit={handleProductSubmit}>
            <div style={{height:30}}></div>
            <TextField
              label='Product Name'
              variant='outlined'
              className='widthclass'
              fullWidth
              value={productName}
              onChange={(e) => setProductName(e.target.value)}
            />
            <div style={{height:30}}></div>
            <TextField
              label='Product Type'
              variant='outlined'
              className='widthclass'
              fullWidth
              value={productType}
              onChange={(e) => setProductType(e.target.value)}
            />
            <div style={{height:30}}></div>
            <TextField
              select
              label='Product Category'
              className='widthclass'
              variant='outlined'
              fullWidth
              value={productCategory}
              onChange={(e) => setProductCategory(e.target.value)}
            >
              <MenuItem value='machine'>Machine</MenuItem>
              <MenuItem value='farmerProduct'>Farmer Product</MenuItem>
              <MenuItem value='agricultureProduct'>Agriculture Product</MenuItem>
            </TextField>
            <div style={{height:30}}></div>
            <Button variant='contained' color='primary' type='submit' fullWidth className='widthclass'>
              Add Product
            </Button>
          </form>
        </div>
      </div>
      <ToastContainer></ToastContainer>
    </div>
  );
}

export default AddProduct;
