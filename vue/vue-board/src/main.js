import Vue from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.css";
import VueRouter from 'vue-router';
import router from './assets/router.js'
import store from './assets/vuex.js'

Vue.config.productionTip = false
Vue.use(VueRouter);

new Vue({
  router: router,
  store: store,
  render: h => h(App),
}).$mount('#app')
