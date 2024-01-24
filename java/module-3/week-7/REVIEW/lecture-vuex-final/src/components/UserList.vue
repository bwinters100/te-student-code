<template>
  <div class="container">
    <user-table />
    <user-table-actions />
    <new-user-form />
  </div>
</template>

<script>
import UserTable from "./UserTable.vue";
import NewUserForm from "./NewUserForm.vue";
import UserTableActions from "./UserTableActions.vue";

export default {
  components: {
    UserTable,
    NewUserForm,
    UserTableActions,
  },
};
</script>

<style scoped>
</style>
