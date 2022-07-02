import React from 'react'
import { Modal, ModalBody, ModalFooter, ModalHeader, Button } from "reactstrap";

// const schema = yup.object().shape({

// })
export default function BookNowModal(props) {
    // const { register, handleSubmit, formState: { errors } } = useForm({
    //     resolver: yupResolver(schema)
    // })

    function toggle() {
        return props.toggle()
    }

    return (

        <div>
            <Modal
                className="max-w800"
                isOpen={props.isOpen}
                toggle={() => toggle()}
            >
                <ModalHeader>
                    <h5 className="modal-title" id="exampleModalLabel">Get the Best Holiday Planned by Experts!</h5>
                </ModalHeader>
                <ModalBody>
                    <h5 className="text-center">Enter your contact details and we will plan the best holiday suiting all your requirements.</h5>
                    <form className="row">
                        <div className="col-md-6 col-lg-6 col-xl-6 col-sm-6 col-6">
                            <div className="form-group">
                                <div className="input-group">
                                    <input  required="" className="form-control" placeholder="" type="date" />
                                </div>
                                <span className="font-12">From</span>
                            </div>
                        </div>
                        <div className="col-md-6 col-lg-6 col-xl-6 col-sm-6 col-6">
                            <div className="form-group">
                                <div className="input-group">
                                    <input  required="" className="form-control" placeholder="" type="date" />
                                </div>
                                <span className="font-12">To</span>

                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="form-group">
                                <div className="input-group">
                                    <input required="" className="form-control" placeholder="Your Name" type="text" />
                                </div>
                            </div>
                        </div>
                        <div className="col-md-6">
                            <div className="form-group">
                                <div className="input-group">
                                    <input  required="" className="form-control" placeholder="Your Phone Number" type="text" />
                                </div>
                            </div>
                        </div>
                        <div className="col-md-4">
                            <div className="quantity btn-quantity">
                                <input id="demo_vertical2" className="form-control" type="text" name="demo_vertical2" />
                                <span className="font-12">Adult (12yrs +)</span>
                            </div>
                        </div>
                        <div className="col-md-4">
                            <div className="quantity btn-quantity">
                                <input id="demo_vertical2" className="form-control" type="text" name="demo_vertical2" />
                                <span className="font-12">Child (2-12yrs)</span>
                            </div>
                        </div>
                        <div className="col-md-4">
                            <div className="quantity btn-quantity">
                                <input id="demo_vertical2" className="form-control" type="text" name="demo_vertical2" />
                                <span className="font-12">Infant (0-2yrs)</span>
                            </div>
                        </div>
                    </form>
                </ModalBody>
                <ModalFooter>
                    <button type="submit" className="site-button">Submit</button>
                    <Button
                        color="primary" onClick={() => toggle()}>
                        Cancel
                    </Button>

                </ModalFooter>
            </Modal>
        </div>
    );
}