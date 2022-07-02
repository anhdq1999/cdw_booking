import { alertActions } from 'actions';
import { history } from 'helpers';
import About from 'markup/Pages/About';
import GarbageRoom from 'markup/Pages/admin/room-manager/GarbageRoom';
import RoomsManager from 'markup/Pages/admin/room-manager/RoomsManager';
import Garbage from 'markup/Pages/admin/user-manager/Garbage';
import UsersManager from 'markup/Pages/admin/user-manager/UsersManager';
import BlogClassic from 'markup/Pages/BlogClassic';
import BlogClassicSidebar from 'markup/Pages/BlogClassicSidebar';
import BlogDetails from 'markup/Pages/BlogDetails';
import BlogGrid from 'markup/Pages/BlogGrid';
import BlogGridSidebar from 'markup/Pages/BlogGridSidebar';
import BlogLeftSidebar from 'markup/Pages/BlogLeftSidebar';
import BookingDetails from 'markup/Pages/BookingDetails';
import Contacts from 'markup/Pages/Contacts';
import Error404 from 'markup/Pages/Error';
import Homepage2 from 'markup/Pages/Homepage2';
import Hotel from 'markup/Pages/Hotel';
import HotelBooking from 'markup/Pages/HotelBooking';
import ListingDetails from 'markup/Pages/ListingDetails';
import Packages from 'markup/Pages/Packages';
import Place from 'markup/Pages/Place';
import PortfolioGrid2 from 'markup/Pages/PortfolioGrid2';
import Popupss from 'markup/Pages/Tab';
import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { Route, Router, Switch } from 'react-router-dom';
import './css/plugins.css';
import './css/skin/skin-1.css';
import './css/style.css';
import './css/templete.css';
import ForgotPass from './markup/Pages/ForgotPass';
import Homepage from './markup/Pages/Homepage';
import Login2 from './markup/Pages/login/Login2';
import Register from './markup/Pages/register/Register-react-hook-form';
import Register2 from './markup/Pages/register/Register2';
import './plugins/fontawesome/css/font-awesome.min.css';
import './plugins/slick/slick-theme.min.css';
import './plugins/slick/slick.min.css';




function App() {

  const dispatch = useDispatch();

  useEffect(() => {
    history.listen((location, action) => {
      dispatch(alertActions.clear());
    }, []);
  })

  return (

    <div className="App">

      <Router history={history} basename="/" >
        <div className="page-wraper">
          <Switch>
            <Route path={['/', 'home']} exact component={Homepage} />
            <Route path='/login' exact component={Login2} />
            <Route path='/register' exact component={Register} />
            <Route path='/register2' exact component={Register2} />
            <Route path='/forgot' exact component={ForgotPass} />
            <Route path='/admin/users-manager' exact component={UsersManager} />
            <Route path='/admin/users-manager/garbage' exact component={Garbage} />
            <Route path='/index-2' exact component={Homepage2} />
            <Route path='/about' exact component={About} />
            <Route path='/hotel' exact component={Hotel} />
            <Route path='/booking/:id' exact component={BookingDetails} />
            <Route path='/place' exact component={Place} />
            <Route path='/packages/:province' exact component={Packages} />
            <Route path='/error' exact component={Error404} />
            <Route path='/forgot' exact component={ForgotPass} />
            <Route path='/hotelbooking/:id' exact component={HotelBooking} />
            <Route path='/blogclassic' exact component={BlogClassic} />
            <Route path='/blogclassicsidebar' exact component={BlogClassicSidebar} />
            <Route path='/bloggrid' exact component={BlogGrid} />
            <Route path='/bloggridsidebar' exact component={BlogGridSidebar} />
            <Route path='/blogleftsidebar' exact component={BlogLeftSidebar} />
            <Route path='/blogdetails' exact component={BlogDetails} />
            <Route path='/portfolio2' exact component={PortfolioGrid2} />
            <Route path='/contact' exact component={Contacts} />
            <Route path='/popup' exact component={Popupss} />
            <Route path='/listing' exact component={ListingDetails} />
            <Route path='/admin/rooms-manager' exact component={RoomsManager} />
            <Route path='/admin/rooms-manager/garbage' exact component={GarbageRoom} />
          </Switch>
        </div>
      </Router>
    </div>
  )
}



export default App;
