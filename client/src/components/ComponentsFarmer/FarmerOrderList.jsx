import farmerService from "../../services/farmer.service";
import { useState } from "react";
import { useEffect } from "react";

function FarmerOrderList({ userId }) {
  const [orderList, setOrderList] = useState([]);

  const onload = (userId) => {
    farmerService.getFarmerOrderList(userId)
      .then((result) => {
        setOrderList(result.data);
        console.log("farm order");
        console.log(result);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    onload(userId);
  }, []);

  const Orderdelete = async (oid) => {
    await farmerService.deleteOrder(oid)
      .then((result) => {
        onload(userId);
        console.log(result);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <>
      {/* <!-- Page Content --> */}
      <div id="page-content-wrapper">
        <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
          <div className="d-flex align-items-center">
            <i
              className="fas fa-align-left primary-text fs-4 me-3"
              id="menu-toggle"
            ></i>
            <h2 className="fs-2 m-0">Your Order List </h2>
          </div>
        </nav>

        <div className="container-fluid px-4">
          <div className="row my-5" style={{ opacity: "0.7;" }}>
            <h5 className="fs-4 mb-3 " style={{ color: "black;" }}>
              Current Orders
            </h5>
            <div className="col">
              <table className="table bg-white rounded shadow-sm  table-hover table-striped">
                <thead>
                  <tr>
                    <th scope="col" width="50">
                      Order Id
                    </th>
                    <th scope="col">Product Id</th>
                    <th scope="col">Customer Id</th>
                    <th scope="col">Order Date</th>
                    <th scope="col">Delivery Date</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Duration</th>
                    <th scope="col">Total Bill</th>
                    <th scope="col">Status</th>
                    <th scope="col">Cancel Order</th>
                  </tr>
                </thead>
                <tbody>
                  {orderList.map((orders) => {
                    return (
                      <tr>
                        <td>{orders["orderId"]}</td>
                        <th scope="row">{orders["farmProdId"]} </th>
                        <td>{orders["customerId"]}</td>
                        <td>{orders["orderDate"]}</td>
                        <td>{orders["deliveryDate"]}</td>
                        <td>{orders["quantity"]}</td>
                        <td>{orders["rentDuration"]}</td>
                        <td>{orders["totalPrice"]}</td>
                        <td>{orders["farmOrderStatus"]}</td>
                        <td>
                          <button
                            type="button"
                            class="btn btn-danger"
                            onClick={() => {
                              Orderdelete(orders["oid"]);
                            }}
                          >
                            Cancel
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
    </>
  );
}
export default FarmerOrderList;
