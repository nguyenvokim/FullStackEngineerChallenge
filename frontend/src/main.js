import Vue from 'vue';
import App from './App.vue';
import store from './store';
import VueRouter from 'vue-router';
import routes from './routes';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import 'bootstrap';
import 'bootstrap/scss/bootstrap.scss';
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon'

Vue.use(VueRouter);
Vue.use(BootstrapVue);
Vue.component('icon', Icon);


Vue.config.productionTip = false
export default new Vue({
  render: h => h(App),
  store,
  router: routes,
}).$mount('#app');
