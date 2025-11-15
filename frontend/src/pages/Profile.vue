<script setup>
import Header from '@/components/Header.vue';
import UserProfile from '@/components/UserProfile.vue';

</script>

<template>
    <div class="wrapper">
        <Header></Header>
        <div class="profile-page-container">
            <div class="profile-container">
                <div class="background-layer">
                    <div class="yellow-ball"></div>
                    <div class="blue-ball"></div>
                </div>
                <div class="content-layer">
                    <UserProfile></UserProfile>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.profile-page-container {
    width: 1012px;
}

.background-layer {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 0;
    pointer-events: none;
}

.content-layer {
    position: relative;
    z-index: 1; 
}

.yellow-ball {
    position: absolute;
    top: -1024px;
    left: -1024px;

    background: radial-gradient(var(--ball-yellow-color), transparent 50%);
    width: 2048px;
    height: 2048px;

    z-index: 0;
}

.blue-ball {
    position: absolute;
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

<style>
.wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    
    background-color: var(--background-color);
    margin: 0 auto;
}
</style>
