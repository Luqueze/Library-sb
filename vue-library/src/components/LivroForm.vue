<template>
  <form @submit.prevent="cadastrarLivro">
    <input v-model="livro.titulo" placeholder="Título" required />
    <input v-model="livro.autor" placeholder="Autor" required />
    <input v-model="livro.genero" placeholder="Gênero" />
    <input v-model="livro.isbn" placeholder="ISBN" />
    <input v-model="livro.anoPublicacao" type="number" placeholder="Ano" />
    <button type="submit">Salvar</button>
  </form>
</template>

<script>
import livroService from '../services/livroService';

export default {
  data() {
    return {
      livro: {
        titulo: '',
        autor: '',
        genero: '',
        isbn: '',
        anoPublicacao: ''
      }
    };
  },
  methods: {
    cadastrarLivro() {
      livroService.criar(this.livro).then(() => {
        alert('Livro cadastrado com sucesso!');
        this.$emit('atualizar-lista');
        this.livro = {
          titulo: '',
          autor: '',
          genero: '',
          isbn: '',
          anoPublicacao: ''
        };
      });
    }
  }
};
</script>