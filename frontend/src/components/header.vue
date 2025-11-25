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