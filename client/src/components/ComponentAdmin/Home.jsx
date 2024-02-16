// import React from 'react'
import 
{ BsFillArchiveFill, BsFillGrid3X3GapFill, BsPeopleFill, BsFillBellFill}
 from 'react-icons/bs'
 import 
 { BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer, LineChart, Line } 
 from 'recharts';
import "./MainLayout.css";
import { useEffect, useState } from 'react';
import count from "../../services/admin.service";

function Home() {

  const [agriProduct, setAgriProduct] = useState();
  const [farmProduct, setFarmProduct] = useState();
  const[machinery, setMachinery] = useState();
  const[seller, setSeller] = useState();
  const[customer, setCustomer] = useState();
  const[farmer, setFarmer] = useState();
  const[totalOrders, setTotalOrders] = useState();
  const[totalSale, setTotalSale] = useState();

  const onload = async () => {
    await count.agricultureProductCount()
              .then((result) => {
                setAgriProduct(result['data'])
                console.log(result);
              })
              .catch((error) => {
                console.log(error);
              })
    await count.farmProductCount()
              .then((result) => {
                setFarmProduct(result['data'])
                console.log(result);
              })
              .catch((error) => {
                console.log(error);
              })
    await count.machineryCount()
              .then((result) => {
                setMachinery(result['data'])
              })
              .catch((error) => {
                console.log(error);
              })
    await count.sellerCount()
              .then((result) => {
                setSeller(result['data'])
              })
              .catch((error) => {
                console.log(error);
              })
    await count.customerCount()
              .then((result) => {
                setCustomer(result['data']);
              })
              .catch((error) => {
                console.log(error);
              })
    await count.farmerCount()
              .then((result) => {
                setFarmer(result['data']);
              })
              .catch((error) => {
                console.log(error);
              })
  }

  useEffect(() => {
    onload();
  }, [])

    const data = [
        {
          name: 'Page A',
          uv: 4000,
          pv: 2400,
          amt: 2400,
        },
        {
          name: 'Page B',
          uv: 3000,
          pv: 1398,
          amt: 2210,
        },
        {
          name: 'Page C',
          uv: 2000,
          pv: 9800,
          amt: 2290,
        },
        {
          name: 'Page D',
          uv: 2780,
          pv: 3908,
          amt: 2000,
        },
        {
          name: 'Page E',
          uv: 1890,
          pv: 4800,
          amt: 2181,
        },
        {
          name: 'Page F',
          uv: 2390,
          pv: 3800,
          amt: 2500,
        },
        {
          name: 'Page G',
          uv: 3490,
          pv: 4300,
          amt: 2100,
        },
      ];
  return (
    <main className='main-container'>
        <div className='main-title'>
            <h3>DASHBOARD</h3>
        </div>

        <div className='main-cards'>
            <div className='card card1'>
                <div className='card-inner'>
                    <h3>Agriculture Product</h3>
                    <BsFillArchiveFill className='card_icon'/>
                </div>
                <h1>{agriProduct}</h1>
            </div>
            <div className='card card2'>
                <div className='card-inner'>
                    <h3>Farm Product</h3>
                    <BsFillArchiveFill className='card_icon'/>
                </div>
                <h1>{farmProduct}</h1>
            </div>

            <div className='card card3'>
                <div className='card-inner'>
                    <h3>Machinery</h3>
                    <BsFillArchiveFill className='card_icon'/>
                </div>
                <h1>{machinery}</h1>
            </div>


            <div className='card card4'>
                <div className='card-inner'>
                    <h3>Seller</h3>
                    <BsFillGrid3X3GapFill className='card_icon'/>
                </div>
                <h1>{seller}</h1>
            </div>
            <div className='card card1'>
                <div className='card-inner'>
                    <h3>Customer</h3>
                    <BsPeopleFill className='card_icon'/>
                </div>
                <h1>{customer}</h1>
            </div>
            <div className='card card2'>
                <div className='card-inner'>
                    <h3>Farmer</h3>
                    <BsFillArchiveFill className='card_icon'/>
                </div>
                <h1>{farmer}</h1>
            </div>
            <div className='card card3'>
                <div className='card-inner'>
                    <h3>Total Orders</h3>
                    <BsFillArchiveFill className='card_icon'/>
                </div>
                <h1>300</h1>
            </div>
            <div className='card card4'>
                <div className='card-inner'>
                    <h3>TOTAL SALE</h3>
                    <BsFillBellFill className='card_icon'/>
                </div>
                <h1>42000</h1>
            </div>
        </div>

        <div className='charts'>
            <ResponsiveContainer width="100%" height="100%">
            <BarChart
            width={500}
            height={300}
            data={data}
            margin={{
                top: 5,
                right: 30,
                left: 20,
                bottom: 5,
            }}
            >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Bar dataKey="pv" fill="#8884d8" />
                <Bar dataKey="uv" fill="#82ca9d" />
                </BarChart>
            </ResponsiveContainer>

            <ResponsiveContainer width="100%" height="100%">
                <LineChart
                width={500}
                height={300}
                data={data}
                margin={{
                    top: 5,
                    right: 30,
                    left: 20,
                    bottom: 5,
                }}
                >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="name" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Line type="monotone" dataKey="pv" stroke="#8884d8" activeDot={{ r: 8 }} />
                <Line type="monotone" dataKey="uv" stroke="#82ca9d" />
                </LineChart>
            </ResponsiveContainer>

        </div>
    </main>
  )
}

export default Home
