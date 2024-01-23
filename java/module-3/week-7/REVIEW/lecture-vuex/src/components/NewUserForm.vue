<template>
  <div>
    <button v-on:click="showForm = !showForm">Add New User</button>

    <form id="frmAddNewUser" v-show="showForm" v-on:submit.prevent="saveUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input
          type="text"
          id="firstName"
          name="firstName"
          v-model="newUser.firstName"
        />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input
          type="text"
          id="lastName"
          name="lastName"
          v-model="newUser.lastName"
        />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input
          type="text"
          id="username"
          name="username"
          v-model="newUser.username"
        />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input
          type="text"
          id="emailAddress"
          name="emailAddress"
          v-model="newUser.emailAddress"
        />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      showForm: false,
      nextUserId: 7,
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
  methods: {
    getNextUserId() {
      return this.nextUserId++;
    },
    saveUser() {
      console.log(`Saving ${this.newUser}`);

      this.newUser.id = this.getNextUserId();
      this.$store.commit("SAVE_USER", this.newUser);
      this.clearNewUser();
    },
    clearNewUser() {
      this.newUser = {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active",
      };
    },
  },
};
</script>

<style>
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>