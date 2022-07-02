import { roomActions } from 'actions';
import { Image, Transformation } from 'cloudinary-react';
import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { roomsService } from 'services';
import Footer from './../Layout/Footer';
import Header2 from './../Layout/Header2';

const bg3 = require('./../../images/banner/bnr1.jpg');
function Packages(props) {
    const province = props.match.params.province;
    const dispatch = useDispatch();
    const rooms = useSelector(state => state.roomReducer.itemsByProvince)
    useEffect(() => {
        dispatch(roomActions.getByProvince(province))
    }, [dispatch, province])
    return (
        <div>
            <Header2 />
            <div className="dlab-bnr-inr overlay-black-middle" style={{ backgroundImage: "url(" + bg3 + ")", backgroundSize: 'cover' }}>
                <div className="container">
                    <div className="dlab-bnr-inr-entry">
                        <h1 className="text-white">Packages</h1>
                        <div className="breadcrumb-row">
                            <ul className="list-inline">
                                <li><Link>Home</Link></li>
                                <li>Packages</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div className="section-full bg-white content-inner dlab-about-1 promotions">
                <div className="container">
                    <div className="row packages">
                        {rooms && rooms.map((item, index) => (
                            <div className="col-md-6 col-xl-3  col-sm-6 m-b20" key={index}>
                                <div className="dlab-box">
                                    <div className="dlab-media">
                                        <Link to={`/booking/${item._id}`}>
                                            <Image cloudName="dmtwoqysj" publicId={item.image} >
                                                <Transformation width="400" height="250" gravity="south" crop="fill" />
                                            </Image>
                                        </Link>
                                    </div>
                                    <div className="dlab-info p-a15 border-1">
                                        <h4 className="dlab-title m-t0"><a href="booking-details.html">{item.name}</a></h4>
                                        <span className="location">{item.address.district}</span>
                                        <div className="package-content">
                                            <ul className="package-meta">
                                                <li><span className="fa fa-comment"></span> Reviews: {item.numReviews} </li>
                                                <li> <span className="fa fa-star"></span> Star: {item.rating} </li>
                                            </ul>
                                            <div className="clearfix">
                                                <span className="package-price pull-left text-primary">{roomsService.formatPrice(item.price)}</span>
                                                <Link to={'/booking'} className="site-button pull-right w-100">View details</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    )
}
export default Packages;