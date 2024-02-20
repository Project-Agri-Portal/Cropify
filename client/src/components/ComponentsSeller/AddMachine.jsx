// import "../../../node_modules/bootstrap/dist/css/bootstrap.min.css";
// import { Link, useHistory } from "react-router-dom/cjs/react-router-dom.min";
import "./SellerProducts.css";
import Machines from "../../services/seller.service";
import Alert from "@mui/material/Alert";
import { useState } from "react";
import { useEffect } from "react";

function AddMachine({ userId }) {
  // const history = useHistory();

  // // Loggin out user and clearing the storages
  // function logoutUser() {
  //   localStorage.clear();
  //   sessionStorage.clear();
  //   history.replace("/");
  // }
  const [addedProduct, setAddedProduct] = useState("");

  const [machineList, setMachineList] = useState([]);
  const [quantityList, setQuantityList] = useState({});
  const [priceList, setPriceList] = useState({});
  const [descriptionList, setDescriptionList] = useState({});

  const onload = () => {
    Machines.getAllMachinery()
      .then((result) => {
        setMachineList(result.data);
        console.log(result);
        setAddedProduct("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const increase = (machineId) => {
    setQuantityList((prevQuantityList) => ({
      ...prevQuantityList,
      [machineId]: (prevQuantityList[machineId] || 0) + 1,
    }));
  };

  const decrease = (machineId) => {
    if (quantityList[machineId] > 0) {
      setQuantityList((prevQuantityList) => ({
        ...prevQuantityList,
        [machineId]: prevQuantityList[machineId] - 1,
      }));
    }
  };

  const handlePriceChange = (machineId, event) => {
    const newPrice = event.target.value;
    setPriceList((prevPriceList) => ({
      ...prevPriceList,
      [machineId]: newPrice,
    }));
  };

  const handleDescriptionChange = (machineId, event) => {
    const newDescription = event.target.value;
    setDescriptionList((prevDescriptionList) => ({
      ...prevDescriptionList,
      [machineId]: newDescription,
    }));
  };

  const add = (machineryId) => {
    // const userId = parseInt(localStorage.getItem("userId"));

    const machine = {
      machineryId: machineryId,
      sellerId: userId,
      quantity: quantityList[machineryId],
      price: priceList[machineryId],
      description: descriptionList[machineryId],
      availQuantity: quantityList[machineryId],
      verified: "",
    };

    console.log(machine);

    Machines.addMachine(userId, machine)
      .then((result) => {
        console.log(result);
        setAddedProduct("true");
      })
      .catch((error) => {
        console.log(error);
        setAddedProduct("false");
      });
  };

  useEffect(() => {
    onload();
  }, []);

  return (
    <>
      <div id="page-content-wrapper">
        {addedProduct === "true" && (
          <Alert variant="filled" severity="success">
            Product added
          </Alert>
        )}
        {addedProduct === "false" && (
          <Alert variant="filled" severity="error">
            Error while adding product
          </Alert>
        )}
        <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
          <div className="d-flex align-items-center">
            <i className="fas fa-project-diagram me-2"></i>
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
                  Add Machinery
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
                        <th scope="col">Machine ID</th>
                        <th scope="col">Machine Name</th>
                        <th scope="col">Machine Type</th>
                        <th scope="col" style={{ width: "200px;" }}>
                          Set Quantity
                        </th>
                        <th scope="col">Machine Price</th>
                        <th scope="col">Description</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      {machineList.map((prod) => {
                        const machineId = prod["machineId"];
                        const quantity = quantityList[machineId] || 0;
                        const price = priceList[machineId] || 0;
                        const description = descriptionList[machineId] || "";
                        return (
                          <tr>
                            <td>{prod["machineId"]}</td>
                            <td>
                              <span>{prod["machineName"]}</span>
                            </td>
                            <td>{prod["machineType"]}</td>

                            <td>
                              <button
                                className="btn btn-outline-primary"
                                onClick={() => {
                                  decrease(machineId);
                                }}
                              >
                                -
                              </button>{" "}
                              {quantity}{" "}
                              <button
                                className="btn btn-outline-primary"
                                onClick={() => {
                                  increase(machineId);
                                }}
                              >
                                +
                              </button>
                            </td>

                            <td>
                              <input
                                type="number"
                                value={price}
                                onChange={(event) => {
                                  handlePriceChange(machineId, event);
                                }}
                              />
                            </td>
                            <td>
                              <textarea
                                class="form-control is-invalid"
                                id="validationTextarea"
                                placeholder="Description here"
                                required
                                value={description}
                                onChange={(event) => {
                                  handleDescriptionChange(machineId, event);
                                }}
                              ></textarea>
                            </td>
                            <td>
                              <button
                                className="btn btn-primary"
                                onClick={() => {
                                  add(prod["machineId"]);
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
      </div>
    </>
  );
}
export default AddMachine;
