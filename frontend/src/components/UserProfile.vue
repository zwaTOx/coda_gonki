<script setup>
import BorderButton from './BorderButton.vue';
import ProfilePicture from './ProfilePicture.vue';

</script>

<template>
    <div class="user-profile-container">
        <div class="user-details">
            <ProfilePicture :size="256" :value="'КД'"></ProfilePicture>
            <div class="user-info">
                <div class="user-name inter-600">Константин Денисов</div>
                <div class="user-level-stats">
                    <div class="user-level inter-800">УР 2</div>
                    <div class="level-bar">
                        <div class="filled-level-bar"></div>
                        <div class="level-points inter-600">24/150</div>
                    </div>
                </div>
                <div class="edit-button-container">
                    <BorderButton :text="'Изменить аватар'"></BorderButton>
                    <BorderButton :text="'Изменить личные данные'"></BorderButton>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.user-profile-container {
    position: relative;
    z-index: 2;

    margin: 0 24vw;
    margin-top: 64px;
}

.user-details {
    display: flex;
    align-items: center;
    gap: 32px;
}

.user-info {
    display: flex;
    flex-direction: column;
    gap: 8px;
}

.edit-button-container {
    display: flex;
    gap: 12px;
}

.user-name {
    color: var(--white-color);
    font-size: 1.5rem;
}

.user-level-stats {
    display: flex;
    align-items: center;

    gap: 12px;
}

.user-level {
    min-width: max-content;
    color: var(--accent-yellow-color);
    font-size: 0.8rem;
    font-style: italic;
    text-shadow: 0px 4px 4px var(--dark-color);
}

.level-bar {
    position: relative;
    text-align: center;

    min-width: 100%;
    min-height: 100%;

    border-radius: 8px;
    background-color: var(--white-color);

    .filled-level-bar {
        display:inline-block;
        border-radius: 8px;
        background-color: var(--accent-yellow-color);
        min-width: 18%;
        min-height: 0;
        height: auto;
    }
}

.level-points {
    position: absolute;
    align-content: center;
    box-sizing: border-box;

    font-style: italic;

    height: 100%;
    width: 100%;

    top: 0;
    font-size: 0.8rem;
}

</style>
