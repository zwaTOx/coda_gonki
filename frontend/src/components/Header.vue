<script setup>
import HeaderButton from './HeaderButton.vue';
import HeaderProfileBar from './HeaderProfileBar.vue';
import Logo from './Logo.vue';

</script>

<template>
    <div class="header-container">
        <Logo></Logo>
        <div class="button-container">
            <HeaderButton :text="'Начать игру'"></HeaderButton>
            <HeaderButton :text="'Начать игру'"></HeaderButton>
            <HeaderButton :text="'Начать игру'"></HeaderButton>
            <HeaderButton :text="'Начать игру'"></HeaderButton>
            <HeaderButton :text="'Начать игру'"></HeaderButton>
        </div>
        <HeaderProfileBar></HeaderProfileBar>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.header-container {
    position: sticky;
    top: 0;

    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 16px;

    padding: 12px 32px;
    background-color: var(--dark-color);
    color: var(--gray-color);

    font-size: 1rem;
    box-shadow: 2px 2px 2px 1px rgb(0 0 0 / 20%);
}

.button-container {
    display: flex;
    align-items: start;
    gap: 4px;

    width: 100%;
    box-sizing: border-box;
}
</style>
