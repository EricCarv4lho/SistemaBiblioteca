# Projeto Spring Boot - Sistema de Biblioteca

Este projeto é uma aplicação Spring Boot que permite gerenciar o cadastro e consulta de livros e autores. A aplicação possibilita a criação, listagem, atualização e exclusão de livros, utilizando o banco de dados MySQL para persistência dos dados.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA**: Para interações com bancos de dados utilizando JPA (Java Persistence API).
- **Spring Web**: Para construção de APIs RESTful.
- **Spring Validation**: Para validação de dados de entrada.
- **MySQL**: Banco de dados relacional utilizado para persistência de dados.

## Funcionalidades

- **Criar Livro**: Permite adicionar novos livros à biblioteca.
- **Listar Livros**: Exibe todos os livros cadastrados.
- **Listar Livros com Paginação**: Permite a listagem dos livros em formato paginado.
- **Atualizar Livro**: Possibilita a edição de informações de livros existentes.
- **Excluir Livro**: Remove livros da biblioteca.

## Endpoints

### Adicionar Livro
- **Endpoint**: `/livros/adicionar`
- **Método**: `POST`
- **Descrição**: Adiciona um novo livro à biblioteca.
- **Corpo da Requisição**:
  ```json
  {
    "autor": {
        "nome": "Joana",
        "nacionalidade": "Brasileira",
        "biografia": "Biografia do Autor"
    },
    "livro": {
        "titulo": "teste",
        "data": "2014-10-21", // data no formato YYYY-MM-DD
        "preco": 0
        
    }
}

    ```
### Listar Livros
- **Endpoint**: `/livros`
- **Método**: `GET`
- **Descrição**: Retorna todos os livros cadastrados na biblioteca.
- **Resposta**:
  ```json
  [
    {
      "id": 1,
      "titulo": "Título do Livro",
      "data": "2024-10-14",
      "preco": 29.99,
      "autor": {
        "id": 1,
        "nome": "Nome do Autor"
      }

    }

    ```
### Listar Livros com Paginação
- **Endpoint**: `/livros/listarComPaginacao?page=1&size=2`
- **Método**: `GET`
- **Descrição**: Retorna uma lista de livros em formato paginado.
- **Explicação dos Parâmetros**
-**page**: Este parâmetro indica qual página de resultados você deseja obter. As páginas geralmente começam do zero, ou seja:

page=0 retorna a primeira página,
page=1 retorna a segunda página, e assim por diante.

-**size**: Este parâmetro especifica quantos itens (livros, neste caso) você deseja que sejam retornados em cada página. Por exemplo:

size=2 significa que você quer receber 2 livros por página.
- **Resposta**:

 ```json
 
{
  "conteudo": [
    {
      "id": 1,
      "titulo": "Título do Livro",
      "data": "2024-10-14",
      "preco": 29.99,
      "autor": {
        "id": 1,
        "nome": "Nome do Autor"
      }
    }
  ],
  "pagina": 0,
  "totalPaginas": 5,
  "totalElementos": 50
}
 ```
### Atualizar Livro
- **Endpoint**: /livros/atualizar/{id}
- **Método:** PUT
- **Descrição**: Atualiza as informações de um livro existente.
- **Parâmetros de URL**:
- **id**: ID do livro a ser atualizado.

### Corpo da Requisição
O corpo da requisição deve conter um objeto no formato JSON com as seguintes propriedades:

```json
{
    "titulo": "Novo Título",
    "data": "2024-01-01",
    "preco": 20.0,
    "autorDTO": {
        "id": 6,
        "nome": "Nome do Autor",
        "nacionalidade": "Nacionalidade do Autor",
        "biografia": "Nova Biografia do Autor"
    }
}
```
### Excluir Livro
- **Endpoint**: /livros/atualizar/{id}
- **Método**: DELETE


  

- **id**: Código do livro a ser excluído.

**Resposta**: Retorna uma mensagem de sucesso ou erro.



