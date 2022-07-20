import {alertActions} from 'actions';
import {history} from 'helpers';
import React, {Component, useEffect, useLayoutEffect} from 'react';
import {connect, useDispatch} from 'react-redux';
import {Route, Router, Switch, useLocation} from 'react-router-dom';
import About from 'markup/Pages/about/About';
import GarbageRoom from 'markup/Pages/admin/room-manager/GarbageRoom';
import RoomsManager from 'markup/Pages/admin/room-manager/RoomsManager';
import Garbage from 'markup/Pages/admin/user-manager/Garbage';
import UsersManager from 'markup/Pages/admin/user-manager/UsersManager';
import BlogLeftSidebar from 'markup/Pages/blog/BlogLeftSidebar';
import Contacts from 'markup/Pages/contact/Contacts';
import Error404 from 'markup/Pages/Error';
import ForgotPass from 'markup/Pages/ForgotPass';
import Homepage2 from 'markup/Pages/homepage/Homepage2';
import HotelBooking from 'markup/Pages/accommodation/HotelBooking';
import ListingDetails from 'markup/Pages/profile/ListingDetails';
import Packages from 'markup/Pages/accommodation/Packages';
import Place from 'markup/Pages/accommodation/Place';
import PortfolioGrid2 from 'markup/Pages/PortfolioGrid2';
import Popupss from 'markup/Pages/Tab';
import Header2 from "./Layout/Header2";
import Footer from "./Layout/Footer";
import Register2 from "./Pages/register/Register2";
import Login2 from "./Pages/login/Login2";
import Register from "./Pages/register/Register-react-hook-form";
import Hotel from "./Pages/accommodation/Hotel";


function Markup(props) {
    const dispatch = useDispatch();
    const location = history.location;

    // Scroll to top if path changes
    useLayoutEffect(() => {
        window.scrollTo(0, 0);
    }, [location.pathname]);

    useEffect(() => {
        history.listen((location, action) => {
            // clear alert on location change
            dispatch(alertActions.clear());
        });
    }, []);

    return (

        <Router history={history} basename="/">
            <Header2/>
            <div className="page-wraper">
                <Switch>
                    <Route path={['/', 'home']} exact component={Homepage2}/>
                    <Route path='/login' exact component={Login2}/>
                    <Route path='/register' exact component={Register}/>
                    <Route path='/register2' exact component={Register2}/>
                    <Route path='/forgot' exact component={ForgotPass}/>
                    <Route path='/admin/users-manager' exact component={UsersManager}/>
                    <Route path='/admin/users-manager/garbage' exact component={Garbage}/>
                    <Route path='/index-2' exact component={Homepage2}/>
                    <Route path='/about' exact component={About}/>
                    <Route path='/accommodation' exact component={Packages}/>
                    <Route path='/place' exact component={Place}/>
                    <Route path='/packages/:province' exact component={Packages}/>
                    <Route path='/error' exact component={Error404}/>
                    <Route path='/forgot' exact component={ForgotPass}/>
                    <Route path='/hotelbooking/:id' exact component={HotelBooking}/>
                    <Route path='/blogs' exact component={BlogLeftSidebar}/>
                    <Route path='/portfolio2' exact component={PortfolioGrid2}/>
                    <Route path='/contact' exact component={Contacts}/>
                    <Route path='/popup' exact component={Popupss}/>
                    <Route path='/listing' exact component={ListingDetails}/>
                    <Route path='/admin/rooms-manager' exact component={RoomsManager}/>
                    <Route path='/admin/rooms-manager/garbage' exact component={GarbageRoom}/>
                </Switch>
            </div>
            <Footer/>
        </Router>

    )

}

function mapState(state) {
    const {alert} = state;
    return {alert};
}

const actionCreators = {
    clearAlerts: alertActions.clear
};

const connectedMarkup = connect(mapState, actionCreators)(Markup);
export {connectedMarkup as Markup};

