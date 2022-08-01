import React, { useEffect } from "react";
import { useForm } from "react-hook-form";
import { useDispatch, useSelector } from "react-redux";
import { Link, Redirect } from "react-router-dom";
import { userService } from "services";

const bg3 = require('images/banner/bnr1.jpg');

function Order(props) {
    const { register, setValue, handleSubmit } = useForm();
    const dispatch = useDispatch();

    const user = userService.getCurrentUser()

    const onSubmit = (data) => {
    }

    return (
                <>
                    <div className="dlab-bnr-inr overlay-black-middle" style={{ backgroundImage: "url(" + bg3 + ")", backgroundSize: 'cover' }}>
                        <div className="container">
                            <div className="dlab-bnr-inr-entry">
                                <h1 className="text-white">Order</h1>
                                <div className="breadcrumb-row">
                                    <ul className="list-inline">
                                        <li><Link>Home</Link></li>
                                        <li>Order</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="section-full bg-white content-inner dlab-about-1 promotions">

                        <div className="container">
                            <form onSubmit={handleSubmit(onSubmit)}>
                                <div className="row">
                                    <div className="col-3 bg-info text-black">
                                        <div className="m-2">
                                            <div className="form-group">
                                                <label>Childs</label>
                                                <input className="form-control"  placeholder="enter child" {...register("child")} type="number" />
                                            </div>
                                            <div className="form-group">
                                                <label>Adults</label>
                                                <input className="form-control"  placeholder="Ebter adults" {...register("adults")} type="number" />
                                            </div>
                                            <div className="form-group">
                                                <label>Infants</label>
                                                <input className="form-control"  placeholder="Enter infants" {...register("infants")} type="number" />
                                            </div>
                                            <div className="form-group">
                                                <label>Check in</label>
                                                <input className="form-control" placeholder="Enter checkInDate" {...register("dates.checkInDate")} type="date" />
                                            </div>
                                            <div className="form-group">
                                                <label>Check out</label>
                                                <input className="form-control" placeholder="Enter checkOutDate" {...register("dates.checkOutDate")} type="date" />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col-9 round border bg-light">
                                        <div className="text-left m-5">
                                            <button className="btn bg-primary"><i className="fa fa-arrow-left"></i></button>

                                            <h5 className="mt-3 mb-3"> Enter this fill to completed ordering</h5>
                                            <div className="form-group row">
                                                <label className="col-sm-3 col-form-label">Full Name:</label>
                                                <div className="col-sm-6">
                                                    <input className="form-control" {...register("customerName")} placeholder="Enter your Full Name" type="text" />
                                                </div>
                                            </div>
                                            <div className="form-group row">
                                                <label className="col-sm-3 col-form-label">Phone:</label>
                                                <div className="col-sm-6">
                                                    <input className="form-control" {...register("customerPhone")} placeholder="Enter your number" type="text" />
                                                </div>
                                            </div>

                                            <div className="form-group row">
                                                <label className="col-sm-3 col-form-label">Email:</label>
                                                <div className="col-sm-6">
                                                    <input className="form-control"  placeholder="Enter your email" type="text" />
                                                </div>
                                            </div>
                                            <div className="form-group row">
                                                <label className="col-sm-3 col-form-label">Notes:</label>
                                                <div className="col-sm-6">
                                                    <input className="form-control" {...register("notes")} placeholder="Enter your note" type="text" />
                                                </div>
                                            </div>
                                            <div className="form-group row">
                                                <label className="col-sm-3 col-form-label">Room Name</label>
                                                <div className="col-sm-6">
                                                    <input className="form-control" readOnly  type="text" />
                                                </div>
                                            </div>
                                            <div className="form-group row">
                                                <label className="col-sm-3 col-form-label">Total Price</label>
                                                <div className="col-sm-6">
                                                    <input className="form-control" readOnly {...register("totalPrice")} type="text" />
                                                </div>
                                            </div>

                                            <div className="text-center">
                                                <button className="btn bg-green"> Create</button>
                                                <button className="btn bg-red"> Cancel</button>
                                            </div>
                                        </div>


                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                </>


    )

}

export default Order;