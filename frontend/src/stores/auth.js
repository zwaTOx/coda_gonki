import { defineStore } from "pinia";
import router from '@/router'
import { saveToCache } from "@/cache/cache";
import { loadFromCache } from "@/cache/cache";
import { authApi } from "@/api/auth";

export const authStore = defineStore('auth', () => {
    let isAuth = false;

    const login = async (userData) => {
        try {
            const response = await authApi.login(userData)
            saveToCache('is_auth', true);
            isAuth = true;
            return { success: true, data: response.data }
        } catch (error) {
            return { success: false, error: error}
        }
    }

    const register = async (userData) => {
        try {
            const response = await authApi.register(userData)
            return { success: true, data: response.data}
        } catch (error) {
            return { success: false, error: error }
        }
    }

    const initialize = async () => {
        if (loadFromCache('is_auth')) {
            isAuth = true;
            console.log('User is authenticated');
        } else {
            console.log('User is not authenticated', loadFromCache('is_auth'));
        }
    }

    return{
        login,
        register,
        initialize
    }
})