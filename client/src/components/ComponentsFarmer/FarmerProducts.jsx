import farmerService from "../../services/farmer.service";
import { useState } from "react";
import { useEffect } from "react";

function FarmerProductList({ userId }) {
  const [productList, setProductList] = useState([]);

  const onload = () => {
    farmerService.getFarmerProducts(userId)
      .then((result) => {
        setProductList(result.data);
        console.log(result);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteProduct = async (id) => {
    await farmerService.deleteFarmerProducts(id)
      .then((result) => {
        console.log(result);
        onload();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    onload();
  }, []);

  return (
    <>
      {/* <!-- Page Content --> */}
      <div id="page-content-wrapper">
        <nav className="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
          <div className="d-flex align-items-center">
            <i className="fas fa-project-diagram me-2"></i>
            <h2 className="fs-2 m-0">Products</h2>
          </div>
        </nav>

        {/* <!-- Product List Here--> */}
        <link
          rel="stylesheet"
          to="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/5.3.45/css/materialdesignicons.css"
          integrity="sha256-NAxhqDvtY0l4xn+YVa6WjAcmd94NNfttjNsDmNatFVc="
          crossorigin="anonymous"
        />

        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <div className="">
                <div className="table-responsive">
                  <table className="table project-list-table table-nowrap align-middle table-borderless">
                    <thead>
                      <tr>
                        <th scope="col">Product ID</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Total Quantity</th>
                        <th scope="col">Product Price</th>
                        <th scope="col">Product Description</th>
                        <th scope="col" style={{ width: "200px;" }}>
                          Action
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                      {productList.map((prod) => {
                        return (
                          <tr>
                            <td>{prod["farmProductId"]}</td>
                            <td>
                              <span>{prod["farmProductName"]}</span>
                            </td>
                            <td>{prod["quantity"]}</td>
                            <td>{prod["price"]}</td>
                            <td>{prod["description"]}</td>
                            <td>
                              <ul className="list-inline mb-0">
                                <li className="list-inline-item">
                                  <span
                                    data-bs-toggle="tooltip"
                                    data-bs-placement="top"
                                    title="Delete"
                                    className="px-2 text-danger"
                                    style={{ cursor: "pointer" }}
                                  >
                                    <i
                                      className="bx bx-trash-alt font-size-18"
                                      onClick={() => {
                                        deleteProduct(
                                          prod["farmProductDetailsId"]
                                        );
                                      }}
                                    ></i>
                                  </span>
                                </li>
                              </ul>
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
export default FarmerProductList;
