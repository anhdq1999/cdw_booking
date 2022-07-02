import { userActions } from 'actions';
import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

function Header2(props) {
    useEffect(() => {

        // sidebar open/close

        const btn = document.querySelector('.navicon');
        const aaa = document.querySelector('.myNavbar ');

        function toggleFunc() {
            return aaa.classList.toggle("show");
        }

        btn.addEventListener('click', toggleFunc);


        // Sidenav li open close
        const navUl = [].slice.call(document.querySelectorAll('.navbar-nav > li'));
        for (let y = 0; y < navUl.length; y++) {
            navUl[y].addEventListener('click', function () { checkLi(this) });
        }

        function checkLi(current) {
            navUl.forEach(el => el.classList.remove('open'));
            current.classList.add('open');
        }

    },[])
    const dispatch = useDispatch();
    const { user, loggedIn } = useSelector((state) => state.authentication)
    // const[loggingIn,setLoggingIn] = useState(loggedIn)

    const handleLogout=()=> {
        dispatch(userActions.logout());
    }
    return (
        <header className="site-header mo-left header header-2">
            <div className="top-bar">
                <div className="container-fluid">
                    <div className="row d-flex justify-content-between">
                        <div className="dlab-topbar-left">
                            <ul>
                                <li>
                                    <Link to={'/hotel'} className="site-button-link"> Hotels </Link>
                                </li>
                                <li>
                                    <Link className="site-button-link" to={'/place'}>Places</Link>
                                </li>
                                <li><Link className="site-button-link" to={'/packages'}>Packages</Link></li>
                            </ul>
                        </div>
                        <div className="dlab-topbar-right top-login">
                            {!loggedIn &&
                                <ul>
                                    <li><Link to={'/login'} className="site-button-link">Login</Link></li>
                                    <li><Link to={'/register'} className="site-button-link">Register</Link></li>
                                </ul>
                            }
                            {loggedIn &&
                                <ul>
                                    {user.role==='admin' &&
                                     <li><Link to={'/admin/rooms-manager'} className="site-button-link">Admin Room</Link></li>
                                    }
                                    <li><Link to={'/profile'} className="site-button-link">{user.fullName}</Link></li>
                                    <li><Link to={'/'} onClick={() => handleLogout()} className="site-button-link">Logout</Link></li>
                                </ul>
                            }

                        </div>
                    </div>
                </div>
            </div>

            <div className="sticky-header navbar-expand-lg main-bar-wraper">
                <div className="main-bar clearfix onepage">
                    <div className="container-fluid clearfix">
                        <div className="logo-header mostion">
                            <Link to={'/index-2'} ><img src={require('./../../images/logo-2.png')} alt="" /></Link>
                        </div>

                        <button className="navbar-toggler collapsed navicon justify-content-end" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                            <span></span>
                            <span></span>
                            <span></span>
                        </button>

                        <div className="extra-nav">
                            <div className="extra-cell">
                                {/* <button id="quik-search-btn" type="button" className="site-button outline black"><i className="fa fa-search"></i></button> */}
                                <Link to={"/hotelbooking"} className="site-button outline m-l5">Book Now</Link>
                            </div>
                        </div>

                        <div className="dlab-quik-search bg-primary search-style-1">
                            <form action="#">
                                <input name="search" type="text" className="form-control" placeholder="Type to search" />
                                <span id="quik-search-remove"><i className="ti-close"></i></span>
                            </form>
                        </div>

                        <div className="header-nav navbar-collapse collapse navbar myNavbar justify-content-center" id="navbarNavDropdown">
                            <ul className="nav navbar-nav">
                                <li><Link to={''}>Home <i className="fa fa-chevron-down"></i></Link>
                                    <ul className="sub-menu">
                                        <li><Link to={'/'} className="dez-page">Home 1</Link></li>
                                        <li><Link to={'/index-2'} className="dez-page">Home 2 <span className="new-page menu-new">New</span></Link></li>
                                    </ul>
                                </li>
                                <li className="active"></li>
                                <li><Link to={''}> Pages <i className="fa fa-chevron-down"></i></Link>
                                    <ul className="sub-menu">
                                        <li><Link to='/about' className="dez-page">About Us</Link></li>
                                        <li><Link to={'/listing'} className="dez-page">Listing <span className="new-page menu-new">New</span></Link></li>
                                        <li><Link to={'/hotel'}>Hotels</Link></li>
                                        <li><Link to={'/booking'}>Booking Details</Link></li>
                                        <li><Link to={'/place'}>Places</Link></li>
                                        <li><Link to={'/packages'}>Packages</Link></li>
                                        <li><Link to={'/error'} className="dez-page">Error 404</Link></li>
                                        <li><Link to={'/login'} className="dez-page">Login</Link></li>
                                        <li><Link to={'/register'} className="dez-page">Register</Link></li>
                                        <li><Link to={'/register2'} className="dez-page">Register <span className="new-page menu-new">New</span></Link></li>
                                    </ul>
                                </li>
                                <li><Link to={''}>Hotels <i className="fa fa-chevron-down"></i></Link>
                                    <ul className="sub-menu">
                                        <li><Link to={'/hotel'} className="dez-page">Hotel</Link></li>
                                    </ul>
                                </li>
                                <li><Link to={''}>Blog <i className="fa fa-chevron-down"></i></Link>
                                    <ul className="sub-menu">
                                        <li><Link to={'/blogclassic'} className="dez-page">Classic</Link></li>
                                        <li><Link to={'/blogclassicsidebar'} className="dez-page">Classic Sidebar</Link></li>
                                        <li><Link to={'/bloggrid'} className="dez-page">Detailed Grid</Link></li>
                                        <li><Link to={'/bloggridsidebar'} className="dez-page">Detailed Grid Sidebar</Link></li>
                                        <li><Link to={'/blogleftsidebar'} className="dez-page">Left Image Sidebar</Link></li>
                                        <li><Link to={'/blogdetails'} className="dez-page">Blog Details</Link></li>
                                    </ul>
                                </li>
                                <li><Link to={''}>Our Portfolio <i className="fa fa-chevron-down"></i></Link>
                                    <ul className="sub-menu">
                                        <li><Link to={'/portfolio2'} className="dez-page">Portfolio Grid 2 </Link></li>
                                        {/*<li><Link to={'portfolio2'} className="dez-page">Portfolio Grid 3 </Link></li>
												<li><Link to={'portfolio2'} className="dez-page">Portfolio Grid 4 </Link></li>*/}
                                    </ul>
                                </li>
                                <li><Link to={'/contact'} className="dez-page">Contact Us</Link></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    )

}
export default Header2;