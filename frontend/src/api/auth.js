import axios from "axios";
import { url } from "./url";

const API_BASE_URL = `http://${url.path}:${url.port}/api`

const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json'
    }
})

export const authApi = {
    login: (userData) => api.post('/v1/auth/login', userData),
    register: (userData) => api.post('/v1/auth/register', userData)
}