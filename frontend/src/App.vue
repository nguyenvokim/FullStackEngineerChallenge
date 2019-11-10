<template>
    <div id="app">
        <nav-bar />
        <div class="container mt-2">
            <router-view/>
        </div>
    </div>
</template>

<script>

    import NavBar from './components/NavBar'

    export default {
        name: 'app',
        components: {NavBar}
    }
</script>

