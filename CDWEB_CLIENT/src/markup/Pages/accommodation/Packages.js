import {roomActions} from 'actions';
import {Image, Transformation} from 'cloudinary-react';
import React, {useEffect, useMemo, useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {Link} from 'react-router-dom';
import {roomsService} from 'services';
import Paginator from "react-hooks-paginator";
import {useForm} from "react-hook-form";

const bg3 = require('../../../images/banner/bnr1.jpg');

function Packages(props) {
    const dispatch = useDispatch();
    const pageLimit = useSelector(state => state.roomReducer.pageLimit);
    const rooms = useSelector(state => state.roomReducer.items)
    const [offset, setOffset] = useState(0);
    const [limit,setLimit]=useState(pageLimit)
    const [currentPage, setCurrentPage] = useState(1);
    const [currentData, setCurrentData] = useState([]);

    const {register, handleSubmit} = useForm();

    const handleSubmitPageLimit = (data) => {
        const maxPageItem = parseInt(data.limit, 10);
        //destroy pagination
        setLimit(null);
        dispatch(roomActions.setPageLimit(maxPageItem))
    }
    useEffect(()=>{
        //re create pagination
        setLimit(pageLimit)
    },[pageLimit])
    useEffect(() => {
        dispatch(roomActions.getAll())
    }, [dispatch])
    useEffect(() => {
        setCurrentData(rooms.slice(offset, offset + pageLimit));
    }, [offset, rooms, pageLimit]);


    return (<div>
            <div className="dlab-bnr-inr overlay-black-middle"
                 style={{backgroundImage: "url(" + bg3 + ")", backgroundSize: 'cover'}}>
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
                    <div className="text-center mb-5">
                        <form onSubmit={handleSubmit(handleSubmitPageLimit)}>
                            <label className="mr-1">Max Item On Page: </label>
                            <input type="number" {...register('limit')}/>
                            <button type="submit"> Go</button>
                        </form>
                    </div>

                    <div className="row packages">

                        {currentData && currentData.map((item, index) => (
                            <div className="col-md-6 col-xl-3 col-sm-6 m-b20" key={index}>
                                <div className="dlab-box">
                                    <div className="dlab-media">
                                        <Link to={`/hotelbooking/${item.id}`}>
                                            <Image cloudName="dmtwoqysj" publicId={item.images[0].url}>
                                                <Transformation width="400" height="250" gravity="south"
                                                                crop="fill"/>
                                            </Image>
                                        </Link>
                                    </div>
                                    <div className="dlab-info p-a15 border-1">
                                        <h4 className="dlab-title m-t0"><a
                                            href="booking-details.html">{item.name}</a></h4>
                                        <span className="location">{item.address.ward.pathWithType}</span>
                                        <div className="package-content">
                                            <ul className="package-meta">
                                                <li><span
                                                    className="fa fa-comment"></span> Reviews: {item.numRating}
                                                </li>
                                                <li><span className="fa fa-star"></span> Star: {item.rating} </li>
                                            </ul>
                                            <div className="clearfix">
                                                    <span
                                                        className="package-price pull-left text-primary">{roomsService.formatPrice(item.price)}</span>
                                                <Link to={`/hotelbooking/${item.id}`} className="site-button pull-right w-100">View
                                                    details</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>))}
                    </div>
                    {limit&&
                        <Paginator
                            totalRecords={rooms.length}
                            pageLimit={limit}
                            pageNeighbours={2}
                            setOffset={setOffset}
                            currentPage={currentPage}
                            setCurrentPage={setCurrentPage}
                        />
                    }
                </div>
            </div>
        </div>
    )
}

export default Packages;