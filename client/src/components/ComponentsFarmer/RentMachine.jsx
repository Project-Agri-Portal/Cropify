import farmerService from "../../services/farmer.service";
import { useState } from "react";
import { useEffect } from "react";
import { ToastContainer, toast } from "react-toastify";
import Machinery from "../../services/machinery.service";

function RentMachine({ userId }) {
    const [productList, setProductList] = useState([]);
    const [quantityList, setQuantityList] = useState({});
    const [priceList, setPriceList] = useState({});
  
    const onload = () => {
      Machinery.allMachine()
        .then((result) => {
          setProductList(result.data);
        })
        .catch((error) => {
          console.log(error);
        });
    };
  
    const increase = (sellerMachineId, availQuantity) => {
      setQuantityList((prevQuantityList) => {
        const currentQuantity = prevQuantityList[sellerMachineId] || 0;
  
        // Check if increasing the quantity exceeds the available quantity
        if (currentQuantity < availQuantity) {
          return {
            ...prevQuantityList,
            [sellerMachineId]: currentQuantity + 1,
          };
        }
        toast.warn("only " + availQuantity + " available");
        return prevQuantityList;
      });
    };
  
    const decrease = (sellerMachineId) => {
      setQuantityList((prevQuantityList) => {
        const currentQuantity = prevQuantityList[sellerMachineId] || 0;
  
        // Check if decreasing the quantity is greater than 0
        if (currentQuantity > 0) {
          return {
            ...prevQuantityList,
            [sellerMachineId]: currentQuantity - 1,
          };
        }
        return prevQuantityList;
      });
    };

    const order = () => {
        toast.success("Machine order")
    }
  
    useEffect(() => {
      onload();
    }, []);

  return (
    <>
      {/* <!-- Page Content --> */}
      <div id="page-content-wrapper">
        <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
          <div className="d-flex align-items-center">
            <i className="fas fa-plus me-2"></i>
            <h2 className="fs-2 m-0">Products</h2>
          </div>
        </nav>

        {/* <!-- Product List Here--> */}
        <link
          rel="stylesheet"
          to="SellerProducts.css"
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
        />
        <link
          rel="stylesheet"
          to="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css"
          integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc="
          crossorigin="anonymous"
        />

        <div className="container">
          <div className="row align-item-left">
            <div className="col-md-6 ">
              <div className="mb-3">
                <h5 className="card-title" style={{ color: "black" }}>
                  Add Product
                </h5>
              </div>
            </div>
            <div className="col-md-6">
              <div className="d-flex flex-wrap align-items-center justify-content-end gap-2 mb-3"></div>
            </div>
          </div>
          <div className="row">
            <div className="col-lg-12">
              <div className="">
                <div className="table-responsive">
                  <table className="table project-list-table table-nowrap align-middle table-borderless table-striped">
                    <thead>
                      <tr>
                        <th scope="col">Seller ID</th>
                        <th scope="col">Machine ID</th>
                        <th scope="col">Machine Name</th>
                        <th scope="col">Machine Type Type</th>
                        <th scope="col" style={{ width: "200px;" }}>
                          Set Quantity
                        </th>
                        <th scope="col">Avail Quantity</th>
                        <th scope="col">Product Price</th>
                        <th>Order</th>
                      </tr>
                    </thead>
                    <tbody>
        {productList.map((prod) => {
          const sellerMachineId = prod['sellerMachineId'];
          const quantity = quantityList[sellerMachineId] || 1;
          const availQuantity = prod['availQuantity'];
          const price = prod['price'];

          return (
            <tr key={sellerMachineId}>
              <td>{prod['sellerId']}</td>
              <td>{prod['machineId']}</td>
              <td>
                <span>{prod['machineName']}</span>
              </td>
              <td>{prod['machineType']}</td>
              <td>
                <button
                  className="btn btn-outline-primary"
                  onClick={() => {
                    decrease(sellerMachineId);
                  }}
                >
                  -
                </button>{" "}
                {quantity}{" "}
                <button
                  className="btn btn-outline-primary"
                  onClick={() => {
                    increase(sellerMachineId, availQuantity);
                  }}
                >
                  +
                </button>
              </td>
              <td>{availQuantity}</td>
              <td>{price}</td>
              <td>
                <button
                  className="btn btn-primary"
                  onClick={() => {
                      order();
                  }}
                >
                  Add
                </button>
              </td>
            </tr>
          );
        })}
      </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
        <ToastContainer></ToastContainer>
      </div>
    </>
  );
}
export default RentMachine;
