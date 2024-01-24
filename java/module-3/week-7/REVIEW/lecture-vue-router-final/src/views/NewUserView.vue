<template>
  <h2>New User</h2>
  <user-form v-bind:user="newUser" />
</template>

<script>
import UserForm from "../components/UserForm.vue";

export default {
  components: {
    UserForm,
  },
  data() {
    return {
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active",
      },
    };
  },
};
</script>

<style>
</style>