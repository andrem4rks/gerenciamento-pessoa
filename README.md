# Nome do Projeto

> CRUD estudo montado durante meu período de desenvolvimento na Assembléia Legislativa do Estado do Acre.

---

## 📑 Índice

- [📌 Descrição](#descrição)
-  [👨‍💻 Autor](#autor)
- [✅ Funcionalidades](#funcionalidades)
- [🖼️ Screenshots](#screenshots)
- ⚙️ [Requisitos](#requisitos)
- [🚀 Como executar](#como-executar)
- [🛠️ Tecnologias utilizadas](#tecnologias-utilizadas)
- 🔩[Estrutura](#estrutura)
- [📄 Licença](#licença)

  
---  

## 📌 Descrição
Este sistema foi desenvolvido para gerenciar pessoas, possuindo autenticação, cadastro de pessoas, cadastro de dependentes,  
listagem de pessoas e listagem de dependentes relacionados.  
Foi um projeto desenvolvido durante minha função como desenvolvedor Java na assembléia legislativa do estado do Acre. Com  
o objetivo de me tornar proeficiente no desenvolvimento utilizando as ferramentas da casa.

[Voltar ao índice](#indice)

## 👨‍💻 Autor

Desenvolvido por [André Marks](https://github.com/andrem4rks)

Entre em contato:
- 📧 andrem4rks@gmail.com
- 💼 [LinkedIn](https://linkedin.com/in/andrem4rks)

[Voltar ao índice](#indice)

## ✅ Funcionalidades
### 1. **Autenticação**
- **Login com e-mail e senha** – ✅ Concluído
- **Cadastro de novos usuários** 🛠️ Em desenvolvimento

### 2. **Gestão de Pessoas**

- **Cadastro** – ✅ Concluído
  - Preenchimento de dropdowns via banco - ✅ Concluído
  - Validação de CPF - ✅ Concluído
  - Verificação de CPF duplicado - ✅ Concluído
  - Carregamento de endereço via CEP - ✅ Concluído
  - Validação de campos obrigatórios - ✅ Concluído


- **Edição** – ✅ Concluído
  - Validar se CPF é utilizado por outra pessoa - ✅ Concluído


- **Listagem** - ✅ Concluído
  - Paginação - ✅ Concluído
  - Pesquisa por nome ou CPF - ✅ Concluído


- **Exclusão** - ✅ Concluído
  - Excluir dependentes associados e pessoa - ✅ Concluído

### 3. **Gestão de Dependentes**
- **Cadastro** – ✅ Concluído
  - Preenchimento de dropdowns via banco - ✅ Concluído
  - Validação de CPF - ✅ Concluído
  - Verificação de CPF duplicado - ✅ Concluído
  - Carregamento de endereço via CEP - ✅ Concluído
  - Validação de campos obrigatórios - ✅ Concluído


- **Edição** - ✅ Concluído
  - Validar se CPF é utilizado por outra pessoa - ✅ Concluído


- **Listagem**
  - Paginação - ✅ Concluído
  - Pesquisa por nome ou CPF - ✅ Concluído


- **Exclusão** - ✅ Concluído


[Voltar ao índice](#indice)

---  

## 🖼️ Screenshots
### Tela de Login
![Tela de Login](/screenshots/tela-login.png)

### Tela Home
![Tela Home](/screenshots/tela-home.png)

### Telas de Pessoa
- Cadastro preenchido:  
  ![Tela de Cadastro](/screenshots/pessoa/tela-cadastro-pessoa.png)


- Cadastro com erro:  
  ![Tela de Cadastro com Erro](/screenshots/pessoa/tela-cadastro-pessoa-erro.png)


- Tela de edição:  
  ![Tela de Editar](/screenshots/pessoa/tela-editar-pessoa.png)


- Tela de listagem:  
  ![Tela de listagem](/screenshots/pessoa/tela-listar-pessoas.png)


- Tela de exclusão:  
  ![Tela de listagem](/screenshots/pessoa/tela-excluir-pessoa.png)

### Telas de Dependente
- Cadastro preenchido:  
  ![Tela de Cadastro](/screenshots/dependente/tela-cadastro-dependente.png)


- Tela de edição:  
  ![Tela de Listar](/screenshots/dependente/tela-listar-dependentes.png)


- Tela de listagem:  
  ![Tela de listagem](/screenshots/pessoa/tela-listar-pessoas.png)


- Tela de exclusão:  
  ![Tela de listagem](/screenshots/pessoa/tela-excluir-pessoa.png)

[Voltar ao índice](#indice)

---

## ⚙️ Requisitos

Antes de executar o projeto, verifique se você tem os seguintes itens instalados:

- [✅] [Docker](https://www.docker.com/)
- [✅] [Docker Compose](https://docs.docker.com/compose/) (opcional, mas recomendado)
- [❌] Java, etc. (não é necessário instalar localmente se usar Docker)

[Voltar ao índice](#indice)

---  
## 🚀 Como executar

Passos para rodar o projeto localmente:

```bash  
# Clone o repositório  
git clone https://github.com/andrem4rks/gerenciamento-pessoa.git  
  
# Acesse a pasta do projeto  
cd gerencimento-pessoa/  
  
# Execute o docker compose  
docker compose -f docker/gerenciamento-pessoa-pg/docker-compose.yml up -d  
  
# Acesso  
Acesse atrávez da seguinte url: localhost:8080/login  
usuario: admin  
senha: admin  
```  

[Voltar ao índice](#indice)

## 🔩Estrutura

[Voltar ao índice](#indice)

## 📄 Licença
Este projeto está sob a licença Attribution-NonCommercial 4.0 International.

Copyright (c) 2025 André Marks Santos de Lima

Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

[Voltar ao índice](#indice)

  