<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Review System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <router-link active-class="active" class="nav-link" :to="{name: 'employeeReview'}">
                        Employee View
                    </router-link>
                </li>
            </ul>
            <ul class="navbar-nav my-2 my-lg-0">
                <li class="nav-item">
                    <router-link active-class="active" class="nav-link" :to="{name: 'adminEmployee'}">
                        Admin Employee
                    </router-link>
                </li>
                <li class="nav-item">
                    <router-link active-class="active" class="nav-link" :to="{name: 'adminEmployeeReview'}">
                        Admin Performance Review
                    </router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
    import { mapActions, mapState, mapMutations } from 'vuex';

    export default {
        data() {
            return {
            }
        },
        mounted() {
        },
    }
</script>
