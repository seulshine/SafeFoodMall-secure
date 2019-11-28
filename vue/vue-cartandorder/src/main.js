import Vue from 'vue'
import App from './App.vue'
import VueRouter from "vue-router"

// 디버깅 할 때
Vue.config.productionTip = true 
// VueRouter 사용 선언
Vue.use(VueRouter);

new Vue({
  render: h => h(App),
}).$mount('#app')
