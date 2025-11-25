<<<<<<< HEAD
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
=======
<template>
    <header class="headerWrapper">
        <div class="header">
            <div class="header__logo">
                <div class="header__logo--title" :class="{nomode: !mode}">
                    {{ mode === '' ? 'Codegonks' : `CODE: ` }}
                </div>
                <div class="header__logo--mode">{{ `${mode}` }}</div>
            </div>
            <div class="header__profile">
                <div class="header__profile--icon icon">{{ initials }}</div>
                <div class="header__profile--info">
                    <div class="header__profile--info--name">Константин Денисов</div>
                    <div class="header__profile--info--lvl">{{ `${lvl} уровень (${exp})` }}</div>
                </div>
            </div>
        </div>
    </header>
</template>

<script>
export default {
    data() {
        return {
            mode: '',
            lvl: 2,
            exp: 240,
            name: 'Константин Денисов',
            initials: ''
        }
    },
    methods: {
        getInitials() {
            this.initials = this.name.split(' ').map(name => name[0]).join('')
        }
    },
    mounted() {
        this.getInitials()
    }
}
</script>
>>>>>>> e2704a3536e240f98eae0518fdda14260747537e
