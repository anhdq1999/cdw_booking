import { alertActions } from 'actions';
import { history } from 'helpers';
import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Route, Router, Switch } from 'react-router-dom';
import About from './Pages/About';
import GarbageRoom from './Pages/admin/room-manager/GarbageRoom';
import RoomsManager from './Pages/admin/room-manager/RoomsManager';
import Update from './Pages/admin/room-manager/Update';
import Garbage from './Pages/admin/user-manager/Garbage';
import UsersManager from './Pages/admin/user-manager/UsersManager';
import BlogClassic from './Pages/BlogClassic';
import BlogClassicSidebar from './Pages/BlogClassicSidebar';
import BlogDetails from './Pages/BlogDetails';
import BlogGrid from './Pages/BlogGrid';
import BlogGridSidebar from './Pages/BlogGridSidebar';
import BlogLeftSidebar from './Pages/BlogLeftSidebar';
import BookingDetails from './Pages/BookingDetails';
import Contacts from './Pages/Contacts';
import Error404 from './Pages/Error';
import ForgotPass from './Pages/ForgotPass';
import Homepage from './Pages/Homepage';
import Homepage2 from './Pages/Homepage2';
import Hotel from './Pages/Hotel';
import HotelBooking from './Pages/HotelBooking';
import ListingDetails from './Pages/ListingDetails';
import { Login2 } from './Pages/Login2';
import Packages from './Pages/Packages';
import Place from './Pages/Place';
import PortfolioGrid2 from './Pages/PortfolioGrid2';
import Register from './Pages/Register-react-hook-form';
import Register2 from './Pages/register/Register2';
import Popupss from './Pages/Tab';




class Markup extends Component {
    constructor(props) {
        super(props);

        history.listen((location, action) => {
            // clear alert on location change
            this.props.clearAlerts();
        });
    }

    render() {
        return (
           
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
          <Route path='/booking' exact component={BookingDetails} />
          <Route path='/place' exact component={Place} />
          <Route path='/packages' exact component={Packages} />
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
          <Route path='/admin/rooms-manager/update' exact component={Update} />
        </Switch>
      </div>
    </Router>

        )
    }
}

function mapState(state) {
    const { alert } = state;
    return { alert };
}

const actionCreators = {
    clearAlerts: alertActions.clear
};

const connectedMarkup = connect(mapState, actionCreators)(Markup);
export { connectedMarkup as Markup };

