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
import ProductListAll from "./components/Shop/ShopBody/ProductList.jsx"
import Cart from "./components/Shop/ShopBody/Cart.jsx"
import Checkout from "./components/Shop/ShopBody/Checkout.jsx";
import MainLayout from "./components/ComponentAdmin/MainLayout.jsx";
import AdminProduct from "./components/ComponentAdmin/ProductList.jsx";
import Machinery from "./components/ComponentAdmin/Machinery.jsx";
import AgricultureProduct from "./components/ComponentAdmin/AgricultureProduct.jsx";
import AdminSeller from "./components/ComponentAdmin/SellerList.jsx";
import AdminFarmer from "./components/ComponentAdmin/FarmerList.jsx";
import InformationPage from "./components/InformationPage/InformationPage.jsx";
import MachineryPage from "./components/InformationPage/MachineryPage.jsx";
import Orders from "./components/Shop/ShopBody/Orders.jsx";

function App() {
  return (
    <center>
      <div className="App">
        <Switch>
          <Route path="/" component={CommonHome} exact />
          <Route path="/login" component={Login} exact />
          <Route path="/register" component={Register} exact />
          <Route path="/home" component={CommonHome} exact />
          <Route path="/home/information" component={InformationPage} exact />
          <Route path="/home/information/machinery" component={MachineryPage} exact />
          <Route path="/home/customer" component={Shop} exact />
          <Route path="/home/farmer" component={FarmerHome} exact />
          <Route path="/home/seller" component={SellerProfile} exact />
          <Route path="/blog" component={BlogPage} exact />
          <Route path="/contact" component={Contact} exact />
          <Route path="/farmer/profile" component={FarmerProfile} exact />
          <Route path="/farmer/cropinfo" component={FarmerCrop} exact />
          <Route path="/seller/profile" component={Seller} exact />
          <Route path="/seller/profileEdit" component={SellerEdit} exact />
          <Route path="/seller/orderlist" component={OrderList} exact />
          <Route path="/seller/productlist" component={ProductList} exact />
          <Route path="/shop/about" component={ShopAboutUs} exact />
          <Route path="/shop/productsall" component={ProductListAll} exact />
          <Route path="/shop/cart" component={Cart} exact />
          <Route path="/shop/orders" component={Orders} exact />
          <Route path="/shop/cart/checkout" component={Checkout} exact />
          <Route path="/admin" component={MainLayout} exact />
          <Route path="/admin/product" component={AdminProduct} exact />
          <Route path="/admin/machinery" component={Machinery} exact />
          <Route path="/admin/agriproduct" component={AgricultureProduct} exact />
          <Route path="/admin/seller" component={AdminSeller} exact />
          <Route path="/admin/farmer" component={AdminFarmer} exact />


          {/* <Route path="/shop/productdetails" component={SingleProductDetails} exact /> */}
          
          {/* <Route path="/shop/home" component={Shop} exact /> */}
          {/* <Route path="/shop" component={Shop} exact /> */}
          <Route path="*" component={PageNotFound} />
        </Switch>
      </div>
    </center>
  );
}

export default App;
