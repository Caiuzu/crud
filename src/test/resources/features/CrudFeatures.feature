#language: pt

Funcionalidade: Testar métodos CRUD da API REST de Estudantes

  Cenário: Adiciona dado de um novo estudante
    Dado que realizado um POST no endpoint de estudante
    Quando preenchida o requisição com os dados de cadastro
    E enviada a requisição HTTP
    Então deverá ser recebido uma resposta válida

