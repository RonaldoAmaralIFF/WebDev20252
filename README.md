
# Projeto Connect-Local

Descrição do Projeto
Connect-Local é uma plataforma web completa desenvolvida como projeto da disciplina de Desenvolvimento Web. O objetivo é criar um portal para divulgação e inscrição em eventos locais, construído com uma arquitetura híbrida usando Java e o ecossistema Spring. A aplicação serve tanto páginas dinâmicas renderizadas no servidor com Thymeleaf quanto uma API REST para clientes externos.



## Documentação da API

#### Retorna todos os itens

```http
  GET /api/items
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `api_key` | `string` | **Obrigatório**. A chave da sua API |

#### Retorna um item

```http
  GET /api/items/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **Obrigatório**. O ID do item que você quer |

#### add(num1, num2)

Recebe dois números e retorna a sua soma.


## Apêndice

Coloque qualquer informação adicional aqui


## Autores

- [@octokatherine](https://www.github.com/octokatherine)


## Etiquetas

Adicione etiquetas de algum lugar, como: [shields.io](https://shields.io/)

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)

## Documentação de cores

| Cor               | Hexadecimal                                                |
| ----------------- | ---------------------------------------------------------------- |
| Cor exemplo       | ![#0a192f](https://via.placeholder.com/10/0a192f?text=+) #0a192f |
| Cor exemplo       | ![#f8f8f8](https://via.placeholder.com/10/f8f8f8?text=+) #f8f8f8 |
| Cor exemplo       | ![#00b48a](https://via.placeholder.com/10/00b48a?text=+) #00b48a |
| Cor exemplo       | ![#00d1a0](https://via.placeholder.com/10/00b48a?text=+) #00d1a0 |


## Contribuindo

Contribuições são sempre bem-vindas!

Veja `contribuindo.md` para saber como começar.

Por favor, siga o `código de conduta` desse projeto.


## Demonstração

Insira um gif ou um link de alguma demonstração


## Uso/Exemplos

```javascript
import Component from 'my-project'

function App() {
  return <Component />
}
```


## Usado por

Esse projeto é usado pelas seguintes empresas:

- Empresa 1
- Empresa 2


## Rodando localmente

Clone o projeto

```bash
  git clone https://link-para-o-projeto
```

Entre no diretório do projeto

```bash
  cd my-project
```

Instale as dependências

```bash
  npm install
```

Inicie o servidor

```bash
  npm run start
```


![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)


