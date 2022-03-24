# CRUD: Uma abordagem ["It's Time To Kick *** And Chew Bubblegum"](https://www.youtube.com/watch?v=D0GZ4Y9w6o0)

###### By: [@caiuzu](https://github.com/Caiuzu/)

![GitHub repo size](https://img.shields.io/github/repo-size/Caiuzu/crud)
![ViewCount](https://views.whatilearened.today/views/github/Caiuzu/crud.svg)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=bugs)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=code_smells)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=ncloc)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=coverage)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Java CI with Gradle](https://github.com/Caiuzu/crud/actions/workflows/gradle.yml/badge.svg)](https://github.com/Caiuzu/crud/actions/workflows/gradle.yml)

---

### Resumo:

> Este projeto tem por intuito introduzir o desenvolvedor a algumas tecnologias e ferramentas complementares, vastamente utilizadas no dia-a-dia.
> Através de um CRUD simples, implementaremos os itens descritos abaixo.

## Tecnologias/Ferramentas Utilizadas no Projeto:

- [x] Spring Initializr
- [x] Spring Boot
- [X] Gradle
- [X] Actuator
- [X] Springfox Swagger
- [X] JUnit 5
- [X] Cucumber
- [X] SonarCloud
- [X] CI/CD (GitHub Actions)
- [X] Commit Semântico
- [X] Discord Webhook

- [ ] Mockito

- [ ] PostgreSQL
- [ ] Lombok
- [ ] Pagination

- [ ] JPA
- [ ] Audited JPA Envers
- [ ] Validator

- [ ] Tratamento de Exceptions

- [ ] Docker
- [ ] Heroku
- [ ] New Relic


---

### Tecnologias a serem estudadas em projetos futuros:

- [ ] Apache Kafka
- [ ] Hystrix
- [ ] Spark
- [ ] AWS (AWS LocalStack)
  - [ ] S3
  - [ ] EC2
- [ ] Kubernetes
- [ ] Lombok
- [ ] Sleuth
- [ ] Zipkin UI
- [ ] Liquibase
- [ ] Spring Cloud Config (Remote Configuration)
- [ ] Spring Cloud Bus

---

## Como Contribuir?

Para organizar o nosso fluxo de trabalho, seguimos de forma conceitual o modelo do
[Git Flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow). Os passos para contribuir com
o projeto são:

- Criar uma feature branch a partir da `develop`;
- Desenvolver o que precisar nesta nova branch;
- Criar um Pull Request;
- Após a aprovação do Pull Request, a sua versão deve ser mergeada na `develop`.

É importante seguir os padrões
de [commit semântico](https://blog.geekhunter.com.br/o-que-e-commit-e-como-usar-commits-semanticos/)

<details>
<summary>Prefixos para commit:</summary>

- **build**: Alterações que afetam o sistema de construção ou dependências externas (escopos de exemplo: gulp, broccoli,
  npm),
- **ci**: Mudanças em nossos arquivos e scripts de configuração de CI (escopos de exemplo: Travis, Circle, BrowserStack,
  SauceLabs);
- **docs**: referem-se a inclusão ou alteração somente de arquivos de documentação;
- **feat**: Tratam adições de novas funcionalidades ou de quaisquer outras novas implantações ao código;
- **fix**: Essencialmente definem o tratamento de correções de bugs;
- **perf**: Uma alteração de código que melhora o desempenho;
- **refactor**: Tipo utilizado em quaisquer mudanças que sejam executados no código, porém não alterem a funcionalidade
  final da tarefa impactada;
- **style**: Alterações referentes a formatações na apresentação do código que não afetam o significado do código, como
  por exemplo: espaço em branco, formatação, ponto e vírgula ausente etc.);
- **test**: Adicionando testes ausentes ou corrigindo testes existentes nos processos de testes automatizados (TDD);
- **chore**: Atualização de tarefas que não ocasionam alteração no código de produção, mas mudanças de ferramentas,
  mudanças de configuração e bibliotecas que realmente não entram em produção;
- **env**: basicamente utilizado na descrição de modificações ou adições em arquivos de configuração em processos e
  métodos de integração contínua (CI), como parâmetros em arquivos de configuração de containers.
- **improvement**: commits que melhoram uma implementação atual sem adicionar um novo recurso ou consertar um bug.

-----

</details>

---