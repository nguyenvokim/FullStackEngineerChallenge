<template>
    <div class="card">
        <div class="card-header">
            List Emmployees
            <router-link class="btn btn-success btn-sm float-right" :to="{name: 'adminEmployeeNew'}">
                <icon name="plus"></icon> Add Employee
            </router-link>
        </div>
        <table class="table table-striped">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Possition</th>
                <th>Action</th>
            </tr>
            <employee-list-row v-bind:key="index" v-for="(employee, index) in employees" :employee="employee"></employee-list-row>
        </table>
    </div>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';
    import EmployeeListRow from './EmployeeListRow';

    export default {
        components: {EmployeeListRow},
        mounted: function() {
            this.loadEmployees();
        },
        methods: {
            ...mapActions({
                loadEmployees: 'employee/loadEmployees',
            }),
        },
        computed: {
            ...mapState({
                employees: (state) => state.employee.employees
            })
        }
    }
</script>

