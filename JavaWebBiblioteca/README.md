# Projeto Desenvolvido para Academia ATOS - Java

Este projeto tem como objetivo revisar e avaliar os conhecimentos adquiridos na Academia de Java Web. Trata-se de uma aplicação web para gerenciar livros de uma biblioteca, com funcionalidades de autenticação de usuários.

O sistema foi desenvolvido por Fernanda Vieira e Vanessa Neves.

## Requisitos

Um cliente está solicitando um sistema web para manter os livros de uma biblioteca. A manutenção destes produtos inclui os processos de cadastrar, visualizar livros cadastrados, excluir livros indesejados e realizar alterações em livros já cadastrados. Os registros dos livros devem conter informações como: código ISBN, título do livro, categoria, e quantidade.

**Informações sobre os livros a serem mantidos:**

* Valor único (representa o código ISBN) e é obrigatório seu preenchimento para o cadastro;
* Os nomes dos livros têm no máximo 50 caracteres, e assim como Código, é obrigatório seu preenchimento para o cadastro;
* Nem todo o livro cadastrado possui uma categoria;
* A quantidade de livros é um número inteiro e de preenchimento obrigatório no cadastro.

**Para a navegação, o sistema deve possuir:**

* Uma página home onde o usuário possa escolher o que se deseja fazer (cadastrar, visualizar, alterar ou deletar um livro).
* Uma página de cadastro de livros.
* Uma página de listagem de produtos com as opções de:
    * Excluir um livro
    * Alterar o livro selecionado
* Uma página para alteração do livro.
* Todas as páginas têm que possuir uma forma de redirecionamento para a página principal (home).

## Tecnologias Utilizadas

* **Java**: Linguagem de programação principal.
* **JavaScript**: Linguagem de programação de alto-nível.
* **Hibernate**: Mapeamento objeto-relacional (ORM).
* **Lombok**: Redução de boilerplate de código Java.
* **Servlet e JSP**: Controle e apresentação.
* **Maven**: Gerenciamento de dependências e build do projeto.
* **PostgreSQL**: Banco de dados relacional.
* **HTML e CSS**: Interface do usuário.
* **Tailwind CSS**: Framework de CSS utilitário.
* **Tomcat**: Servidor de aplicação.

## Estrutura do Projeto

- **Modelo (Model)**: Representa os dados e a lógica de negócios (Java Classes, Hibernate, Lombok).
- **Visão (View)**: Interface do usuário (JSP + HTML/CSS + Tailwind).
- **Controle (Controller)**: Lida com as requisições e atualiza o Model e View (Servlets).