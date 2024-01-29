<template>
  <div>
    <form id="frmAddNewUser" v-on:submit.prevent="saveUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input
          type="text"
          id="firstName"
          name="firstName"
          v-model="user.firstName"
        />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input
          type="text"
          id="lastName"
          name="lastName"
          v-model="user.lastName"
        />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input
          type="text"
          id="username"
          name="username"
          v-model="user.username"
        />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input
          type="text"
          id="emailAddress"
          name="emailAddress"
          v-model="user.emailAddress"
        />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  props: ["user"],
  data() {
    return {
      nextUserId: 7,
    };
  },
  methods: {
    getNextUserId() {
      const userId =  this.$store.state.nextUserId;
      this.$store.commit("INCR_USER_ID", {});
      return userId;
    },
    saveUser() {
      if (!this.user.id) {
        this.user.id = this.getNextUserId();
        this.$store.commit("SAVE_USER", this.user);
      } else {
        this.$store.commit("UPDATE_USER", this.user);
      }
      this.$router.push({ name: "home" });
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