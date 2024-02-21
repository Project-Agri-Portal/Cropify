import farmerService from "../../services/farmer.service";
import Alert from "@mui/material/Alert";
import { useState } from "react";
import { useEffect } from "react";

function AddFarmProduct({ userId }) {
  const [addedProduct, setAddedProduct] = useState("");

  const [productList, setProductList] = useState([]);
  const [quantityList, setQuantityList] = useState({});
  const [priceList, setPriceList] = useState({});
  const [descriptionList, setDescriptionList] = useState({});

  const onload = () => {
    farmerService
      .getAllFarmProducts()
      .then((result) => {
        setProductList(result.data);
        console.log(result);
        setAddedProduct("");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const increase = (farmProductId) => {
    setQuantityList((prevQuantityList) => ({
      ...prevQuantityList,
      [farmProductId]: (prevQuantityList[farmProductId] || 0) + 1,
    }));
  };

  const decrease = (farmProductId) => {
    if (quantityList[farmProductId] > 0) {
      setQuantityList((prevQuantityList) => ({
        ...prevQuantityList,
        [farmProductId]: prevQuantityList[farmProductId] - 1,
      }));
    }
  };

  const handlePriceChange = (farmProductId, event) => {
    const newPrice = event.target.value;
    setPriceList((prevPriceList) => ({
      ...prevPriceList,
      [farmProductId]: newPrice,
    }));
  };

  const handleDescriptionChange = (farmProductId, event) => {
    const newDescription = event.target.value;
    setDescriptionList((prevDescriptionList) => ({
      ...prevDescriptionList,
      [farmProductId]: newDescription,
    }));
  };

  const add = (farmProductId) => {
    const farmProduct = {
      farmProductId: farmProductId,
      farmerId: userId,
      quantity: quantityList[farmProductId],
      price: priceList[farmProductId],
      description: descriptionList[farmProductId],
      verified: "",
      harvestDate: "2024-02-19",
      expiryDate: "2024-02-29",
      farmProductStatus: "FRESH",
    };

    console.log(farmProduct);

    farmerService
      .addFarmProduct(userId, farmProduct)
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
      {/* <!-- Page Content --> */}
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
                        <th scope="col">Product ID</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Product Type</th>
                        <th scope="col" style={{ width: "200px;" }}>
                          Set Quantity
                        </th>
                        <th scope="col">Product Price</th>
                        <th scope="col">Description</th>
                        <th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      {productList.map((prod) => {
                        const farmProductId = prod["farmProductId"];
                        const quantity = quantityList[farmProductId] || 0;
                        const price = priceList[farmProductId] || 0;
                        const description =
                          descriptionList[farmProductId] || "";
                        return (
                          <tr>
                            <td>{prod["farmProductId"]}</td>
                            <td>
                              <span>{prod["farmProductName"]}</span>
                            </td>
                            <td>{prod["farmProductType"]}</td>

                            <td>
                              <button
                                className="btn btn-outline-primary"
                                onClick={() => {
                                  decrease(farmProductId);
                                }}
                              >
                                -
                              </button>{" "}
                              {quantity}{" "}
                              <button
                                className="btn btn-outline-primary"
                                onClick={() => {
                                  increase(farmProductId);
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
                                  handlePriceChange(farmProductId, event);
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
                                  handleDescriptionChange(farmProductId, event);
                                }}
                              ></textarea>
                            </td>
                            <td>
                              <button
                                className="btn btn-primary"
                                onClick={() => {
                                  add(prod["farmProductId"]);
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
export default AddFarmProduct;
