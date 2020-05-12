# atividade-mastertech

Documentação da API REST

## Funcionalidades de usuário

### /ponto/addUser
    Descrição: Cadastra um novo usuário
    Tipo: POST

##### Parâmetros:
    - name: Nome do usuário
    - cpf: CPF do usuário
    - email: E-mail do usuário
    - date: Data de Cadastro

### /ponto/listAllUsers
    Descrição: Lista todos os usuários cadastrados
    Tipo: GET

### /ponto/user/<id>
    Descrição: Busca informações sobre o código de usuário informado em <id>
    Tipo: GET

### /ponto/editUser/<id>
    Descrição: Edita informações do código de usuário informado em <id>
    Tipo: PUT

##### Parâmetros editáveis:
    - name
    - cpf
    - email

## funcionalidades de ponto

### /ponto/listAllTimeEntries
    Descrição: lista todos os registros de ponto
    Tipo: GET

### /ponto/listTimeEntries/<userId>
    Descrição: lista todos os registros de ponto do código de usuário informado em <userId>
    Tipo: GET

### /ponto/addTimeEntry
    Descrição: Registra o ponto de um usuário
    Tipo: POST

##### Parâmetros
        userId: id do usuario
        type: tipo de registro, in para entrada e out para saída

