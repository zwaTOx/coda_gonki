<script setup>
import ProfilePicture from './ProfilePicture.vue';
</script>

<template>
    <div class="header-profile-bar">
        <ProfilePicture :value="'КД'" :size="48"></ProfilePicture>
        <div class="user-info">
            <div class="user-name inter-600">Константин Денисов</div>
            <div class="user-level inter-600">2 уровень (240)</div>
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.header-profile-bar {
    display: flex;
    gap: 8px;

    min-width: max-content;
}

.user-name {
    font-size: 0.8rem;
    color: var(--white-color);
}

.user-level {
    font-size: 0.8rem;
    color: var(--gray-color);
}
</style>
