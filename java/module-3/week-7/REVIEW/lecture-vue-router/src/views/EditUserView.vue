<template>
  <h2>Edit User</h2>
  <user-form v-bind:user="viewedUser" />
</template>

<script>
import UserForm from "../components/UserForm.vue";

export default {
  components: {
    UserForm,
  },
  computed: {
    viewedUser() {
      let thisUser = this.$store.state.users.find((user) => {
        return user.id == this.$route.params.id;
      });
      if (thisUser) {
        return {
          id: thisUser.id,
          firstName: thisUser.firstName,
          lastName: thisUser.lastName,
          username: thisUser.username,
          emailAddress: thisUser.emailAddress,
          status: thisUser.status,
        };
      } else {
        return {
          id: null,
          firstName: "",
          lastName: "",
          username: "",
          emailAddress: "",
          status: "Active",
        };
      }
    },
  },
};
</script>

<style>
</style>