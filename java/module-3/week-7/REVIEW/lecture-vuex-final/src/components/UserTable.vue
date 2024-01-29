<template>
  <table id="tblUsers">
    <thead>
      <tr>
        <th>&nbsp;</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>
          <input
            type="checkbox"
            id="selectAll"
            v-on:change="selectAll($event)"
            v-bind:checked="
              $store.state.selectedUserIDs.length === $store.state.users.length
            "
          />
        </td>
        <td>
          <input type="text" id="firstNameFilter" v-model="filter.firstName" />
        </td>
        <td>
          <input type="text" id="lastNameFilter" v-model="filter.lastName" />
        </td>
        <td>
          <input type="text" id="usernameFilter" v-model="filter.username" />
        </td>
        <td>
          <input type="text" id="emailFilter" v-model="filter.emailAddress" />
        </td>
        <td>
          <select id="statusFilter" v-model="filter.status">
            <option value>Show All</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
          </select>
        </td>
        <td>&nbsp;</td>
      </tr>

      <user-table-row
        v-for="user in filteredList"
        v-bind:user="user"
        v-bind:key="user.id"
      />
    </tbody>
  </table>
</template>

<script>
import UserTableRow from "./UserTableRow.vue";

export default {
  components: {
    UserTableRow,
  },
  data() {
    return {
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
    };
  },
  methods: {
    selectAll(event) {
      if (event.target.checked) {
        this.$store.commit(
          "SAVE_USER_IDS",
          this.$store.state.users.map((user) => user.id)
        );
      } else {
        this.$store.commit("SAVE_USER_IDS", []);
      }
    },
  },
  computed: {
    filteredList() {
      let filteredUsers = this.$store.state.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter(
          (user) => user.status === this.filter.status
        );
      }
      return filteredUsers;
    },
  },
};
</script>

<style>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
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