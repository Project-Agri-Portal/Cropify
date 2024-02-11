import React, {Fragment} from 'react'
import {Link} from "react-router-dom"
import {useSelector} from "react-redux";
// import MetaData

const Profile = () => {

    const {userEvent, loading} = useSelector(state => state.auth);

//   return (
//     <Fragment>
//         {loading ? }
//     </Fragment>
//   )
}

export default Profile
