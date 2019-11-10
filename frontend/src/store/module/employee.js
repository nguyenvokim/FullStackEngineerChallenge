import axios from 'axios';

const state = {
    employees: [],
    employee: {},
};
const getters = {};

const actions = {
    loadEmployees: async function ({commit}) {
        return axios.get(`/api/admin/employees`).then((res) => {
            commit('setEmployees', res.data);
        })
    },
    loadEmployee: async function ({commit}, id) {
        return axios.get(`/api/admin/employees/${id}`).then((res) => {
            commit('setEmployee', res.data);
        })
    },
    addEmployee: function ({commit}, employee) {
        return axios.post(`/api/admin/employees`, employee);
    },
    updateEmployee: function ({commit}, data) {
        return axios.put(`/api/admin/employees/${data.id}`, data.employee);
    },
    deleteEmployee: function ({commit}, id) {
        return axios.delete(`/api/admin/employees/${id}`);
    }
};

const mutations = {
    setEmployees: function (state, employees) {
        state.employees = employees;
    },
    setEmployee: function (state, employee) {
        state.employee = employee;
    }
};

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations,
}
