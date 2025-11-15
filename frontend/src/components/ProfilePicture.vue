<script setup>
const props = defineProps({
    showImage: {
        type: Boolean,
        default: false,
    },
    value: {
        type: String,
        required: true,
    },
    size: {
        type: Number,
        required: true,
    }
});
</script>

<template>
    <div v-if="showImage" class="profile-picture-image"></div>

    <div v-else class="profile-picture-letters"
    :class="{
        'size-48': size > 0 && size <= 48,
        'size-64': size > 48 && size <= 64,
        'size-128': size > 64 && size <= 128,
        'size-256': size > 128 && size <= 256,
    }">
        <div class="letters inter-700">
            {{ value }}
        </div>
    </div>
</template>

<style scoped>
@import url('../styles/colors.css');
@import url('../styles/fonts.css');

.letters {
    color: black;
}

.profile-picture-letters {
    background-color: var(--white-color);
    text-align: center;
    align-content: center;
    user-select: none;

    border-radius: 50%;
}

.size-48 {
    min-width: 48px;
    min-height: 48px;

    width: 48px;
    height: 48px;

    .letters {
        font-size: 20px;
    }
}

.size-64 {
    min-width: 64px;
    min-height: 64px;

    width: 64px;
    height: 64px;

    .letters {
        font-size: 24px;
    }
}

.size-128 {
    min-width: 128px;
    min-height: 128px;
    
    width: 128px;
    height: 128px;

    .letters {
        font-size: 64px;
    }
}

.size-256 {
    min-width: 256px;
    min-height: 256px;

    .letters {
        font-size: 64px;
    }
}
</style>
