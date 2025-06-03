# 📚 Duda - Loja de Livros (Versão 1.0)

Este é um projeto de estudo criado com o objetivo de desenvolver um sistema completo de gerenciamento para uma loja de livros, utilizando **Java com Spring Boot** no backend e **MySQL** como banco de dados.

## ✅ Funcionalidades da versão 1.0

- Cadastro de **livros**, **autores**, **categorias** e **vendas**.
- Relacionamentos entre tabelas com chaves estrangeiras.
- CRUD completo para cada entidade.
- Testes via Postman para simulação de requisições HTTP.
- Estrutura organizada com `Model`, `Repository`, `Service` e `Controller`.

  ## 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot
- MySQL
- Maven
- Postman

  ## 🗂 Estrutura das Tabelas

### Livros
- `id` (PK)
- `nome`
- `id_categoria` (FK)
- `id_autor` (FK)
- `preco`

### Autor
- `id` (PK)
- `nome`

### Categoria
- `id` (PK)
- `nome`

### Vendas
- `id` (PK)
- `id_livro` (FK)
- `quantidade`
- `data_venda`

> Obs: na versão 1.0, cada venda contém apenas **um** livro.

## 📌 Status do Projeto

🚀 **Versão 1.0 finalizada**

🔄 **Versão 2.0 (em desenvolvimento)**
