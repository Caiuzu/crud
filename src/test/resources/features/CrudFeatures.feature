#language: pt

Funcionalidade: Testar métodos CRUD da API REST de Estudantes

  Cenário: Adiciona dado de um novo estudante
    Dado que possuo as informações do estudante
      | name   | last_name | age |
      | Ragnar | L         | 18  |
    Quando envio as informações do meu estudante
    Então deverá ser cadastrado com sucesso

#  Cenário: Adiciona dado de um novo estudante com dados incorretos
#    Dado que possuo as informações do estudante
#      | name | last_name | age |
#      |      | L         | 18  |
#    Quando envio as informações do meu estudante
#    Então não deverá ser cadastrado