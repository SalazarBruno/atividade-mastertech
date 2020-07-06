# atividade-mastertech

Documentação da API REST

## Funcionalidades de usuário

### /usuario
    Descrição: Cadastra um novo usuário
    Tipo: POST

##### Parâmetros:
    - name: Nome do usuário
    - cpf: CPF do usuário
    - email: E-mail do usuário
    - date: Data de Cadastro

### /usuario
    Descrição: Lista todos os usuários cadastrados
    Tipo: GET

### /usuario/<id>
    Descrição: Busca informações sobre o código de usuário informado em <id>
    Tipo: GET

### /usuario/<id>
    Descrição: Edita informações do código de usuário informado em <id>
    Tipo: PUT

##### Parâmetros editáveis:
    - name
    - cpf
    - email

## funcionalidades de ponto

### /ponto
    Descrição: Registra o ponto de um usuário
    Tipo: POST



======================
=========WIP===========
======================
### /ponto/listAllTimeEntries
    Descrição: lista todos os registros de ponto
    Tipo: GET

### /ponto/listTimeEntries/<userId>
    Descrição: lista todos os registros de ponto do código de usuário informado em <userId>
    Tipo: GET



##### Parâmetros
        userId: id do usuario
        type: tipo de registro, in para entrada e out para saída

