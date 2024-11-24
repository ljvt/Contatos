# Aplicativo Android CRUD com Java e SQLite

Este é um aplicativo Android simples que demonstra as operações básicas de CRUD (Criar, Ler, Atualizar e Deletar) usando Java e SQLite. O projeto utiliza componentes nativos do Android para a interface do usuário e gerenciamento de banco de dados.

## Funcionalidades

- **Criar**: Adicionar novos registros no banco de dados.
- **Ler**: Visualizar todos os registros salvos.
- **Atualizar**: Modificar registros existentes.
- **Deletar**: Remover registros do banco de dados.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto.
- **SQLite**: Banco de dados relacional embutido utilizado para armazenar os dados localmente.
- **Componentes Nativos do Android**: Views, RecyclerView, EditText, Button, etc.

## Requisitos

- **Android Studio**: IDE para desenvolvimento Android.
- **SDK do Android**: Versão mínima recomendada é 22.

## Estrutura do Projeto

- **MainActivity.java**: A tela principal para cadastro dos contatos.
- **ContatoListaActivity.java**: Tela para listar, editar ou deletar um registro.
- **AppDatabase.java**: Classe que gerencia a criação e atualização do banco de dados SQLite.
- **ContatoDao.java**: Classe de Data Access Object para operações CRUD na tabela de contatos.
- **Contato.java**: Classe de modelo que representa um contato.
- **ContatoAdapter.java**: Classe para mostar os items no recyclerView.

## Uso

1. **Adicionar Contato**:
   - Clique no botão "Adicionar" na tela principal.
   - Preencha os campos de nome, telefone e email.
   - Clique em "Salvar" para adicionar o contato ao banco de dados.

2. **Listar Contatos**:
   - Os contatos salvos serão exibidos na tela ContatoListaActivity em uma RecyclerView.

3. **Editar Contato**:
   - Clique no botão alterar para abrir um dialog para editar.
   - Modifique os campos desejados e clique em "Alterar".

4. **Deletar Contato**:
   - Clique no botão deletar.
   - Abre um dialog perguntando se deseja deletar o contato.

  Espero que isso ajude a fornecer uma visão clara e concisa do seu projeto! Se precisar de mais alguma coisa, estou aqui para ajudar. 😊
