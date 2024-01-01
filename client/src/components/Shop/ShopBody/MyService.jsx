import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import Pulses from "../../../assets/ShopImages/category-4.jpg"
import Delivery from "../../../assets/ShopImages/delivery.jpg"
import Healthy from "../../../assets/ShopImages/image_5.jpg"
import "./MyService.css"

const MyService = () =>{
    return(
        <div class="container">
        <h2 class="text-center">Our Service</h2>
        {/* <!-- <hr class="mx-auto mb-5 wb-25" /> --> */}
        <hr class="hrteam" />
        <div class="underline"></div>
        <br />
        <div class="row mb-5">
          <div class="col-12 col-sm-6 col-md-4 m-auto">
            {/* <!-- Card Start --> */}
            <div class="card shadow">
              <img src={Pulses} alt="" class="card-img-top" />
              <div class="card-body">
                <h3 class="text-center">Quality</h3>
                <hr class="mx-auto w-75" />
                <p>
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Enim
                  repellendus totam esse.
                </p>
              </div>
            </div>
          </div>

          <div class="col-12 col-sm-6 col-md-4 m-auto">
            {/* <!-- Card Start --> */}
            <div class="card shadow">
              <img
                src={Delivery}
                alt=""
                class="card-img-top"
                id="imgService"
              />
              <div class="card-body">
                <h3 class="text-center">Free Delivery</h3>
                <hr class="mx-auto w-75" />
                <p>
                  Lorem, ipsum dolor sit amet consectetur adipisicing elit. Enim
                  repellendus totam esse.
                </p>
              </div>
            </div>
          </div>

          <div class="col-12 col-sm-6 col-md-4 m-auto">
            {/* <!-- Card Start --> */}
            <div class="card shadow">
              <img src={Healthy} alt="" class="card-img-top" />
              <div class="card-body">
                <h3 class="text-center">Healthy</h3>
                <hr class="mx-auto w-75" />
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