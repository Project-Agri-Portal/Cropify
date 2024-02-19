import React, { useState } from 'react'
import "./WeatherAPI.css"
import "../../../../node_modules/bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap.bundle"
import axios from 'axios'
import Clear from "../../../../src/assets/WeacherAssets/clear.png"
import Search from "../../../../src/assets/WeacherAssets/search.png"
import Cloud from "../../../../src/assets/WeacherAssets/cloud.png"
import Drizzeled from "../../../../src/assets/WeacherAssets/drizzle.png"
import Rain from "../../../../src/assets/WeacherAssets/rain.png"
import Snow from "../../../../src/assets/WeacherAssets/snow.png"
import Wind from "../../../../src/assets/WeacherAssets/wind.png"
import Humidity from "../../../../src/assets/WeacherAssets/humidity.png"


const WeatherAPI = () => {

    const apiKey = "6747e761ce0d2c185c5615929334e08c";
    const wetherUrl = "https://api.openweathermap.org/data/2.5/weather?q=London&appid="+apiKey

    const [wicon, setWicon] = useState(Cloud);

    const search = async() => {
        const element = document.getElementsByClassName("cityInput");
        if(element[0].value === ""){
            return 0
        }
        let url = `https://api.openweathermap.org/data/2.5/weather?q=${element[0].value}&appid=6747e761ce0d2c185c5615929334e08c`;

        let response = await fetch(url)
        let data = await response.json();
        const humidity = document.getElementsByClassName("humidity-percent")
        const wind = document.getElementsByClassName("wind-rate")

        const tempreture = document.getElementsByClassName("weather-temp")
        const location = document.getElementsByClassName("weather-location")

        humidity[0].innerHTML = data.main.humidity + "%";
        wind[0].innerHTML = data.wind.speed + "km/hr";
        tempreture[0].innerHTML = data.main.temp + "°c";
        location[0].innerHTML = data.name;

        if(data.weather[0].icon === "01d" || data.weather[0].icon === "01n"){
            setWicon(Clear);
        }
        else if(data.weather[0].icon === "02d" || data.weather[0].icon === "02n"){
            setWicon(Cloud);
        }
        else if(data.weather[0].icon === "03d" || data.weather[0].icon === "03n"){
            setWicon(Drizzeled);
        }
        else if(data.weather[0].icon === "04d" || data.weather[0].icon === "04n"){
            setWicon(Drizzeled);
        }
        else if(data.weather[0].icon === "09d" || data.weather[0].icon === "09n"){
            setWicon(Rain);
        }
        else if(data.weather[0].icon === "10d" || data.weather[0].icon === "10n"){
            setWicon(Cloud);
        }
        else if(data.weather[0].icon === "13d" || data.weather[0].icon === "13n"){
            setWicon(Snow);
        }
        else{
            setWicon(Clear);
        }
    }

  return (
    <div className='container container-class'>
        <div className='top-bar'>
            <input type="text" name="" id="" className='cityInput' placeholder='Search'/>
            <div className='search-icon' onClick={() => {search()}}>
                <img src={Search} alt="" />
            </div>
        </div>
        <div className='weather-img'>
            <img src={wicon} alt="" />
            <div className='weather-temp'>24°c</div>
            <div className='weather-location'>New York</div>
            <div className='data-container'>
                <div className='element'>
                    <img src={Humidity} alt=""  className='icon'/>
                    <div className='data'>
                        <div className='humidity-percent'>64%</div>
                        <div className='text'>Humidity</div>
                    </div>
                </div>

                <div className='element'>
                    <img src={Wind} alt=""  className='icon'/>
                    <div className='data'>
                        <div className='wind-rate'>18 km/hr</div>
                        <div className='text'>Wind Speed</div>
                    </div>
                </div>

            </div>
        </div>
    </div>
  )
}

export default WeatherAPI
