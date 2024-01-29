<template>
  <div class="container">
    <user-table />
    <user-table-actions />
  </div>
</template>

<script>
import UserTable from "./UserTable.vue";
import UserTableActions from "./UserTableActions.vue";

export default {
  components: {
    UserTable,
    UserTableActions,
  },
};
</script>

<style scoped>
</style>
