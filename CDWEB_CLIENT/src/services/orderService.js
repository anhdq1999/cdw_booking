import axiosClient from "api/axiosClient";

export const orderService = {
    create,
    getAll
}
function getAll(){
    const url = '/api/v1/orders/';
    return axiosClient.get(url)
}
function create(data) {
    const url = '/api/v1/orders/';
    return axiosClient.post(url, data)
}