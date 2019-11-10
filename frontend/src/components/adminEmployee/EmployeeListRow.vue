<template>
    <tr>
        <td>{{ employee.id }}</td>
        <td>{{ employee.name }}</td>
        <td>{{ employee.position }}</td>
        <td>
            <div class="btn-group btn-group-sm">
                <router-link class="btn btn-primary" :to="{name: 'adminEmployeeEdit', params: {id: employee.id}}">
                    <icon name="edit"></icon> Edit
                </router-link>
                <button class="btn btn-danger" @click="handleDelete(employee.id)">
                    <icon name="window-close"></icon> Delete
                </button>
                <button class="btn btn-success" @click="handleClickAssignReview">
                    <icon name="user-edit"></icon> Assign Employee Review
                </button>
                <b-modal ref="assignReviewModal" @ok="handleOk" size="lg" :title="`Assign Employee Review For ${employee.name}`">
                    <div class="phone_preview">
                        <div class="form-group">
                            <label class="col-form-label">
                                Select reviewer
                            </label>
                            <select v-model="selectedAssignerId" class="form-control">
                                <option v-bind:key="index" v-for="(employee, index) in employees" :value="employee.id">{{employee.name}}</option>
                            </select>
                        </div>
                        <div class="form-group" v-if="showError">
                            <label class="alert-danger">
                                {{errorMessage}}
                            </label>
                        </div>
                    </div>
                </b-modal>
            </div>
        </td>
    </tr>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';
    import axios from 'axios';

    export default {
        components: {},
        props: {
            employee: {
                type: Object,
                default() {
                    return {}
                }
            }
        },
        data: function() {
            return {
                selectedAssignerId: 0,
                showError: false,
                errorMessage: ''
            }
        },
        mounted: function() {
            if (this.employees.length) {
                this.selectedAssignerId = this.employees[0].id;
            }
        },
        methods: {
            ...mapActions({
                loadEmployees: 'employee/loadEmployees',
                deleteEmployee: 'employee/deleteEmployee',
            }),
            handleDelete: async function (id) {
                const isOk = await this.$bvModal.msgBoxConfirm(`Delete employee ID: ${id}`, { title: 'Confirm' });
                if (isOk) {
                    await this.deleteEmployee(id);
                    this.loadEmployees();
                }
            },
            handleClickAssignReview: function() {
                this.$refs.assignReviewModal.show();
            },
            handleOk: async function(e) {
                e.preventDefault();
                if (this.selectedAssignerId === this.employee.id) {
                    this.showErrorMessage('Can not select an employee review for themself');
                    return;
                }
                const res = await axios.post(`/api/admin/employees/${this.employee.id}/assignReview/${this.selectedAssignerId}`);
                if (res.data.hasError) {
                    this.showErrorMessage(res.data.message);
                    return;
                }
                this.$refs.assignReviewModal.hide();
                const content = `Success assign reviewer <b>${this.assigner.name}</b> for <b>${this.employee.name}</b>`;
                const h = this.$createElement;
                const contentNode = h('div', { domProps: { innerHTML: content } });
                await this.$bvModal.msgBoxOk([contentNode], {title: 'Success'});
            },
            showErrorMessage: function (message) {
                this.showError = true;
                this.errorMessage = message;
                setTimeout(() => {
                    this.showError = false;
                }, 6000)
            }
        },
        computed: {
            ...mapState({
                employees: (state) => state.employee.employees
            }),
            assigner: function () {
                const foundEmployee = this.employees.find((employee) => {
                    return employee.id === this.selectedAssignerId;
                });
                return foundEmployee ? foundEmployee : {};
            }
        }
    }
</script>

