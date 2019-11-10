<template>
    <tr>
        <td>{{employeeReview.id}}</td>
        <td>{{employeeReview.reviewer.name}}</td>
        <td>{{employeeReview.employee.name}}</td>
        <td>{{employeeReview.score}}</td>
        <td>
            <div class="btn-group-sm">
                <button class="btn btn-success" @click="viewDetail">
                    <icon name="eye"></icon> View Detail
                </button>
            </div>
        </td>
    </tr>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';
    import axios from 'axios';

    const initalReviewForm = {
        score: 10,
        comment: ''
    }

    export default {
        components: {},
        props: {
            employeeReview: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
        data: function() {
            return {
            }
        },
        mounted: function() {
        },
        methods: {
            ...mapActions({
            }),
            viewDetail: function () {
                this.$emit('view-detail', this.employeeReview);
            }
        },
        computed: {
            ...mapState({
            })
        }
    }
</script>

