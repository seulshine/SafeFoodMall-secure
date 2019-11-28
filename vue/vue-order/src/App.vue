<template>
  <div id="app">
    <order></order>
  </div>
</template>

<script>
import order from './components/Order.vue'

export default {
  name: 'app',
  components: {
    order
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
