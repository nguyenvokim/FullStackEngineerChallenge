<template>
    <tr>
        <td>{{reviewRequest.id}}</td>
        <td>{{reviewRequest.toEmployee.name}}</td>
        <td>{{displayDate(reviewRequest.createdAt)}}</td>
        <td>
            <div class="btn-group btn-group-sm">
                <button class="btn btn-success" @click="handleStartReview">
                    <icon name="edit"></icon> Start Review
                </button>
                <button class="btn btn-danger" @click="handleRejectReview">
                    <icon name="window-close"></icon> Reject Review
                </button>
            </div>
            <b-modal ref="addReview" @ok="handleOk" size="lg" :title="`Add performance review for ${reviewRequest.toEmployee.name}`">
                <div class="phone_preview">
                    <div class="form-group">
                        <label class="col-form-label">
                            Select Score
                        </label>
                        <select v-model="reviewForm.score" class="form-control">
                            <option v-bind:key="index" v-for="(score, index) in scores" :value="score">{{score}}</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">
                            Add Comment
                        </label>
                        <textarea v-model="reviewForm.comment" placeholder="Please fill your comment" class="form-control" cols="5"></textarea>
                    </div>
                </div>
            </b-modal>
        </td>
    </tr>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';
    import axios from 'axios';
    import  {format, parseISO} from 'date-fns';

    const initalReviewForm = {
        score: 10,
        comment: ''
    }

    export default {
        components: {},
        props: {
            reviewRequest: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
        data: function() {
            return {
                scores: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1],
                reviewForm: {...initalReviewForm}
            }
        },
        mounted: function() {
        },
        methods: {
            ...mapActions({
                loadReviewRequests: 'employeeReview/loadReviewRequests',
            }),
            handleRejectReview: async function () {
                const isOk = await this.$bvModal.msgBoxConfirm(`Reject review for employee: ${this.reviewRequest.toEmployee.name}`, { title: 'Confirm' });
                if (isOk) {
                    await axios.delete(`/api/employees/${this.reviewRequest.fromEmployeeId}/reviewRequests/${this.reviewRequest.id}`);
                    await this.$bvModal.msgBoxOk('Reject Success', {title: 'Success'});
                    this.loadReviewRequests(this.reviewRequest.fromEmployeeId);
                }
            },
            handleStartReview: function(){
                this.$refs.addReview.show();
            },
            handleOk: async function () {
                await axios.post(`/api/employees/${this.reviewRequest.fromEmployeeId}/reviewRequests/${this.reviewRequest.id}`, this.reviewForm);
                await this.$bvModal.msgBoxOk(`Add review for ${this.reviewRequest.toEmployee.name} success`, {title: 'Success'});
                this.loadReviewRequests(this.reviewRequest.fromEmployeeId);
            },
            displayDate: function (isoDateString) {
                const date= parseISO(isoDateString);
                return format(date, 'HH:mm yyyy/MM/dd')
            },
        },
        computed: {
            ...mapState({
            })
        }
    }
</script>

