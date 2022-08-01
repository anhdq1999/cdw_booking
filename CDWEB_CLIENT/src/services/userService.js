import axiosClient from "../api/axiosClient";

export const userService = {
    login,
    logout,
    register,
    getAll,
    getById,
    getAllDeleted,
    create,
    update,
    deleteUser,
    removeUser,
    restoreUser,
    getCurrentUser,
    forgot
};

function forgot(email){
    const url ='/api/v1/forgot';
    return axiosClient.post(url,email);
}

function login(username, password) {
    const url = "/api/v1/auth/signin";
    return axiosClient.post(url, username, password);
}

function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
}

function getAll() {
    const url = "/api/v1/users";
    return axiosClient.get(url);
}

function getById(id) {
    const url = `/api/v1/users/${id}`;
    return axiosClient.get(url);
}
function getAllDeleted() {
    const url = `/api/v1/users/garbage`;
    return axiosClient.get(url);
}

function register(user) {
    const url = "/api/v1/auth/signup";
    return axiosClient.post(url, user)
}

function create(user) {
    const url = "/api/v1/users";
    return axiosClient.post(url, user)
}
function update(user, newUser) {
    const url = `/api/v1/users/${user._id}`;
    return axiosClient.put(url, newUser);
}
function deleteUser(id) {
    const url = `/api/v1/users/${id}`;
    return axiosClient.delete(url);
}
function removeUser(id) {
    const url = `/ap1/v1/users/remove/${id}`;
    return axiosClient.delete(url);
}
function restoreUser(id) {
    const url = `/api/v1/users/restore/${id}`;
    return axiosClient.post(url);
}
function getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
}

