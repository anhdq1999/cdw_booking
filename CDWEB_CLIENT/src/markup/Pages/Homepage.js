import { addressActions } from 'actions';
import React, { useEffect } from 'react';
import Slider from 'react-animated-slider';
import 'react-animated-slider/build/horizontal.css';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import TopPlaces from './../Element/TopPlaces';
import Footer from './../Layout/Footer';
import Header from './../Layout/Header';
import Slick from './Slick';


const content = [
    {
        title: 'Đặt Homstay không khó nhờ có booking ',
        button: 'Book Now',
        image: require('images/main-slider/slide5.jpg'),
    },
    {
        image: require('images/main-slider/slide1.png'),
    },
    {
        title: '',
        button: 'Discover',
        image: require('images/main-slider/slide3.jpg'),
    },
    {
        title: '',
        button: 'Discover',
        image: require('images/main-slider/slide4.jpg'),
    }
];

const bg1 = require('images/background/bg1.jpg');
// const bg3 = require('images/background/bg3.jpg');

function Homepage(props) {
    const provinces = useSelector(state => state.addressReducer.provinces)
    const districts = useSelector(state => state.addressReducer.districts)
    const wards = useSelector(state => state.addressReducer.wards)
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(addressActions.getAllProvince())
    }, [dispatch])
    const handleProvinceChange = (e) => {
        const { value } = e.target;
        dispatch(addressActions.getAllDistrict(value))
    }
    const handleDistrictChange = (e) => {
        const { value } = e.target;
        dispatch(addressActions.getAllWard(value))
    }
    return (
        <div>
            <Header />
            <div className="page-content">
                <Slider className="slider-wrapper" infinite autoplay>
                    {content.map((item, index) => (
                        <div
                            key={index}
                            className="slider-content"
                            style={{ background: `url('${item.image}') no-repeat center center` }}
                        >
                            {/*<div className="inner">*/}
                            {/*    <h1>{item.title}</h1>*/}
                            {/*    <p>{item.description}</p>*/}
                            {/*    <Link to={'/place'} className="site-button">Book Now</Link>*/}
                            {/*</div>*/}
                        </div>
                    ))}
                </Slider>

                <div className="section-full book-form overlay-black-dark bg-img-fix p-t30 p-b10 mid" style={{ backgroundImage: "url(" + bg1 + ")" }}>
                    <div className="container">
                        <form className="row">
                            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                                <label>Country</label>
                                <select className="form-control" readonly>
                                    <option>Việt Nam</option>
                                </select>
                            </div>
                            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                                <label>Province</label>
                                <select className="form-control" onChange={handleProvinceChange}>
                                    {provinces.length > 0 &&
                                        <option checked>Chọn tỉnh</option>
                                    }
                                    {(provinces.length > 0 &&
                                        provinces.map((item, index) => (
                                            <option key={item._id} value={item.code}>{item.name_with_type}</option>
                                        ))) ||
                                        <option >Đang load dữ liệu</option>
                                    }
                                </select>
                            </div>
                            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                                <label>District</label>
                                <select className="form-control" onChange={handleDistrictChange}>
                                    {districts.length > 0 &&
                                        <option checked> Chọn Quận/huyện</option>
                                    }
                                    {(districts.length > 0 &&
                                        districts.map((item, index) => (
                                            <option key={item._id} value={item.code}>{item.name_with_type}</option>
                                        ))) ||
                                        <option>Vui lòng chọn tỉnh</option>}
                                </select>
                            </div>
                            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                                <label>Ward</label>
                                <select className="form-control">
                                    {wards.length > 0 &&
                                        <option checked> Chọn Phường/Xã</option>
                                    }
                                    {(wards.length > 0 &&
                                        wards.map((item, index) => (
                                            <option value={item.code}>{item.name_with_type}</option>
                                        ))) ||
                                        <option>Vui lòng chọn huyện</option>
                                    }
                                </select>
                            </div>
                            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                                <label>Date</label>
                                <input type='text' className="form-control" id='datetimepicker4' />
                            </div>
                            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                                <label>Find</label>
                                <Link to={'/place'} className="site-button btn-block">SEARCH</Link>
                            </div>
                        </form>
                    </div>
                </div>
                <TopPlaces />
                <Slick />

                {/* <div className="section-full bg-white content-inner-2 bgeffect overlay-black-middle" style={{ backgroundImage: "url(" + bg3 + ")", backgroundSize: 'cover' }}>
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-6 col-md-12">
                                <div className="add-area">
                                    <h3>1000 $ for person - 6 nights</h3>
                                    <h2>Discount <span className="text-primary">10-30%</span> Off</h2>
                                    <p>If you’re looking for a truly memorable family break here you find the lowest price on the right hotel for you. It's indescribable. Stay up to date and check out the deals for these trending destinations.</p>
                                    <Link to='' className="site-button white">See Promotion Tours</Link>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-6"></div>
                        </div>
                    </div>
                </div> */}


                {/* <div className="section-full bg-white content-inner dlab-about-1 promotions">
                    <div className="container">
                        <div className="section-head text-black text-center">
                            <h2 className="text-uppercase m-b0">PACKAGES</h2>
                            <p className="font-18">BEST TRAVEL PACKAGES </p>
                        </div>
                        <div className="row packages">
                            <div className="col-lg-6 col-xl-3 col-sm-6 col-md-6 m-b30">
                                <div className="dlab-box">
                                    <div className="dlab-media">
                                        <Link><img src={require('images/gallery/img4.jpg')} alt="" /></Link>
                                    </div>
                                    <div className="dlab-info p-a15 border-1">
                                        <h4 className="dlab-title m-t0"><Link href="packages.html">Weekdays in Australia</Link></h4>
                                        <span className="location">Peelamedu, Cbe, Australia</span>
                                        <div className="package-content">
                                            <ul className="package-meta">
                                                <li><span className="fa fa-calendar"></span> No of Days: 2 </li>
                                                <li> <span className="fa fa-user"></span> People: 1 </li>
                                            </ul>
                                            <div className="clearfix">
                                                <span className="package-price pull-left text-primary">$323</span>
                                                <Link href="booking-details.html" className="site-button pull-right">View details</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6 col-xl-3 col-sm-6 col-md-6 m-b30">
                                <div className="dlab-box">
                                    <div className="dlab-media">
                                        <Link><img src={require('images/gallery/img3.jpg')} alt="" /></Link>
                                    </div>
                                    <div className="dlab-info p-a15 border-1">
                                        <h4 className="dlab-title m-t0"><Link href="packages.html">Weekdays in India</Link></h4>
                                        <span className="location">Peelamedu, Cbe, India</span>
                                        <div className="package-content">
                                            <ul className="package-meta">
                                                <li><span className="fa fa-calendar"></span> No of Days: 2 </li>
                                                <li> <span className="fa fa-user"></span> People: 1 </li>
                                            </ul>
                                            <div className="clearfix">
                                                <span className="package-price pull-left text-primary">$323</span>
                                                <Link href="booking-details.html" className="site-button pull-right">View details</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6 col-xl-3 col-sm-6 col-md-6 m-b30">
                                <div className="dlab-box">
                                    <div className="dlab-media">
                                        <Link><img src={require('images/gallery/img5.jpg')} alt="" /></Link>
                                    </div>
                                    <div className="dlab-info p-a15 border-1">
                                        <h4 className="dlab-title m-t0"><Link href="packages.html">Weekdays in South America</Link></h4>
                                        <span className="location">Peelamedu, Cbe, South America</span>
                                        <div className="package-content">
                                            <ul className="package-meta">
                                                <li><span className="fa fa-calendar"></span> No of Days: 2 </li>
                                                <li> <span className="fa fa-user"></span> People: 1 </li>
                                            </ul>
                                            <div className="clearfix">
                                                <span className="package-price pull-left text-primary">$323</span>
                                                <Link href="booking-details.html" className="site-button pull-right">View details</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6 col-xl-3 col-sm-6 col-md-6 m-b30">
                                <div className="dlab-box">
                                    <div className="dlab-media">
                                        <Link><img src={require('images/gallery/img6.jpg')} alt="" /></Link>
                                    </div>
                                    <div className="dlab-info p-a15 border-1">
                                        <h4 className="dlab-title m-t0"><Link href="packages.html">Weekdays in Philippines</Link></h4>
                                        <span className="location">Peelamedu, Cbe, Philippines</span>
                                        <div className="package-content">
                                            <ul className="package-meta">
                                                <li><span className="fa fa-calendar"></span> No of Days: 2 </li>
                                                <li> <span className="fa fa-user"></span> People: 1 </li>
                                            </ul>
                                            <div className="clearfix">
                                                <span className="package-price pull-left text-primary">$323</span>
                                                <Link href="booking-details.html" className="site-button pull-right">View details</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> */}
            </div>
            <Footer />
        </div>
    )

}
export default Homepage;