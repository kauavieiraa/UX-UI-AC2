# README - JAVADOC

Este documento descreve o funcionamento do pacote `login`, responsável pela autenticação de usuários em um banco de dados MySQL.

## Importando as Classes Necessárias

O código importa as seguintes classes Java:

- `java.sql.Connection`
- `java.sql.DriverManager`
- `java.sql.ResultSet`
- `java.sql.Statement`

## Classe `User`

A classe `User` representa um sistema de Login de usuários com autenticação no banco de dados. Ela se conecta a um banco de dados MySQL e verifica se o usuário e senha existem no banco.

### Autor

- Kauã Vieira Mendonça Santos

### Versão

- 1.0

### Atributos

- `nome`: O nome do usuário retornado pela consulta SQL após autenticação bem-sucedida.
- `result`: O resultado da verificação das credenciais.

### Métodos

#### `conectarBD()`

Este método estabelece uma conexão com o banco de dados MySQL.

- **Descrição**: A conexão é estabelecida com base na URL passada.
- **Retorno**: Retorna um objeto representando a conexão do banco de dados ou `null` caso a conexão falhe.

#### `verificarUsuario(login, senha)`

Verifica se o login e senha passados estão cadastrados no banco de dados.

- **Parâmetros**:
  - `login`: O login do usuário a ser autenticado.
  - `senha`: A senha correspondente ao login.
- **Retorno**: Define `result = true` caso as credenciais sejam válidas ou `result = false` caso contrário.

### Considerações

- **Tratamento de Exceções**: O código captura exceções sem fornecer mensagens detalhadas, o que dificulta o diagnóstico de falhas. É recomendável adicionar logs ou exibições de mensagens detalhadas nos blocos `catch`.
- **Fechamento da Conexão**: Após o uso, a conexão com o banco de dados deve ser fechada para evitar vazamento de recursos. Recomenda-se usar `try-with-resources` ou garantir o fechamento da conexão em um bloco `finally`.
- **Validação de Entradas**: As entradas dos parâmetros `login` e `senha` devem ser validadas para evitar o envio de valores inválidos ou tendenciosos.
- **Tratamento de Conexão Nula**: É importante tratar adequadamente o caso de a conexão com o banco não ser estabelecida corretamente.