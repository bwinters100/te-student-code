<template>
  <tr v-bind:class="{ deactivated: user.status === 'Inactive' }">
    <td>
      <input
        type="checkbox"
        v-bind:id="user.id"
        v-bind:value="user.id"
        v-model="selectedIDs"
      />
    </td>
    <td>{{ user.firstName }}</td>
    <td>{{ user.lastName }}</td>
    <td>
      <router-link v-bind:to="{ name: 'user', params: { id: user.id } }">
        {{ user.username }}
      </router-link>
    </td>
    <td>{{ user.emailAddress }}</td>
    <td>{{ user.status }}</td>
    <td>
      <button class="btnActivateDeactivate" v-on:click="flipStatus(user.id)">
        {{ user.status === "Active" ? "Deactivate" : "Activate" }}
      </button>
    </td>
  </tr>
</template>

<script>
export default {
  props: ["user"],
  computed: {
    selectedIDs: {
      get() {
        return this.$store.state.selectedUserIDs;
      },
      set(value) {
        this.$store.commit("SAVE_USER_IDS", value);
      },
    },
  },
  methods: {
    flipStatus(id) {
      this.$store.commit("FLIP_USER_STATUS", id);
    },
  },
};
</script>

<style>
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
</style>