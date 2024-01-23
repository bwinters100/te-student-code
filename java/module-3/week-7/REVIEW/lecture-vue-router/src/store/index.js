import { createStore as _createStore } from 'vuex';

export function createStore() {
  return _createStore({
    state: {
      nextUserId: 7,
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive"
        }
      ],
      selectedUserIDs: []
    },
    mutations: {
      SAVE_USER(state, user) {
        state.users.push(user);
      },
      DELETE_USER(state, id) {
        state.users = state.users.filter((user) => {
          return user.id !== id;
        });
      },
      UPDATE_USER(state, user) {
        state.users = state.users.filter((currentUser) => {
          return currentUser.id !== user.id;
        });
        state.users.push(user);
      },
      INCR_USER_ID(state, payload) {
        state.nextUserId++;
      },
      SET_USER_STATUS(state, payload) {
        const index = state.users.findIndex((user) => user.id == payload.id);
        state.users[index].status = payload.status;
      },
      FLIP_USER_STATUS(state, id) {
        const index = state.users.findIndex((user) => user.id == id);
        state.users[index].status = state.users[index].status === "Active" ? "Inactive" : "Active";
      },
      SAVE_USER_IDS(state, userIds) {
        state.selectedUserIDs = userIds;
      }
    },
    actions: {},
    modules: {},
    // Strict should not be used in production code. It is used here as a
    // learning aid to warn you if state is modified without using a mutation.
    strict: true
  });
}
