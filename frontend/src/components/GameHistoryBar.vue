<script setup>
import { computed, ref } from 'vue';
import ProfilePicture from './ProfilePicture.vue';

const props = defineProps({
    won: {
        type: Boolean,
        default: true,
    },
    gameFormat: {
        type: String,
        default: "БОКС",
    },
    opponentIcon: {
        type: String,
        default: "ЭБ"
    },
    opponentName: {
        type: String,
        default: "Эрик Бокчектуев"
    },
    opponentRating: {
        type: String,
        default: "Новичок I (200)"
    },
    receivedRating: {
        type: String,
        default: "+12"
    }

});

const WIN_TEXT = 'Победа';
const LOSE_TEXT = 'Поражение'
const status = ref(props.won ? WIN_TEXT : LOSE_TEXT);

</script>

<template>
    <div class="game-history-bar-container" :class="{
        'won': won,
        'lost': !won,
    }">
        <div class="status inter-500">{{ status }}</div>
        <div class="game-format inter-600">{{ gameFormat }}</div>
        <div class="opponent-info">
            <ProfilePicture
            :size="64"
            :value="opponentIcon"></ProfilePicture>
            <div class="opponent-details">
                <div class="opponent-name inter-600">{{ opponentName }}</div>
                <div class="opponent-rating inter-400">{{ opponentRating }}</div>
            </div>
            <div class="received-rating inter-600">{{ receivedRating }}</div>
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.game-history-bar-container {
    display: flex;
    align-items: center;
    border-radius: 8px;

    gap: 12px;
    
    padding: 12px;
    color: var(--white-color);

    & .opponent-info {
        display: flex;
        align-items: center;
        gap: 8px;
        width: 100%;

        & .opponent-name {
            font-size: 0.8rem;
        }
        
        & .opponent-rating {
            font-size: 0.6rem;
        } 
    }

    & .received-rating {
        text-align: end;
        width: 100%;
    }
}

.won {
    background: linear-gradient(to right, var(--accent-green-color), var(--accent-light-green-color));
}

.lost {
    background: linear-gradient(to right, var(--accent-red-color), var(--accent-light-red-color));
}

.status {
    width: 172px;
}

</style>
