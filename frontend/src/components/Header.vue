<script setup>
import HeaderButton from './HeaderButton.vue';
import HeaderProfileBar from './HeaderProfileBar.vue';
import Logo from './Logo.vue';

</script>

<template>
    <div class="wrapper-case">
        <div class="header-container">
            <Logo></Logo>
            <div class="button-container">
                <HeaderButton :text="'Начать игру'"></HeaderButton>
            </div>
            <HeaderProfileBar></HeaderProfileBar>
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.wrapper-case {
    position: sticky;
    top: 0;
    display: flex;

    background-color: var(--dark-color);
    width: 100%;

    z-index: 2;
    justify-content: center;
    box-shadow: 2px 2px 2px 1px rgb(0 0 0 / 20%);
}

.header-container {
    box-sizing: border-box;
    width: 1024px;

    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 16px;

    padding: 12px 32px;
    background-color: var(--dark-color);
    color: var(--gray-color);

    font-size: 1rem;
}

.button-container {
    display: flex;
    align-items: start;
    gap: 4px;

    width: 100%;
    box-sizing: border-box;
}
</style>
