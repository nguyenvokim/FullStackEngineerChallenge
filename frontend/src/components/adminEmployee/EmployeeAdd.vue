<template>
    <div class="card">
        <div class="card-header">
            Add Emmployee
        </div>
        <employee-form @submit="handleSubmit" @cancel="handleCancel"/>
    </div>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';
    import EmployeeForm from './EmployeeForm';

    export default {
        components: {EmployeeForm},
        data: function() {
            return {
                onSendRequest: false
            }
        },
        mounted: function() {
        },
        methods: {
            ...mapActions({
                addEmployee: 'employee/addEmployee'
            }),
            handleSubmit: async function (employee) {
                if (this.onSendRequest) return;
                this.onSendRequest = true;
                await this.addEmployee(employee);
                await this.$bvModal.msgBoxOk('Add employee success', {title: 'Success'});
                this.onSendRequest = false;
                this.$router.push({name: 'adminEmployee'});
            },
            handleCancel: function () {
                this.$router.push({name: 'adminEmployee'});
            }
        },
        computed: {
            ...mapState({
            })
        }
    }
</script>

