import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory } from 'vue-router';

import Profile from './pages/Profile.vue';
import Home from './pages/Homepage.vue';
import Authorization from './pages/Authorization.vue';
import Registration from './pages/Registration.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/profile', component: Profile },
    { path: '/authorize', component: Authorization },
    { path: '/register', component: Registration }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

const app = createApp(App);
app.use(router);
app.mount('#app');
