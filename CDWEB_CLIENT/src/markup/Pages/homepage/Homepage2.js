import React,{useEffect} from 'react'
import Slider from 'react-animated-slider';
import 'react-animated-slider/build/horizontal.css';
import Slick2 from '../Slick2';
import HomeBlog from '../../Element/HomeBlog';
import { Link } from 'react-router-dom';
import {useDispatch, useSelector} from "react-redux";
import {addressActions} from "../../../actions";

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

const bg1 = require('../../../images/background/bg1.jpg');

function Homepage2(props) {

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
    const settings = {
        dots: false,
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 1,
    };

    return (
        <div>
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
            {/*<div className="section-full book-form overlay-black-dark bg-img-fix p-t30 p-b10 mid" style={{ backgroundImage: "url(" + bg1 + ")" }}>*/}
            {/*    <div className="container">*/}
            {/*        <form className="row">*/}
            {/*            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">*/}
            {/*                <label>Country</label>*/}
            {/*                <select className="form-control" readonly>*/}
            {/*                    <option>Việt Nam</option>*/}
            {/*                </select>*/}
            {/*            </div>*/}
            {/*            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">*/}
            {/*                <label>Province</label>*/}
            {/*                <select className="form-control" onChange={handleProvinceChange}>*/}
            {/*                    {provinces.length > 0 &&*/}
            {/*                        <option checked>Chọn tỉnh</option>*/}
            {/*                    }*/}
            {/*                    {(provinces.length > 0 &&*/}
            {/*                            provinces.map((item, index) => (*/}
            {/*                                <option key={item.id} value={item.id}>{item.nameWithType}</option>*/}
            {/*                            ))) ||*/}
            {/*                        <option >Đang load dữ liệu</option>*/}
            {/*                    }*/}
            {/*                </select>*/}
            {/*            </div>*/}
            {/*            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">*/}
            {/*                <label>District</label>*/}
            {/*                <select className="form-control" onChange={handleDistrictChange}>*/}
            {/*                    {districts.length > 0 &&*/}
            {/*                        <option checked> Chọn Quận/huyện</option>*/}
            {/*                    }*/}
            {/*                    {(districts.length > 0 &&*/}
            {/*                            districts.map((item, index) => (*/}
            {/*                                <option key={item.id} value={item.id}>{item.nameWithType}</option>*/}
            {/*                            ))) ||*/}
            {/*                        <option>Vui lòng chọn tỉnh</option>}*/}
            {/*                </select>*/}
            {/*            </div>*/}
            {/*            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">*/}
            {/*                <label>Ward</label>*/}
            {/*                <select className="form-control">*/}
            {/*                    {wards.length > 0 &&*/}
            {/*                        <option checked> Chọn Phường/Xã</option>*/}
            {/*                    }*/}
            {/*                    {(wards.length > 0 &&*/}
            {/*                            wards.map((item, index) => (*/}
            {/*                                <option value={item.id}>{item.nameWithType}</option>*/}
            {/*                            ))) ||*/}
            {/*                        <option>Vui lòng chọn huyện</option>*/}
            {/*                    }*/}
            {/*                </select>*/}
            {/*            </div>*/}
            {/*            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">*/}
            {/*                <label>Date</label>*/}
            {/*                <input type='text' className="form-control" id='datetimepicker4' />*/}
            {/*            </div>*/}
            {/*            <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">*/}
            {/*                <label>Find</label>*/}
            {/*                <Link to={'/accommodation'} className="site-button btn-block">SEARCH</Link>*/}
            {/*            </div>*/}
            {/*        </form>*/}
            {/*    </div>*/}
            {/*</div>*/}

            <div className="content-block" id="page_content">
                {/*<Tab2 />*/}

                <div className="section-full bg-white content-inner-2">
                    <div className="container">
                        <div className="section-head style1 text-black text-center">
                            <h2>Popular Destinations</h2>
                            <div className="dlab-separator bg-primary"></div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
                        </div>
                        <div className="row">
                            <div className="col-lg-4 col-md-6 col-sm-12">
                                <div className="featured-bx style2">
                                    <div className="featured-media">
                                        <img src={require('../../../images/featured/pic1.jpg')} alt="" />
                                        <div className="featured-tag">5 Days</div>
                                    </div>
                                    <div className="featured-content text-white">
                                        <div>
                                            <h2 className="title"><Link to={'packages'}>Westorn Europe</Link></h2>
                                            <p>It is a long established fact that a reader will be distracted by the readable content.</p>
                                            <Link to={'packages'} className="site-button outline white">View All Tours</Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-4 col-md-6 col-sm-12">
                                <div className="featured-bx style2">
                                    <div className="featured-media">
                                        <img src={require('../../../images/featured/pic2.jpg')} alt="" />
                                        <div className="featured-tag">7 Days</div>
                                    </div>
                                    <div className="featured-content text-white">
                                        <div>
                                            <h2 className="title"><Link to={'packages'}>Philippines</Link></h2>
                                            <p>It is a long established fact that a reader will be distracted by the readable content.</p>
                                            <Link to={'packages'} className="site-button outline white">View All Tours</Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-4 col-md-6 col-sm-12">
                                <div className="featured-bx style2">
                                    <div className="featured-media">
                                        <img src={require('../../../images/featured/pic3.jpg')} alt="" />
                                        <div className="featured-tag">3 Days</div>
                                    </div>
                                    <div className="featured-content text-white">
                                        <div>
                                            <h2 className="title"><Link to={'packages'}>Friendly Santorini</Link></h2>
                                            <p>It is a long established fact that a reader will be distracted by the readable content.</p>
                                            <Link to={'packages'} className="site-button outline white">View All Tours</Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-6 col-sm-12">
                                <div className="featured-bx style2">
                                    <div className="featured-media">
                                        <img src={require('../../../images/featured/pic4.jpg')} alt="" />
                                        <div className="featured-tag">2 Days</div>
                                    </div>
                                    <div className="featured-content text-white">
                                        <div>
                                            <h2 className="title"><Link to={'packages'}>Australia</Link></h2>
                                            <p>It is a long established fact that a reader will be distracted by the readable content.</p>
                                            <Link to={'packages'} className="site-button outline white">View All Tours</Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6 col-md-12 col-sm-12">
                                <div className="featured-bx style2">
                                    <div className="featured-media">
                                        <img src={require('../../../images/featured/pic5.jpg')} alt="" />
                                        <div className="featured-tag">6 Days</div>
                                    </div>
                                    <div className="featured-content text-white">
                                        <div>
                                            <h2 className="title"><Link to={'packages'}>South America </Link></h2>
                                            <p>It is a long established fact that a reader will be distracted by the readable content.</p>
                                            <Link to={'packages'} className="site-button outline white">View All Tours</Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <div className="section-full content-inner bg-img-fix overlay-black-middle" style={{ backgroundImage: "url(" + bg1 + ")" }}>
                    <div className="container">
                        <div className="video-banner-box">
                            <div>
                                <Link to={'https://www.youtube.com/watch?v=Dj6CKxQue7U'} className="popup-youtube video play-btn"><i className="fa fa-play"></i></Link>
                                <h2 className="title">Traveling Highlight</h2>
                                <h4 className="sub-title">Your New Traveling Idea</h4>

                            </div>
                        </div>
                    </div>
                </div>

                <div className="section-full content-inner bg-gray">
                    <div className="container">
                        <div className="section-head style1 text-black text-left text-center">
                            <h2>Best Holiday Packages</h2>
                            <div className="dlab-separator bg-primary"></div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.</p>
                        </div>
                        <div className="row">
                            <div className="col-lg-6">
                                <div className="dlab-box packages-bx">
                                    <div className="dlab-media">
                                        <Link to={'listing-details-1'}><img src={require('../../../images/gallery/img5.jpg')} alt="" /></Link>
                                        <span className="tag yellow">Best Seller</span>
                                    </div>
                                    <div className="dlab-info">
                                        <div className="head-title">
                                            <span className="time">2 Days 3 Night</span>
                                            <h4 className="dlab-title"><Link to={'listing-details-1'}>Weekdays in South America</Link></h4>
                                            <span className="location">Peelamedu, Cbe, South America</span>
                                        </div>
                                        <div className="package-content">
                                            <div className="review-bx">
                                                <ul className="rating-star">
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                </ul>
                                                <span>(5 Review)</span>
                                            </div>
                                            <div className="price-bx">
                                                <del className="price-del">$700</del>
                                                <span className="price-main">$550</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div><div className="col-lg-6">
                                <div className="dlab-box packages-bx">
                                    <div className="dlab-media">
                                        <Link to={'listing-details-1'}><img src={require('../../../images/gallery/img2.jpg')} alt="" /></Link>
                                        <span className="tag yellow">Best Seller</span>
                                    </div>
                                    <div className="dlab-info">
                                        <div className="head-title">
                                            <span className="time">8 Days 7 Night</span>
                                            <h4 className="dlab-title"><Link to={'listing-details-1'}>Weekdays in India</Link></h4>
                                            <span className="location">Peelamedu, Cbe, India</span>
                                        </div>
                                        <div className="package-content">
                                            <div className="review-bx">
                                                <ul className="rating-star">
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                </ul>
                                                <span>(4 Review)</span>
                                            </div>
                                            <div className="price-bx">
                                                <del className="price-del">$457</del>
                                                <span className="price-main">$350</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6">
                                <div className="dlab-box packages-bx">
                                    <div className="dlab-media">
                                        <Link to={'listing-details-1'}><img src={require('../../../images/gallery/img3.jpg')} alt="" /></Link>
                                        <span className="tag yellow">Best Seller</span>
                                    </div>
                                    <div className="dlab-info">
                                        <div className="head-title">
                                            <span className="time">8 Days 7 Night</span>
                                            <h4 className="dlab-title"><Link to={'listing-details-1'}>Weekdays in Australia</Link></h4>
                                            <span className="location">Peelamedu, Cbe, Australia</span>
                                        </div>
                                        <div className="package-content">
                                            <div className="review-bx">
                                                <ul className="rating-star">
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                </ul>
                                                <span>(2 Review)</span>
                                            </div>
                                            <div className="price-bx">
                                                <del className="price-del">$250</del>
                                                <span className="price-main">$200</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="col-lg-6">
                                <div className="dlab-box packages-bx">
                                    <div className="dlab-media">
                                        <Link to={'listing-details-1'}><img src={require('../../../images/gallery/img4.jpg')} alt="" /></Link>
                                        <span className="tag yellow">Best Seller</span>
                                    </div>
                                    <div className="dlab-info">
                                        <div className="head-title">
                                            <span className="time">8 Days 7 Night</span>
                                            <h4 className="dlab-title"><Link to={'listing-details-1'}>Weekdays in Philippines</Link></h4>
                                            <span className="location">Weekdays in Philippines</span>
                                        </div>
                                        <div className="package-content">
                                            <div className="review-bx">
                                                <ul className="rating-star">
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                    <li><i className="fa fa-star"></i></li>
                                                </ul>
                                                <span>(8 Review)</span>
                                            </div>
                                            <div className="price-bx">
                                                <del className="price-del">$840</del>
                                                <span className="price-main">$710</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <Slick2 />
                <HomeBlog />




            </div>

            {/*<Footer />*/}
        </div>
    )

}
export default Homepage2;