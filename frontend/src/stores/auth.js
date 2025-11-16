import { defineStore } from "pinia";
import router from '@/router'
import { authApi } from "@/api/auth";

export const authStore = defineStore('auth', () => {
    const signup = async (credentials) => {
        try {
            const response = await authApi.signup(credentials)
            return { success: true, data: response.data }
        } catch (error) {
            return { success: false, error: error}
        }
    }

    return{
        signup
    }
})