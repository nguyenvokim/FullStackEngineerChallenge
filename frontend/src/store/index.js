import Vue from 'vue'
import Vuex from 'vuex'
import employee from './module/employee';
import employeeReview from './module/employeeReview';

Vue.use(Vuex);

const debug = process.env.NODE_ENV !== 'production';

const state = {
};
const getters = {};

const actions = {
};

const mutations = {
};

export default new Vuex.Store({
    modules: {
        employee,
        employeeReview
    },
    state,
    getters,
    actions,
    mutations,
    strict: debug,
})
