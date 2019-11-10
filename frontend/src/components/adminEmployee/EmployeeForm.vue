<template>
    <div class="card-body form">
        <div class="form-group">
            <label class="col-form-label">Name</label>
            <input v-model="formData.name" placeholder="Enter name" type="text" required class="form-control"/>
        </div>
        <div class="form-group">
            <label class="col-form-label">Position</label>
            <input v-model="formData.position" placeholder="Enter position" type="text" required class="form-control"/>
        </div>
        <div class="form-group">
            <button class="btn btn-primary mr-2" @click="saveForm">
                <icon name="save"></icon> Save
            </button>
            <button class="btn btn-danger" @click="cancelForm">
                <icon name="angle-left"></icon> Back
            </button>
        </div>
    </div>
</template>

<script>

    import { mapActions, mapState, mapMutations } from 'vuex';

    const defaultEmployee = {
        name: '',
        position: ''
    }

    export default {
        components: {},
        props: {
            employee: {
                type: Object,
                default() {
                    return defaultEmployee
                }
            },
            editMode: {
                type: Boolean,
                default: false
            }
        },
        data: function() {
            return {
                formData: {...this.employee}
            }
        },
        mounted: function() {
        },
        methods: {
            saveForm:function () {
                this.$emit('submit', this.formData);
            },
            cancelForm: function () {
                this.$emit('cancel');
            }
        },
        computed: {
            ...mapState({
            })
        }
    }
</script>

