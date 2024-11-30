# Análise de Código - Classe `User`

Este documento apresenta uma análise de possíveis erros  para a classe `User`.

## 1- Erros encontrados

### 1.1- Tratamento de Exceções
O código apresenta a ausência de mensagens para tratamento de exceções, o que dificulta o diagnóstico de falhas. Para melhorar, é recomendável adicionar logs ou exibições de mensagens detalhadas nos blocos `catch`, como `e.printStackTrace()`.

### 1.2- Falta de Fechamento da Conexão
O código não fecha a conexão com o banco de dados após o uso, o que pode causar vazamento de recursos. Para evitar isso, é aconselhável utilizar o recurso `try-with-resources` ou garantir o fechamento da conexão em um bloco `finally`.

### 1.3- Validação de Entradas
O código não valida as entradas dos parâmetros `login` e `senha`, o que pode permitir o envio de valores inválidos ou tendenciosos. Para resolver isso, é necessário validar as entradas antes de processá-las, garantindo que não sejam nulas ou vazias.

### 1.4- Tratamento de Conexão Nula
Não há um tratamento adequado para o caso de a conexão com o banco não ser estabelecida corretamente. 

### 1.5- Inicialização da Variável `nome`
A variável `nome`, que armazena o nome do usuário retornado pela consulta SQL, pode não ser inicializada caso a consulta não retorne nenhum resultado, o que pode causar problemas em outras partes do código.