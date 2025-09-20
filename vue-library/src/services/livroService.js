import axios from 'axios';

const API_URL ='https://localhost:8080/livros';

export default {
    listar() {
        return axios.get(API_URL);
    },
    criar(livro){
        return axios.post(API_URL, livro);
    }
};