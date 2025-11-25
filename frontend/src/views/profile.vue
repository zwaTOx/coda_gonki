<template>
    <div class="profile">
        <div class="profile__descr">
            <div class="profile__descr--icon">
                {{ profile.initials }}
            </div>
            <div class="profile__descr--info">
                <div class="profile__descr--info--name">
                    {{ profile.name }}
                </div>
                <div class="profile__descr--info--lvl">
                    <div class="profile__descr--info--lvl--text">
                        УР {{ profile.lvl }}
                    </div>
                    <div class="profile__descr--info--lvl--bar">
                        <div class="profile__descr--info--lvl--bar--currentbar" :style="{width: `calc(${profile.progress*100/profile.next_lvl}%)`}">
                            
                        </div>
                        <div class="currentbar__text">
                            {{ profile.progress }} / {{ profile.next_lvl }}
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="profile__stats profile_comp">
            <h1>Статистика</h1>
            <div class="stats_cards">
                <div class="stats_card">
                    <div class="stats_card__descr">
                        Сыграно игр
                    </div>
                    <div class="stats_card__name">
                        Бокс
                    </div>
                    <div class="stats_card__value">
                        4
                    </div>
                    <div class="stats_card__info">
                        <div class="stats_card__info--side" :style="{width: `calc(100%/${count_stats})`}">
                            <div class="stats_card__info--side--value" >
                                1
                            </div>
                            <div class="stats_card__info--side--sign">
                                KOs
                            </div>
                        </div>
                        <div class="stats_card__info--side" :style="{width: `calc(100%/${count_stats})`}">
                            <div class="stats_card__info--side--value">
                                19945
                            </div>
                            <div class="stats_card__info--side--sign">
                                МАКС. ОЧКОВ
                            </div>
                        </div>
                    </div>
                </div>
                <div class="stats_card">
                    <div class="stats_card__descr">
                        Текущий
                    </div>
                    <div class="stats_card__name">
                        Рейтинг
                    </div>
                    <div class="stats_card__value">
                        240
                    </div>
                    <div class="stats_card__info">
                        <div class="stats_card__info--side" :style="{width: `calc(100%/${count_stats})`}">
                            <div class="stats_card__info--side--value">
                                1
                            </div>
                            <div class="stats_card__info--side--sign">
                                ВЫСШИЙ
                            </div>
                        </div>
                        <div class="stats_card__info--side" :style="{width: `calc(100%/${count_stats})`}">
                            <div class="stats_card__info--side--value">
                                1
                            </div>
                            <div class="stats_card__info--side--sign">
                                НИЗШИЙ
                            </div>
                        </div>
                    </div>
                </div>
                <div class="stats_card">
                    <div class="stats_card__descr">
                        Текущий
                    </div>
                    <div class="stats_card__name">
                        Процент побед
                    </div>
                    <div class="stats_card__value">
                        33.3%
                    </div>
                    <div class="stats_card__info">
                        <div class="stats_card__info--side" :style="{width: `calc(100%/${count_stats})`}">
                            <div class="stats_card__info--side--value">
                                1
                            </div>
                            <div class="stats_card__info--side--sign">
                                ПОБЕД
                            </div>
                        </div>
                        <div class="stats_card__info--side" :style="{width: `calc(100%/${count_stats})`}">
                            <div class="stats_card__info--side--value">
                                3
                            </div>
                            <div class="stats_card__info--side--sign">
                                ПОРАЖЕНИЯ
                            </div>
                        </div>
                    </div>
                </div>
                <div class="stats_card">
                    <div class="stats_card__descr">
                        Текущая
                    </div>
                    <div class="stats_card__name">
                        Серия побед
                    </div>
                    <div class="stats_card__value">
                        1
                    </div>
                    <div class="stats_card__info">
                        <div class="stats_card__info--side" :style="{width: `calc(100%/${1})`}">
                            <div class="stats_card__info--side--value">
                                1
                            </div>
                            <div class="stats_card__info--side--sign">
                                ЛУЧШАЯ СЕРИЯ
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="profile__history profile_comp">
            <h1>История</h1>
            <history-component v-for="game in history" :key="game.id" :data="game" />
        </div>
    </div>
</template>

<script>
import historyComponent from '@/components/historyComponent.vue';

export default {
    components: { historyComponent },
    data() {
        return {
            games: 4,
            ko: 1,
            max_points: 19945,

            rating: 240,
            high: 1,
            lower: 1,

            procent_win: 33.3,

            count_stats: 2,
            profile: {
                name: 'Константин Денисов',
                lvl: 2,
                progress: 24,
                next_lvl: 150,
            },
            history: [
                {
                    id: 1,
                    type: 'win',
                    opponent: 'Яков Гречнев',
                    opponent_rank: 'Новичок I',
                    rating: 240,
                    progress: '+12',
                },
                {
                    id: 2,
                    type: 'lose',
                    opponent: 'Эрик Бочектуев',
                    opponent_rank: 'Новичок II',
                    rating: 252,
                    progress: '-12',
                },
                {
                    id: 3,
                    type: 'lose',
                    opponent: 'Илья Найдуков',
                    opponent_rank: 'Новичок II',
                    rating: 252,
                    progress: '-9',
                }
            ]
        }
    },
    methods: {
        getInitials(value) {
            return value.split(' ').map(name => name[0]).join('')
        }
    },
    mounted() {
        this.profile.initials = this.getInitials(this.profile.name)
        for (let i = 0; i < this.history.length; i++) {
            this.history[i].opponent_initials = this.getInitials(this.history[i].opponent)
        }
        console.log(this.history)
    }
}
</script>