// ProductList.js
import React from 'react';
import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Header from './Header'
import Sidebar from './SideBar'

const ProductList = () => {
  // Mock product data for demonstration
  const productList = [
    { id: 1, name: 'Product 1', price: 20.99 },
    { id: 2, name: 'Product 2', price: 15.49 },
    // Add more product data as needed
  ];

  return (
    <>
    <div className='grid-container'>
    <Header></Header>
    <Sidebar></Sidebar>
    <div className="table-responsive">
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Product Name</th>
            <th>Description</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {/* {products.map((product, index) => (
            <tr key={index}>
              <td>{product.name}</td>
              <td>{product.description}</td>
              <td>{product.price}</td>
            </tr>
          ))} */}
        </tbody>
      </table>
    </div>
    </div>
    </>
  );
};

export default ProductList;
