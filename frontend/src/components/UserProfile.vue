<script setup>
import BorderButton from './BorderButton.vue';
import GameHistoryBar from './GameHistoryBar.vue';
import ProfilePicture from './ProfilePicture.vue';
import StatCard from './StatCard.vue';

</script>

<template>
    <div class="user-profile-container">
        <div class="user-details">
            <ProfilePicture style="box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 50%);" :size="256" :value="'КД'"></ProfilePicture>
            <div class="user-info">
                <div class="user-name inter-600">Константин Денисов</div>
                <div class="user-level-stats">
                    <div class="user-level inter-800">УР 2</div>
                    <div class="level-bar" style="box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 50%);">
                        <div class="filled-level-bar">_</div>
                        <div class="level-points inter-600">24/150</div>
                    </div>
                </div>
                <div class="edit-button-container">
                    <BorderButton :text="'Изменить аватар'"></BorderButton>
                    <BorderButton :text="'Изменить личные данные'"></BorderButton>
                </div>
            </div>
        </div>
        <div class="heading inter-600">Статистика</div>
        <div class="user-stats-container">
            <StatCard
            :label="'Сыграно Игр'"
            :highlighted-label="'БОКС'"
            :main-value="'4'"
            :additional-values="[
                {
                    tag: 'KOs',
                    value: '1',
                }, 
                {
                    tag: 'МАКС. ОЧКОВ',
                    value: '19945',
                },
            ]"
            ></StatCard>
            <StatCard
            :label="'Текущий'"
            :highlighted-label="'РЕЙТИНГ'"
            :main-value="'240'"
            :additional-values="[
                {
                    tag: 'ВЫСШИЙ',
                    value: '252',
                }, 
            ]"
            ></StatCard>
            <StatCard
            :label="'Текущий'"
            :highlighted-label="'ПРОЦЕНТ ПОБЕД'"
            :main-value="'33'"
            :additional-values="[
                {
                    tag: 'ПОБЕД',
                    value: '1',
                }, 
                {
                    tag: 'ПОРАЖЕНИЙ',
                    value: '3',
                },
            ]"
            ></StatCard>
            <StatCard
            :label="'Текущая'"
            :highlighted-label="'СЕРИЯ ПОБЕД'"
            :main-value="'33.3%'"
            :additional-values="[
                {
                    tag: 'ВЫСШИЙ',
                    value: '252',
                }, 
            ]"
            ></StatCard>
        </div>
        <div class="heading inter-600">История игр</div>
        <div class="user-game-history-container">
            <GameHistoryBar></GameHistoryBar>
            <GameHistoryBar :won="false"></GameHistoryBar>
            <GameHistoryBar :won="false"></GameHistoryBar>
            <GameHistoryBar :won="false"></GameHistoryBar>
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.user-profile-container {
    position: relative;
    z-index: 2;

    margin-top: 64px;
}

.heading {
    margin-top: 24px;
    font-size: 1rem;
    color: var(--white-color);
    
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 30%);
    text-align: center;
}

.user-details {
    display: flex;
    align-items: center;
    gap: 32px;
}

.user-info {
    display: flex;
    flex-direction: column;
    gap: 12px;
}

.edit-button-container {
    display: flex;
    gap: 12px;
}

.user-stats-container {
    display: flex;
    justify-content: space-between;
    margin-top: 24px;
    grid-template-columns: 1fr 1fr 1fr 1fr;
}

.user-game-history-container {
    margin-top: 24px;

    display: flex;
    flex-direction: column;
    gap: 8px;
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
    text-shadow: 0px 4px 2px var(--dark-color);
}

.level-bar {
    position: relative;
    text-align: center;

    width: 100%;
    min-height: 100%;
    box-sizing: border-box;

    border-radius: 8px;
    background-color: var(--white-color);

    .filled-level-bar {
        border-radius: 8px;
        color: var(--accent-yellow-color);
        background-color: var(--accent-yellow-color);
        width: 10%;
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
