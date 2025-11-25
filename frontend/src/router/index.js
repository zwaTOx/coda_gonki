import { createRouter, createWebHistory } from 'vue-router'
import profile from '@/views/profile.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/profile',
      name: 'profile',
      component: profile,
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/loginPage.vue'),
    },
  ],
})

export default router
