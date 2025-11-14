<script setup>
const props = defineProps({
    text: {
        type: String,
        default: "Button",
    }
});
</script>

<template>
    <div class="header-button inter-700">{{ text }}</div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.header-button {
    font-size: 1rem;
    font-style: italic;
    color: var(--gray-color);

    max-width: max-content;
    padding: 10px;
    border-radius: 4px;

    transition: all ease-out 0.1s;

    &:hover {
        color: var(--dark-color);
        background-color: var(--white-color);
        transform: translate(0px, 4px);
        transition: all ease-in-out 0.1s;
    }
}
</style>
