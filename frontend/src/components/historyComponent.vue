<template>
    <div class="historyCard" :class="data.type === 'win' ? 'win' : 'lose' ">
        <div class="historyCard__info">
            <div class="historyCard__info--type">{{ data.type === 'win' ? 'Победа' : 'Поражение' }}</div>
            <div class="historyCard__info--opponent">
                <div class="opponent__icon">
                    {{ data.opponent_initials }}
                </div>
                <div class="opponent__info">
                    <div class="opponent__info--name">{{ data.opponent }}</div>
                    <div class="opponent__info--rating">{{ `${data.opponent_rank} (${data.rating})` }}</div>
                </div>
            </div>
        </div>
        <div class="historyCard__rating">
            {{ data.progress }}
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {

        }
    },
    props: {
        data: {
            type: Object,
            req: true
        }
    }
}
</script>