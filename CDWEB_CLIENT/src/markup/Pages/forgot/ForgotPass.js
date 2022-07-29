import React from 'react';
import { Link } from 'react-router-dom';
import Slick3 from 'markup/Pages/component-part/Slick3';
import { useDispatch } from 'react-redux';
import * as yup from 'yup';
import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from 'react-hook-form';
import { userActions } from 'actions';

const schemaValidation = yup.object().shape({

    email: yup
    .string()
    .required('Email is required')
    .email('Email must be like 123@mail.com'),
    
})

function ForgotPass(props) {
    const { register, handleSubmit, formState: { errors } } = useForm({ resolver: yupResolver(schemaValidation) });
    const dispatch = useDispatch();

    const onSubmit = (email) => {
        dispatch(userActions.forgot(email))
    }
    return (
        <div>
            <div class="page-content dlab-login font-roboto">
                <div class="container-fluid p-lr0">
                    <div class="row m-lr0 login-form-box">
                        <div class="col-lg-4 p-lr0">
                            <div class="login-form">
                                <div class="logo logo-header">
                                    <Link to={'./'}><img src={require('images/logo-2.png')} alt="" /></Link>
                                </div>
                                <div id="forgot-password" class="tab-pane">
                                    <form class="dlab-form" onSubmit={handleSubmit(onSubmit)}>
                                        <div class="form-head">
                                            <h3 class="form-title m-t0">Find Your<span class="text-primary"> Account</span></h3>
                                            <p class="title-text">Welcome back, please login<br /> to your account</p>
                                        </div>
                                        <div class="form-group-bx">
                                            <div class="form-group input-form">
                                                <label>Email</label>
                                                <input
                                                    required=""
                                                    class="form-control"
                                                    placeholder="info123@example.com"
                                                    {...register("email")}
                                                    type="text" />

                                            </div>

                                            {errors.email &&
                                                <div className="alert-warning">{errors.email.message}</div>
                                            }
                                        </div>
                                        <div class="form-group">
                                            <button class="site-button black m-r10">Submit</button>
                                            <Link to={'/login'} class="site-button outline">Back</Link>
                                        </div>
                                    </form>
                                </div>

                            </div>
                        </div>
                        <div class="col-lg-8 p-lr0">
                            <Slick3 />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )

}
export default ForgotPass;