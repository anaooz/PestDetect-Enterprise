# PestDetect

Repositório pro projeto Enterprise Application Development

[Vídeo da API](https://youtu.be/zPHaldBNaJo)
---
### Instalação/Utilização da API:
```$ git clone https://github.com/anaooz/PestDetect-Enterprise.git```

---
## Diagrama de Classes
![Diagrama de Classes](https://github.com/anaooz/PestDetect-Enterprise/assets/69781921/fd7ab3d7-105b-49ac-b681-72de5de225d5)
---
### Endpoints

- Usuário
    - [Cadastrar](#cadastrar-conta)
    - [Editar](#editar-conta)
    - [Deletar](#deletar-conta)

- Peste
    - [Lista](#lista-de-peste)
    - [Adicionar](#adicionar-peste)
    - [Editar](#editar-peste)

    - [Excluir](#excluir-peste)

---
### Cadastrar Conta
`POST` /api/registrar

**Campos da requisição**

| Campo | Tipo | Obrigatório | Descrição | 
|-------|------|-------------|-----------|
| nome |String|  Sim | Aqui o usuário deverá preencher o campo com o seu nome ou apelido. | 
| email |String|  Sim | Aqui o usuário deverá preencher o campo com o seu e-mail. | 
| senha |String|  Sim | Aqui o usuário deverá preencher o campo com uma senha. | 

Corpo de requisição

```js
{
    nome: 'Mateus',
    login: 'mateus@email.com',
    senha: '205478'
}
```

Códigos de resposta
| Código | Descrição |
|--------|------|
|200|dados retornados com sucesso|
|400|campos não preenchidos|

---

### Editar Conta
`PUT` /api/contas/{id}

**Corpo de requisição**

```js
{
    nome: 'João',
    login: 'joao@email.com',
    senha: '215579'
}
```

Códigos de resposta
| Código | Descrição |
|--------|------|
|200|dados alterados com sucesso|
|400|campos não preenchidos|
|404|conta não encontrada|

---

### Deletar Conta
`DELETE` /api/contas/{id}

Códigos de resposta
| Código | Descrição |
|--------|------|
|200|conta excluída com sucesso|
|404|conta não encontrada|

---

### Adicionar Peste

`POST` /api/peste

**Campos da requisição**

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|---
|nome popular | string | sim | o nome popular da peste
|nome científico | string | sim | o nome científico da peste
|tipo| string | sim | o tipo da peste
|método de controle| string | não | métodos de controle usados p/ eliminar a pesta

**Exemplo de corpo de requisição**

```js
{
    nomePopular:"Antracnose",
    nomeCientifico:"Colletotrichum truncatum",
    tipo:"Fungo",
    metodoDeControle:"Fungicidas",
    conta: {
       "id": 1
   }
}
```

**Códigos de Resposta**

| código | descrição
|-|-
| 201 | peste cadastrada com sucesso
| 400 | campos não preenchidos
---

### Editar Peste

`PUT` api/peste/{id}

**Exemplo de corpo de requisição**

```js
{
    nomePopular:"Lagarta-do-cartucho",
    nomeCientifico:"Spodoptera frugiperda",
    tipo:"Lagarta",
    metodoDeControle:"Inseticidas",
    conta:{
        id:1
   }
}
```

**Códigos de Resposta**

| código | descrição
|-|-
| 202 | peste alterada com sucesso
| 400 | campos não preenchidos ou faltando
| 404 | nenhum peste com o id informado
---

### Excluir Peste

`DELETE` api/peste/{id}

**Códigos de Resposta**

| código | descrição
|-|-
| 202 | peste excluída com sucesso
| 404 | nenhuma peste com o id informado
---

### Lista de Pestes

**Campos da requisição**

`GET` /api/peste

**Exemplo de corpo de requisição**
```js
{
    id: 1,
    nomepopular: 'Lagarta-do-cartucho',
    nomecientifico: 'Spodoptera frugiperda',
    tipo: 'Lagarta',
    metododecontrole: 'Inseticidas'
}
```
```js
{
    id: 2,
    nomepopular: 'Pulgão',
    nomecientifico: 'Aphidoidea',
    tipo: 'Inseto',
    metododecontrole: 'Inseticidas, predadores naturais.'
}
```
**Códigos de Resposta**

| código | descrição
|-|-
| 200 | dados retornados com sucesso
| 404 | nenhum peste encontrado
