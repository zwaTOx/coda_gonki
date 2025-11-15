<script setup>
const props = defineProps({
    label: {
        type: String,
        default: "Label"
    },
    highlightedLabel: {
        type: String,
        default: "HIGHLIGHTED",
    },
    mainValue: {
        type: String,
        default: "0",
    },
    additionalValues: {
        type: Object,
        default: [{ tag: "TAG 1", value: "0", }, { tag: "TAG 2", value: "0", }, ]
    }
});
</script>

<template>
    <div class="stat-card-container">
        <div class="label inter-700">{{ label }}</div>
        <div class="highlighted-label inter-800">{{ highlightedLabel }}</div>
        <div class="main value inter-700">{{ mainValue }}</div>
        <div class="additional-container">
            <div class="additional-pair" v-for="pair in additionalValues">
                <div class="additional value inter-600">{{ pair.value }}</div>
                <div class="additional label inter-700">{{ pair.tag }}</div>
            </div>
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.stat-card-container {
    display: flex;
    flex-direction: column;
    gap: 2px;
    background-color: var(--blue-color);
    color: var(--gray-color);
    text-align: center;

    height: 268px;

    min-height: 240px;
    width: 235px;

    padding: 16px 0px;
    border-radius: 8px;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 25%);

    & .label {
        padding: 0px 24px;

        max-height: max-content;
        min-width: max-content;

        font-size: 0.7rem;
        font-style: italic;
    }

    & .highlighted-label {
        color: var(--accent-yellow-color);
        font-size: 1.1rem;
        max-height: max-content;
    }

    & .additional-container {
        padding: 0px 24px;

        display: flex;
        justify-content: center;
        max-height: max-content;
        box-sizing: border-box;

        & .additional-pair {
            width: 100%;
        }
    }

    & .main {
        padding: 0px 24px;

        font-size: 2.5rem;
        height: 100%;
        align-content: center;
        box-sizing: border-box;
    }

    & .value {
        color: var(--white-color);
        font-style: italic;

        min-width: max-content;
    }
}
</style>
