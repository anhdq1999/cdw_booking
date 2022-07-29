import {addressActions, roomActions} from 'actions';
import {Image, Transformation} from 'cloudinary-react';
import React, {useEffect, useMemo, useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {Link} from 'react-router-dom';
import {roomsService} from 'services';
import Paginator from "react-hooks-paginator";
import {useForm} from "react-hook-form";
import './toggle.css'

const bg3 = require('../../../images/banner/bnr1.jpg');


function Packages(props) {
    const dispatch = useDispatch();
    const pageLimit = useSelector(state => state.roomReducer.pageLimit);
    const rooms = useSelector(state => state.roomReducer.items)
    const [offset, setOffset] = useState(0);
    const [limit, setLimit] = useState(pageLimit)
    const [data,setData] = useState([])
    const [currentPage, setCurrentPage] = useState(1);
    const [currentData, setCurrentData] = useState([]);
    const {register, handleSubmit} = useForm();

    const handleSubmitPageLimit = (data) => {
        const maxPageItem = parseInt(data.limit, 10);
        if (maxPageItem > 0) {
            if (maxPageItem !== pageLimit) {
                //destroy pagination
                setLimit(null);
                //set new page limit by redux
                dispatch(roomActions.setPageLimit(maxPageItem))
            }
        } else {
            alert("Page limit must to be bigger than 0")
        }
    }


    useEffect(() => {
        //re create pagination
        setLimit(pageLimit)
    }, [pageLimit])
    useEffect(() => {
        dispatch(addressActions.getAllProvince())
        dispatch(roomActions.getAll())
    }, [dispatch])

    useEffect(()=>{
        setData(rooms)
    },[rooms])

    useEffect(() => {
        setCurrentData(data.slice(offset, offset + pageLimit));
    }, [offset, pageLimit,data]);


    const provinces = useSelector(state => state.addressReducer.provinces)
    const districts = useSelector(state => state.addressReducer.districts)
    const wards = useSelector(state => state.addressReducer.wards)
    const handleProvinceChange = (e) => {
        const {value} = e.target;
        dispatch(addressActions.getAllDistrict(value))
    }
    const handleDistrictChange = (e) => {
        const {value} = e.target;
        dispatch(addressActions.getAllWard(value))
    }

    const [nameSearch, setNameSearch] = useState("");

    useEffect(() => {
        let roomsSearch = rooms.filter(room => room.name.toLowerCase().includes(nameSearch.toLowerCase()))
        setData(roomsSearch);
    }, [nameSearch])

    const handleChangeSearch = (e) => {
        const value = e.target.value;
        setNameSearch(value)
    }

    return (
        <div>
            <div className="dlab-bnr-inr overlay-black-middle"
                 style={{backgroundImage: "url(" + bg3 + ")", backgroundSize: 'cover'}}>
                <div className="container">
                    <div className="dlab-bnr-inr-entry">
                        <h1 className="text-white">Packages</h1>
                        <div className="breadcrumb-row">
                            <ul className="list-inline">
                                <li><Link>Home</Link></li>
                                <li>Accommodation</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div className="section-full book-form overlay-black-dark bg-img-fix p-t30 p-b10 mid"
                 style={{backgroundImage: "url(" + bg3 + ")"}}>
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
                                            <option key={item.id} value={item.id}>{item.nameWithType}</option>
                                        ))) ||
                                    <option>Đang load dữ liệu</option>
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
                                            <option key={item.id} value={item.id}>{item.nameWithType}</option>
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
                                            <option value={item.id}>{item.nameWithType}</option>
                                        ))) ||
                                    <option>Vui lòng chọn huyện</option>
                                }
                            </select>
                        </div>
                        <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                            <label>Date</label>
                            <input type='text' className="form-control" id='datetimepicker4'/>
                        </div>
                        <div className="col-md-4 col-sm-6 col-6 col-lg-2 form-group">
                            <label>Find</label>
                            <Link to={'/accommodation'} className="site-button btn-block">SEARCH</Link>
                        </div>
                    </form>
                </div>
            </div>

            <div className="section-full bg-white content-inner dlab-about-1 promotions">
                <div className="container">
                    <div className="row">
                        <div className="col-3 mb-1">
                            <div className="form-group">
                                <label>Search By Name:</label>
                                <input className="form-control"
                                       onChange={handleChangeSearch}
                                />
                            </div>
                        </div>
                        <div className="col-3 mb-1">
                            <div className="form-group">
                                <label>Min Price:</label>
                                <input className="form-control"

                                />
                            </div>
                        </div>
                        <div className="col-3 mb-1">
                            <div className="form-group">
                                <label>Max Price:</label>
                                <input className="form-control"
                                       defaultValue="0"
                                />
                            </div>
                        </div>
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
                                                <Link to={`/hotelbooking/${item.id}`}
                                                      className="site-button pull-right w-100">View
                                                    details</Link>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>))}
                    </div>
                    {limit &&
                        <Paginator
                            totalRecords={data.length}
                            pageLimit={limit}
                            pageNeighbours={2}
                            setOffset={setOffset}
                            currentPage={currentPage}
                            setCurrentPage={setCurrentPage}
                        />
                    }
                    <div className="text-center">
                        <form onSubmit={handleSubmit(handleSubmitPageLimit)}>
                            <label className="mr-1">Max Item On Page: </label>
                            <input className="max-w50 mr-2"
                                   type="number"
                                   defaultValue={pageLimit}
                                   {...register("limit")}
                            />
                            <button className="btn-dark"> Ok</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Packages;