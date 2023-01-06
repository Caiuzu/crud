#language: pt

Funcionalidade: Testar métodos CRUD da API REST de Estudantes

  Cenário: Adiciona dado de um novo estudante
    Dado que possuo as informações do estudante
      | name   | last_name | age |
      | Ragnar | L         | 18  |
    Quando envio as informações do meu estudante
    Então deverá ser cadastrado com sucesso

  Cenário: Adiciona dado de um novo estudante com dados incorretos
    Dado que possuo as informações do estudante
      | name | last_name | age |
      |      | L         | 18  |
    Quando envio as informações do meu estudante com erro
    Então não deverá ser cadastrado

  Cenário: Encontrar os dados de um estudante pelo ID
    Dado possuo o id "1" de estudante
    Quando envio as informações para consulta do meu estudante
    Então retornará os seguintes dados
      | id | name   | last_name | age |
      | 1  | Ragnar | L         | 18  |

  Cenário: Não encontrar os dados de um estudante pelo ID
    Dado possuo o id "1" de estudante
    Quando envio as informações para consulta do meu estudante
    Então retornará erro
