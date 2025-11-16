import axios from "axios";

const API_BASE_URL = 'http://82.202.138.90:3080/api'

const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json'
    }
})

export const authApi = {
    signup: (credentials) => api.post('/v1/users/signup', credentials)
}