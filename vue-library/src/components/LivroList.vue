<template>

  <ul>
    <li v-for="livro in livros" :key="livro.id">{{ livro.titulo }}</li>
  </ul>
</template>

<script>
import livroService from '../services/livroService';

export default {
  data() {
    return {
      livros: []
    };
  },
  mounted() {
    livroService.listar().then(response => {
      this.livros = response.data;
    });
  }
};
</script>

<style>

</style>
