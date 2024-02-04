import { Route, Switch } from "react-router-dom/cjs/react-router-dom.min";
// import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
// import "../node_modules/bootstrap/dist/js/bootstrap.bundle.min";
import Login from "./components/UserAuthentication/SignIn/Login";
import Register from "./components/UserAuthentication/SignUp/Register";
import CommonHome from "./components/HomePage/CommonHome";
import Shop from "./components/Shop/shop.jsx";
import FarmerHome from "./components/HomePage/FarmerHome/FarmerHome";
import BlogPage from "./components/ComponentsFarmer/FarmerBlog/BlogPage";
import FarmerProfile from "./components/ComponentsFarmer/FarmerProfile/FarmerProfile";
import FarmerCrop from "./components/ComponentsFarmer/FarmerCrops/FarmerCrop";
import Contact from "./components/Shop/ShopBody/Contact.jsx";
import Seller from "./components/ComponentsSeller/Seller.jsx";
import SellerProfile from "./components/ComponentsSeller/SellerProfile.jsx";
import SellerEdit from "./components/ComponentsSeller/SellerProfileEdit.jsx";
import OrderList from "./components/ComponentsSeller/SellerOrderList.jsx";
import ProductList from "./components/ComponentsSeller/SellerProducts.jsx";
import PageNotFound from "./components/NotFound/PageNotFound.jsx";
import ShopAboutUs from "./components/Shop/ShopBody/AboutUs.jsx"

function App() {
  return (
    <center>
      <div className="App">
        <Switch>
          <Route path="/" component={CommonHome} exact />
          <Route path="/login" component={Login} exact />
          <Route path="/register" component={Register} exact />
          <Route path="/home" component={CommonHome} exact />
          <Route path="/home/customer" component={Shop} exact />
          <Route path="/home/farmer" component={FarmerHome} exact />
          <Route path="/home/seller" component={Seller} exact />
          <Route path="/blog" component={BlogPage} exact />
          <Route path="/contact" component={Contact} exact />
          <Route path="/farmer/profile" component={FarmerProfile} exact />
          <Route path="/farmer/cropinfo" component={FarmerCrop} exact />
          <Route path="/seller/profile" component={SellerProfile} exact />
          <Route path="/seller/profileEdit" component={SellerEdit} exact />
          <Route path="/seller/orderlist" component={OrderList} exact />
          <Route path="/seller/productlist" component={ProductList} exact />
          <Route path="/shop/about" component={ShopAboutUs} exact />
          
          {/* <Route path="/shop/home" component={Shop} exact /> */}
          {/* <Route path="/shop" component={Shop} exact /> */}
          <Route path="*" component={PageNotFound} />
        </Switch>
      </div>
    </center>
  );
}

export default App;
