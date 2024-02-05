import React from "react";
import NavBar from "./Common/NavBar";
import Footer from "./Common/Footer";
import Carousal from "./ShopBody/Carousal";
import Welcome from "./ShopBody/Welcome";
import HomeProduct from "./ShopBody/HomeProduct";
import SpecialOffer from "./ShopBody/SpecialOffer";
import MyService from "./ShopBody/MyService";
// import TeamSection from "./ShopBody/TeamSection";

function Shop(){
    return(
        // <div className="container-fluid">
        <>
            <NavBar></NavBar>
            <Carousal></Carousal>
            <Welcome></Welcome>
            <HomeProduct></HomeProduct>
            <SpecialOffer></SpecialOffer>
            <MyService></MyService>
            {/* <TeamSection></TeamSection> */}
            <Footer></Footer>
            </>
        // </div>
    );
}

export default Shop;