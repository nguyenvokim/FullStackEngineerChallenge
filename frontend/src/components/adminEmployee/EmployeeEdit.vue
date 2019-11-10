<template>
    <div class="card">
        <div class="card-header">
            Edit Emmployee: <strong>{{employee.name}}</strong>
        </div>
        <employee-form v-if="employee.id" :employee="employee" @submit="handleSubmit" @cancel="handleCancel"/>
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
        mounted: async function() {
            await this.loadEmployee(this.$route.params.id);
            this.$nextTick(() => {
                if (!this.employee.id) {
                    this.$router.push({name: 'adminEmployee'});
                }
            })
        },
        methods: {
            ...mapActions({
                updateEmployee: 'employee/updateEmployee',
                loadEmployee: 'employee/loadEmployee',
            }),
            handleSubmit: async function (employee) {
                if (this.onSendRequest) return;
                this.onSendRequest = true;
                await this.updateEmployee({id: this.employee.id, employee});
                await this.$bvModal.msgBoxOk('Update employee success', {title: 'Success'});
                this.onSendRequest = false;
                this.$router.push({name: 'adminEmployee'});
            },
            handleCancel: function () {
                this.$router.push({name: 'adminEmployee'});
            }
        },
        computed: {
            ...mapState({
                employee: (state) => state.employee.employee
            })
        }
    }
</script>

