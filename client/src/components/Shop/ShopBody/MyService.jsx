import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Pulses from "../../../assets/ShopImages/category-4.jpg"
import Delivery from "../../../assets/ShopImages/delivery.jpg"
import Healthy from "../../../assets/ShopImages/image_5.jpg"
import "./MyService.css"

const MyService = () =>{
    return(
        <div className="container">
          <div style={{height:"80px"}}></div>
        <h2 className="text-center">Our Service</h2>
        {/* <!-- <hr className="mx-auto mb-5 wb-25" /> --> */}
        <hr className="hrteam" />
        <div className="underline"></div>
        <br />
        <div className="row mb-5">
          <div className="col-12 col-sm-6 col-md-4 m-auto">
            {/* <!-- Card Start --> */}
            <div className="card shadow cardid" id="serviceid">
              <img src={Pulses} alt="" className="card-img-top" />
              <div className="card-body">
                <h3 className="text-center">Quality</h3>
                <hr className="mx-auto w-75" />
                <p>
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Enim
                  repellendus totam esse.
                </p>
              </div>
            </div>
          </div>

          <div className="col-12 col-sm-6 col-md-4 m-auto">
            {/* <!-- Card Start --> */}
            <div className="card shadow cardid" id="serviceid">
              <img
                src={Delivery}
                alt=""
                className="card-img-top"
                id="imgService"
              />
              <div className="card-body">
                <h3 className="text-center">Free Delivery</h3>
                <hr className="mx-auto w-75" />
                <p>
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Enim
                  repellendus totam esse.
                </p>
              </div>
            </div>
          </div>

          <div className="col-12 col-sm-6 col-md-4 m-auto">
            {/* <!-- Card Start --> */}
            <div className="card shadow cardid" id="serviceid">
              <img src={Healthy} alt="" className="card-img-top" />
              <div className="card-body">
                <h3 className="text-center">Healthy</h3>
                <hr className="mx-auto w-75" />
                <p>
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Enim
                  repellendus totam esse.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
};

export default MyService;