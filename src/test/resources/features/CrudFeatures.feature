#language: pt

Funcionalidade: Testar métodos CRUD da API REST de Estudantes

  Cenário: Adiciona dado de um novo estudante
    Dado que possuo as informações do estudante
      | name   | last_name | age |
      | Ragnar | L         | 18  |
    Quando envio as informações do meu estudante
    Então deverá ser cadastrado com sucesso

# melhor sempre utilizar datable para passagem de dados/ "variaveis" pois o cucumber é nas teoria vizualizado pela equipe de QA e Negócios#
# facilitando a leitura e mudança de dados para test

#  Cenário: Adiciona dado de um novo estudante com dados incorretos
#    Dado que possuo as informações do estudante
##      | name  | last_name | age |
##      |  | L         | 18  |
#    Quando envio as informações do meu estudante
#    Então deverá ser cadastrado com sucesso