import { createRouter as _createRouter, createWebHistory } from 'vue-router';

import HomeView from '../views/HomeView.vue';
import EditUserView from '../views/EditUserView.vue';
import NewUserView from '../views/NewUserView.vue';


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/user/:id',
    name: 'user',
    component: EditUserView
  },
  {
    path: '/user',
    name: 'newuser',
    component: NewUserView
  }
];

export function createRouter () {
  return _createRouter({
    history: createWebHistory(),
    routes: routes
  })
}
