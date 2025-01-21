# ForumHub - API de Fórum

Bem-vindo ao **ForumHub**, um projeto desenvolvido durante o curso ONE da Alura! Este projeto implementa uma API REST para um fórum, permitindo que os usuários criem, leiam, atualizem e excluam tópicos de conversa. A API foi construída utilizando **Spring Boot** e **PostgreSQL** como banco de dados para persistência.

## Objetivo

O objetivo do projeto é replicar o funcionamento de um fórum de perguntas e respostas, onde usuários podem interagir com tópicos, fazer perguntas e acompanhar as discussões. A API permite realizar as seguintes operações:

- **Criar um novo tópico**
- **Mostrar todos os tópicos**
- **Mostrar um tópico específico**
- **Atualizar um tópico**
- **Eliminar um tópico**

## Funcionalidades

- CRUD (Create, Read, Update, Delete) completo para tópicos de conversa.
- Validações de dados segundo regras de negócios.
- Autenticação e autorização utilizando **JWT** (JSON Web Token) para restringir o acesso às informações.
- Integração com o banco de dados **PostgreSQL** para persistência de dados.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação.
- **Spring Boot**: Framework para desenvolvimento da API.
- **PostgreSQL**: Banco de dados relacional para persistência de dados.
- **JWT**: Mecanismo de autenticação e autorização.
- **Spring Data JPA**: Para manipulação do banco de dados e mapeamento de entidades.

## Endpoints

### 1. Criar Tópico

- **Método**: POST
- **Endpoint**: `/api/topicos`
- **Descrição**: Cria um novo tópico no fórum.
- **Exemplo de Request**:
  ```json
  {
    "titulo": "Dúvida sobre Spring Boot",
    "mensagem": "Como posso configurar o JWT em uma aplicação Spring Boot?",
    "autor": "Usuário1",
    "curso": "Spring Boot"
  }

### 2. Listar Todos os Tópicos

- **Método**: GET
- **Endpoint**: `/api/topicos`
- **Descrição**: Retorna todos os tópicos criados.

### 3. Exibir Tópico Específico

- **Método**: GET
- **Endpoint**: `/api/topicos/{id}`
- **Descrição**: Retorna detalhes de um tópico específico.

### 4. Atualizar Tópico

- **Método**: PUT
- **Endpoint**: `/api/topicos/{id}`
- **Descrição**: Atualiza os dados de um tópico específico.

### 5. Eliminar Tópico

- **Método**: DELETE
- **Endpoint**: `/api/topicos/{id}`
- **Descrição**: Exclui um tópico específico.

---

## Banco de Dados

O projeto utiliza o banco de dados **PostgreSQL** para armazenar informações sobre os tópicos e usuários. O modelo de dados foi projetado para manter a integridade e facilitar a interação entre os diferentes componentes do fórum.

## Autenticação

A autenticação da API é realizada através de **JWT (JSON Web Token)**, garantindo que apenas usuários autenticados possam realizar operações de CRUD nos tópicos.

---


Feito por Alex Gabriel de Araujo.
