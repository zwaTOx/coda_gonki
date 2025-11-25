<template>
    <div class="loginPageWrapper">
        <div class="loginPage">
            <h1 class="loginPage__title">Вход в аккаунт</h1>
            <form class="loginPage__form" @submit.prevent="handleLogin">
                <input v-model="email" type="text" placeholder="Email" required class="loginPage__form--input" />
                <input v-model="password" type="password" placeholder="Пароль" required class="loginPage__form--input" />
                <button type="submit" class="loginPage__form--button">Войти</button>
            </form>
        </div>
    </div>
</template>

<script>
import { authStore } from '@/stores/auth'

export default {
    data() {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        async handleLogin() {
            const userData = {
                email: this.email,
                password: this.password
            }
            const auth = authStore()
            const response = await auth.login(userData)
            if (response.success) {
                this.$router.push('/profile')
            } else {
                alert('Ошибка входа: ' + response.error)
                console.log(response.error)
            }
        }
    }
}
</script>