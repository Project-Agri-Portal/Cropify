import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Orange from "../../../assets/ShopImages/orange.png"
import "./ProductList.css"
import Navbar from "../Common/NavBar"
import Footer from "../Common/Footer"

const ProductList = () => {
    return (

        <>

        <Navbar></Navbar>

        <div className="container py-5">
        <h1 className="text-center">Popular Dishes</h1>
        <div className="row row-cols-1 row-cols-md-3 g-4 py-5">

            <div className="col">
                <div className="card" id="card-id">
                    <div className="imgcon">
                    <img src={Orange} className="card-img-top" id="card-img-id" alt="..."/>
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">TIRAMISU CAKE</h5>
                        <p className="card-text" id="card-text-id">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam
                            dignissimos</p>
                            <div style={{height:"10px"}}></div>
                            <p>Seller name : Janak</p>
                    </div>
                    <div className="mb-5 d-flex justify-content-around" id="btid">
                        <h3>190$</h3>
                        <button className="btn btn-primary" id="btnid">Add to Cart</button>
                    </div>
                </div>
            </div>

            <div className="col">
                <div className="card" id="card-id">
                    <div className="imgcon">
                    <img src={Orange} className="card-img-top" id="card-img-id" alt="..."/>
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">TIRAMISU CAKE</h5>
                        <p className="card-text" id="card-text-id">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam
                            dignissimos</p>
                            <div style={{height:"10px"}}></div>
                            <p>Seller name : Janak</p>
                    </div>
                    <div className="mb-5 d-flex justify-content-around" id="btid">
                        <h3>190$</h3>
                        <button className="btn btn-primary" id="btnid">Add to Cart</button>
                    </div>
                </div>
            </div>

            <div className="col">
                <div className="card" id="card-id">
                    <div className="imgcon">
                    <img src={Orange} className="card-img-top" id="card-img-id" alt="..."/>
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">TIRAMISU CAKE</h5>
                        <p className="card-text" id="card-text-id">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam
                            dignissimos</p>
                            <div style={{height:"10px"}}></div>
                            <p>Seller name : Janak</p>
                    </div>
                    <div className="mb-5 d-flex justify-content-around" id="btid">
                        <h3>190$</h3>
                        <button className="btn btn-primary" id="btnid">Add to Cart</button>
                    </div>
                </div>
            </div>

            <div className="col">
                <div className="card" id="card-id">
                    <div className="imgcon">
                    <img src={Orange} className="card-img-top" id="card-img-id" alt="..."/>
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">TIRAMISU CAKE</h5>
                        <p className="card-text" id="card-text-id">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam
                            dignissimos</p>
                            <div style={{height:"10px"}}></div>
                            <p>Seller name : Janak</p>
                    </div>
                    <div className="mb-5 d-flex justify-content-around" id="btid">
                        <h3>190$</h3>
                        <button className="btn btn-primary" id="btnid">Add to Cart</button>
                    </div>
                </div>
            </div>

            <div className="col">
                <div className="card" id="card-id">
                    <div className="imgcon">
                    <img src={Orange} className="card-img-top" id="card-img-id" alt="..."/>
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">TIRAMISU CAKE</h5>
                        <p className="card-text" id="card-text-id">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam
                            dignissimos</p>
                            <div style={{height:"10px"}}></div>
                            <p>Seller name : Janak</p>
                    </div>
                    <div className="mb-5 d-flex justify-content-around" id="btid">
                        <h3>190$</h3>
                        <button className="btn btn-primary" id="btnid">Add to Cart</button>
                    </div>
                </div>
            </div>
            <div className="col">
                <div className="card" id="card-id">
                    <div className="imgcon">
                    <img src={Orange} className="card-img-top" id="card-img-id" alt="..."/>
                    </div>
                    <div className="card-body">
                        <h5 className="card-title">TIRAMISU CAKE</h5>
                        <p className="card-text" id="card-text-id">Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam
                            dignissimos</p>
                            <div style={{height:"10px"}}></div>
                            <p>Seller name : Janak</p>
                    </div>
                    <div className="mb-5 d-flex justify-content-around" id="btid">
                        <h3>190$</h3>
                        <button className="btn btn-primary" id="btnid">Add to Cart</button>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <Footer></Footer>
    </>
    


//             <div className="container">
//                         <div class="row row-cols-1 row-cols-md-3 g-4">
//   <div class="col">
//     <div class="card border">
//       <img src={Orange} class="card-img-top" alt="..."/>
//       <div class="card-body">
//         <h5 class="card-title">Card title</h5>
//         <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
//       </div>
//     </div>
//   </div>
//   <div class="col">
//     <div class="card">
//       <img src={Orange} class="card-img-top" alt="..."/>
//       <div class="card-body">
//         <h5 class="card-title">Card title</h5>
//         <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
//       </div>
//     </div>
//   </div>
//   <div class="col">
//     <div class="card">
//       <img src={Orange} class="card-img-top" alt="..."/>
//       <div class="card-body">
//         <h5 class="card-title">Card title</h5>
//         <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>
//       </div>
//     </div>
//   </div>
//   <div class="col">
//     <div class="card">
//       <img src={Orange} class="card-img-top" alt="..." />
//       <div class="card-body">
//         <h5 class="card-title">Card title</h5>
//         <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
//       </div>
//     </div>
//   </div>
// </div>
//             </div>




    );
};

export default ProductList;