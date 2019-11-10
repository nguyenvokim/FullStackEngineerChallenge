import axios from 'axios';

const state = {
    reviewRequests: [],
    reviewPaging: {},
};
const getters = {};

const actions = {
    loadReviewRequests: function ({commit}, employeeId) {
        return axios.get(`/api/employees/${employeeId}/reviewRequests`).then((res) => {
            commit('setReviewRequests', res.data);
        })
    },
    loadReviews: function ({commit}, page) {
        return axios.get(`/api/admin/employeeReviews`, {params: {page}}).then((res) => {
            commit('setReviewPaging', res.data);
        })
    }
};

const mutations = {
    setReviewRequests: function (state, requests) {
        state.reviewRequests = requests;
    },
    setReviewPaging: function (state, data) {
        state.reviewPaging = data;
    },
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
}
