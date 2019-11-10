<template>
    <div class="card" v-if="loaded">
        <div class="card-header form-inline">
            <label class="col-form-label">Select Employee: </label>
            <select v-model="selectedEmployeeId" class="form-control" @change="handleEmployeeSelectedChange">
                <option v-bind:key="index" v-for="(employee, index) in employees" :value="employee.id">{{employee.name}}</option>
            </select>
        </div>
        <table class="table table-striped">
            <tr>
                <th>#</th>
                <th>Review for Employee</th>
                <th>Requested At</th>
                <th>Action</th>
            </tr>
            <employee-review-row v-bind:key="index" v-for="(reviewRequest, index) in reviewRequests" :review-request="reviewRequest"></employee-review-row>
        </table>
    </div>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';
    import EmployeeReviewRow from './EmployeeReviewRow'

    export default {
        components: {EmployeeReviewRow},
        data: function() {
            return {
                loaded: false,
                selectedEmployeeId: 0
            }
        },
        mounted: async function() {
            await this.loadEmployees();
            this.$nextTick(() => {
                if (this.employees.length) {
                    this.selectedEmployeeId = this.employees[0].id;
                    this.loadReviewRequests(this.selectedEmployeeId).then(() => {
                        this.loaded = true;
                    });
                }
            })
        },
        methods: {
            ...mapActions({
                loadEmployees: 'employee/loadEmployees',
                loadReviewRequests: 'employeeReview/loadReviewRequests',
            }),
            handleEmployeeSelectedChange: function () {
                this.loadReviewRequests(this.selectedEmployeeId);
            }
        },
        computed: {
            ...mapState({
                employees: (state) => state.employee.employees,
                reviewRequests: (state) => state.employeeReview.reviewRequests
            })
        }
    }
</script>

