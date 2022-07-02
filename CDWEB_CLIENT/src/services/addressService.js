import axiosClient from "../api/axiosClient";

export const addressService = {
    getAllProvince,
    getDistrictByProvinceCode,
    getWardByDistrictCode,
    getProvinceByCode,
    getDistrictByCode,
    getWardByCode,
}
function getAllProvince() {
    return axiosClient.get('/api/v1/provinces');
}
function getDistrictByProvinceCode(code) {
    return axiosClient.get(`/api/v1/districts/getByProvinceCode/${code}`)
}
function getWardByDistrictCode(code) {
    return axiosClient.get(`/api/v1/wards/getByDistrictCode/${code}`)
}
function getProvinceByCode(code){
    return axiosClient.get(`/api/v1/provinces/${code}`)
}
function getDistrictByCode(code){
    return axiosClient.get(`/api/v1/districts/${code}`)
}function getWardByCode(code){
    return axiosClient.get(`/api/v1/wards/${code}`)
}