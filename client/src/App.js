import { Route, Switch } from "react-router-dom/cjs/react-router-dom.min";
// import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
// import "../node_modules/bootstrap/dist/js/bootstrap.bundle.min";
import Login from "./components/UserAuthentication/SignIn/Login";
import Register from "./components/UserAuthentication/SignUp/Register";
import CommonHome from "./components/HomePage/CommonHome";
import FarmerHome from "./components/HomePage/FarmerHome/FarmerHome";
import BlogPage from "./components/ComponentsFarmer/FarmerBlog/BlogPage";
import FarmerProfile from "./components/ComponentsFarmer/FarmerProfile/FarmerProfile";
import FarmerCrop from "./components/ComponentsFarmer/FarmerCrops/FarmerCrop";

function App() {
  return (
    <center>
      <div className="App">
        <Switch>
          <Route path="/" component={CommonHome} exact />
          <Route path="/home" component={CommonHome} exact />
          <Route path="/login" component={Login} exact />
          <Route path="/register" component={Register} exact />
          <Route path="/blog" component={BlogPage} exact />
          <Route path="/home/farmer" component={FarmerHome} exact />
          <Route path="/farmer/profile" component={FarmerProfile} exact />
          <Route path="/farmer/cropinfo" component={FarmerCrop} exact />
          {/* <Route path="*" component={NotFound} exact /> */}
        </Switch>
      </div>
    </center>
  );
}

export default App;
