<template>
    <div class="card" v-if="loaded">
        <div class="card-header">
            Performance review List
        </div>
        <table class="table table-striped">
            <tr>
                <th>#</th>
                <th>From Employee</th>
                <th>To Employee</th>
                <th>Score</th>
                <th>Action</th>
            </tr>
            <admin-employee-review-row @view-detail="handleViewDetailReview" v-bind:key="index" v-for="(items, index) in reviewPaging.items" :employee-review="items"></admin-employee-review-row>
        </table>
        <div class="card-footer">
            <b-pagination
                    v-model="page"
                    :total-rows="reviewPaging.total"
                    :per-page="reviewPaging.itemPerPage"
                    align="center"
                    @change="handlePageChange"
            />
        </div>
        <b-modal ref="viewReviewModal" ok-only size="lg" :title="`Detail Review`">
            <div class="" v-if="selectedReview.id">
                <p><strong>From Employee</strong>: {{selectedReview.reviewer.name}}</p>
                <p><strong>To Employee</strong>: {{selectedReview.employee.name}}</p>
                <p><strong>Score</strong>: {{selectedReview.score}}</p>
                <p><strong>Comment</strong>: {{selectedReview.comment}}</p>
            </div>
        </b-modal>
    </div>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';
    import AdminEmployeeReviewRow from './AdminEmployeeReviewRow'

    export default {
        components: {AdminEmployeeReviewRow},
        data: function() {
            return {
                loaded: false,
                page: 1,
                selectedReview: {}
            }
        },
        mounted: async function() {
            await this.loadReviews(this.page);
            this.loaded = true;
        },
        methods: {
            ...mapActions({
                loadEmployees: 'employee/loadEmployees',
                loadReviews: 'employeeReview/loadReviews',
            }),
            handlePageChange: function (e) {
                this.loadReviews(this.page);
            },
            handleViewDetailReview: function (review) {
                this.selectedReview = review;
                this.$refs.viewReviewModal.show();
            }
        },
        computed: {
            ...mapState({
                employees: (state) => state.employee.employees,
                reviewPaging: (state) => state.employeeReview.reviewPaging
            })
        }
    }
</script>

