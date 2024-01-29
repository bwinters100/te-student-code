<template>
  <div class="all-actions">
    <button
      v-on:click="activateSelectedUsers()"
      v-bind:disabled="!actionButtonEnabled"
    >
      Activate Users
    </button>
    <button
      v-on:click="deactivateSelectedUsers()"
      v-bind:disabled="!actionButtonEnabled"
    >
      Deactivate Users
    </button>
    <button
      v-on:click="deleteSelectedUsers()"
      v-bind:disabled="!actionButtonEnabled"
    >
      Delete Users
    </button>
  </div>
</template>

<script>
export default {
  methods: {
    deleteUser(id) {
      this.$store.commit("DELETE_USER", id);
    },
    activateSelectedUsers() {
      this.$store.state.selectedUserIDs.forEach((id) => {
        this.$store.commit("SET_USER_STATUS", {id: id, status: 'Active'});
      });
      this.clearSelectedUsers();
    },
    deactivateSelectedUsers() {
      this.$store.state.selectedUserIDs.forEach((id) => {
        this.$store.commit("SET_USER_STATUS", {id: id, status: 'Inactive'});
      });
      this.clearSelectedUsers();
    },
    deleteSelectedUsers() {
      this.$store.state.selectedUserIDs.forEach((id) => {
        this.deleteUser(id);
      });
      this.clearSelectedUsers();
    },
    clearSelectedUsers() {
      this.$store.commit("SAVE_USER_IDS", []);
    },
  },
  computed: {
    actionButtonEnabled() {
      return this.$store.state.selectedUserIDs.length > 0;
    },
  },
};
</script>

<style>
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
</style>