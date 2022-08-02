import React, {useEffect, useRef} from 'react';

function PayPal() {
    const paypal = useRef();
    const product = {
        description: "Room",
        price: 10
    }
    useEffect(() => {
        window.paypal.Buttons({
            createOrder: (data, actions, err) => {
                return actions.order.create({
                    intent: "CAPTURE",
                    purchase_units: [
                        {
                            description: product.description,
                            amount: {
                                currency_code: "USD",
                                value: product.price,
                            },
                        },
                    ],
                });
            },
            onApprove: async (data, actions) => {
                const order = await actions.order.capture();
                alert("Thanks you!!")
                console.log(order);
            },
            onError: (err) => {
                console.log(err);
            },
        })
            .render(paypal.current);
    }, []);
    return (
        <div>
            <div ref={paypal}></div>
        </div>
    );
}

export default PayPal;