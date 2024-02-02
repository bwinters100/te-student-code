<template>
  <div>
      <reading-list />
      <router-link :to="{name: 'newBook'}">Add Book</router-link>
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'

export default {
    components: {
        ReadingList
    }
}
</script>

<style>
</style>