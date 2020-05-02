<template>
  <div>
    <app-header />
    <router-view />
  </div>
</template>

<script>
import AppHeader from './components/app-header';

export default {
  name: 'App',

  components: {
    AppHeader
  }
}
</script>
