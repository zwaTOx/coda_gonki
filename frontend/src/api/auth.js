import axios from "axios";
import { BASE_URL } from "./url.js";

const api = axios.create({
    baseURL: BASE_URL,
    headers: {
        'Content-Type': 'application/json'
    }
})

export const authApi = {
    login: (userData) => api.post('/v1/auth/login', userData),
    register: (userData) => api.post('/v1/auth/register', userData)
}