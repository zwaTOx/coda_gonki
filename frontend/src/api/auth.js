import axios from "axios";

const API_BASE_URL = 'http://82.202.138.90:8080/api'

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