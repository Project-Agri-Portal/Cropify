import { Route, Switch } from "react-router-dom/cjs/react-router-dom.min";
import Login from "./components/UserAuthentication/SignIn/Login";
import Register from "./components/UserAuthentication/SignUp/Register";
import CommonHome from "./components/HomePage/CommonHome";
import Shop from "./components/Shop/shop.jsx";
import BlogPage from "./components/ComponentsFarmer/FarmerBlog/BlogPage";
import Contact from "./components/Shop/ShopBody/Contact.jsx";
import SellerMainPage from "./components/ComponentsSeller/SellerMainPage.jsx";
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
import Orders from "./components/Shop/ShopBody/Orders.jsx";
import AddProduct from "./components/ComponentAdmin/AddProduct.jsx";
import UserProfile from "./components/Shop/ShopBody/UserProfile.jsx";
import FarmerMainPage from "./components/ComponentsFarmer/FarmerMainPage.jsx";
import InformationPage from "./components/InformationPage/InformationPage.jsx";
import MachineryPage from "./components/InformationPage/MachineryPage.jsx";
import CropsPage from "./components/InformationPage/CropsPage.jsx";
import FruitsPage from "./components/InformationPage/FruitsPage.jsx";
import VegetablesPage from "./components/InformationPage/VegetablesPage.jsx";

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
          <Route path="/home/information/crops" component={CropsPage} exact />
          <Route path="/home/information/fruits" component={FruitsPage} exact />
          <Route path="/home/information/vegetables" component={VegetablesPage} exact />
          <Route path="/home/customer" component={Shop} exact />
          <Route path="/home/farmer" component={FarmerMainPage} exact />
          <Route path="/home/seller" component={SellerMainPage} exact />
          <Route path="/blog" component={BlogPage} exact />
          <Route path="/contact" component={Contact} exact />

          <Route path="/shop/about" component={ShopAboutUs} exact />
          <Route path="/shop/productsall" component={ProductListAll} exact />
          <Route path="/shop/cart" component={Cart} exact />
          <Route path="/shop/orders" component={Orders} exact />
          <Route path="/shop/profile" component={UserProfile} exact />
          <Route path="/shop/cart/checkout" component={Checkout} exact />
          <Route path="/admin" component={MainLayout} exact />
          <Route path="/admin/product" component={AdminProduct} exact />
          <Route path="/admin/machinery" component={Machinery} exact />
          <Route path="/admin/agriproduct" component={AgricultureProduct} exact />
          <Route path="/admin/seller" component={AdminSeller} exact />
          <Route path="/admin/farmer" component={AdminFarmer} exact />
          <Route path="/admin/addproduct" component={AddProduct} exact />

          <Route path="*" component={PageNotFound} />
        </Switch>
      </div>
    </center>
  );
}

export default App;
