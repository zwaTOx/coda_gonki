<script setup>
import headerComponent from './components/header.vue';
</script>

<template>
  <headerComponent />
  <main class="main">
    <router-view ></router-view>
  </main>
  
</template>

<script>
export default {
  name: 'App',
  components: { headerComponent },
  data() {
    return {

    }
  }
}
</script>
