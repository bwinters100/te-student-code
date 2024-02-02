<template>
  <div class="book-container">
<<<<<<< HEAD
    <book-card v-for="book in $store.state.books" v-bind:book="book" v-bind:key="book.title" />
=======
    <book-card v-bind:book="book" v-for="book in $store.state.books" v-bind:key="book.isbn" />
>>>>>>> 4ff05e7a5a45779a1e20f260a945e463ee67b497
  </div>
</template>

<script>
import BookCard from './BookCard.vue'
<<<<<<< HEAD

//import component from ''


export default {
  
  components: { BookCard },
  name: 'reading-list', 
=======

export default {
  components: {
    BookCard
  }
>>>>>>> 4ff05e7a5a45779a1e20f260a945e463ee67b497
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>