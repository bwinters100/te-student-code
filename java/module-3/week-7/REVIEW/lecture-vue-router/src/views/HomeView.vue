<template>
  <main>
    <user-list />
    <router-link v-bind:to="{ name: 'newuser' }">
      <button>NewUser</button>
    </router-link>
  </main>
</template>

<script>
import UserList from "../components/UserList.vue";

export default {
  components: {
    UserList
  }
}
</script>

<style>

</style>