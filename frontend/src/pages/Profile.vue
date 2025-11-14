<script setup>
import Header from '@/components/Header.vue';
import UserProfile from '@/components/UserProfile.vue';

</script>

<template>
    <div class="profile-container">
        <div class="yellow-ball"></div>
        <div class="blue-ball"></div>
        <Header></Header>
        <UserProfile></UserProfile>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.yellow-ball {
    position: fixed;
    top: -1024px;
    left: -1024px;

    background: radial-gradient(var(--ball-yellow-color), transparent 50%);
    width: 2048px;
    height: 2048px;

    z-index: 0;
}

.blue-ball {
    position: fixed;
    bottom: -1024px;
    right: -1024px;

    background: radial-gradient(var(--ball-blue-color), transparent 50%);
    width: 2048px;
    height: 2048px;

    z-index: 0;
}

.profile-container {
    position: relative;

    background-color: var(--background-color);
    max-width: 100vw;
    min-height: 100vh;

    overflow-x: hidden;
}
</style>
