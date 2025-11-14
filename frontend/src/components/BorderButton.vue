<script setup>
const props = defineProps({
    text: {
        type: String,
        default: "Button",
    } 
});
</script>

<template>
    <div class="border-button inter-600">{{ text }}</div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.border-button {
    border: 2px solid var(--white-color);
    border-radius: 34px;

    font-size: 0.7rem;
    color: var(--white-color);

    width: max-content;
    padding: 0.25rem 0.5rem;

    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 25%);
}
</style>
