# CRUD: Uma abordagem ["It's Time To Kick *** And Chew Bubblegum"](https://www.youtube.com/watch?v=D0GZ4Y9w6o0)

###### By: [@caiuzu](https://github.com/Caiuzu/)

![GitHub repo size](https://img.shields.io/github/repo-size/Caiuzu/crud)
![ViewCount](https://views.whatilearened.today/views/github/Caiuzu/crud.svg)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=bugs)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=code_smells)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=ncloc)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=coverage)](https://sonarcloud.io/dashboard?id=Caiuzu_crud)
[![Java CI with Gradle](https://github.com/Caiuzu/crud/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/Caiuzu/crud/actions/workflows/gradle.yml)
---

### Resumo:

> Este projeto tem por intuito introduzir o desenvolvedor a algumas tecnologias e ferramentas complementares, vastamente
> utilizadas no dia-a-dia.
> Através de um CRUD simples, implementaremos os itens descritos abaixo.

## Tecnologias/Ferramentas Utilizadas no Projeto:

##### Tecnologias utilizadas e explicadas previamente no projeto [hello-world](https://github.com/Caiuzu/hello-world):

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

##### Novas Tecnologias:

- [X] Docker
    - [X] Portainer.io
    - [X] PostgreSQL

- [ ] ORM
  - [X] Hibernate
  - [X] JPA
    - [ ] Audited JPA Envers 

- [ ] Testes
  - [ ] Mockito
  - [ ] Factory

- [ ] Core
  - [X] Lombok
  - [X] Pagination
  - [X] VO
  - [ ] Validator
  - [ ] Tratamento de Exceptions

- [ ] Heroku
- [ ] New Relic

---

## 0. Spring Initializr:

- ### O que é:
    - **Spring Initializr** fornece uma interface web bem simples para o usuário. Podendo gerar seu projeto a partir de
      uma estrutura de configurações pré-moldadas. São configurações de versões do java/spring boot, grupo/nome do
      projeto, série de lista de dependências e etc.

- ### Inicializando projeto com Spring initializr:
  <details>
  <summary>Inicializando nosso projeto com Spring initializr:</summary>

    - Inicializaremos o projeto através do [spring initializr](http://start.spring.io) utilizando os parâmetros
      abaixo:

        - **Project**: Gradle Project;
            - **Language**: Java;
            - **Spring Boot**: 2.6.5;
            - **Project Metadata**:
                - **Group**: br.com.simple
                - **Artifact**: crud
                - **Name**: crud
                - **Description**: Simple CRUD API
                - **Package name**: br.com.simple.crud
                - **Packaging**: jar
                - **Java**: 11
            - **Dependencies**: Spring Web, Spring Data JPA, PostgreSQL Driver, Lombok

  </details>

- ### Spring Quickstart:
  > [Spring Quickstart](https://spring.io/quickstart)

---


## 1. Docker:

### Configurando Docker e Docker-Compose:

> Antes de seguir os passos abaixo, garanta que seu docker está instalado conforme explicado no inicio deste documento.

- ### O que é:
    - **Docker**, é basicamente um container. Ele usa os próprios recursos do kernel de nosso SO para "simular" uma nova
      máquina. Diferente de como faz uma VM (que gera um novo SO para realizar esta tarefa).
    - O **docker-compose** faz a orquestração desses containers. Assim, possibilitando uma infra local rápida e
      eficiente.

- ### Preparando ambiente Docker:
  <details>
  <summary>Entendendo e Configurando Docker Composer no projeto:</summary>

  ### 1.1. Preparando ambiente Docker:
    - > Source: [Tutorial DigitalOcean](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04)

      #### 1.1.1 — Instalando Docker

        - Primeiro, atualize sua lista existente de pacotes:
          ```shell
          sudo apt update
          ```

        - Em seguida, instale alguns pacotes de pré-requisitos que permitem ao apt usar pacotes sobre HTTPS:
          ```shell
          sudo apt install apt-transport-https ca-certificates curl software-properties-common
          ```

        - Em seguida, adicione a chave GPG para o repositório oficial do Docker ao seu sistema:
          ```shell
          curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
          ```

        - Adicione o repositório Docker às fontes APT:
          ```shell
          sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
          ```

        - Em seguida, atualize o banco de dados de pacotes com os pacotes Docker do repo recém-adicionado:
          ```shell
          sudo apt update
          ```

        - Certifique-se de que está prestes a instalar a partir do repositório Docker em vez do repositório Ubuntu
          padrão:
          ```shell
          apt-cache policy docker-ce
          ```

          _Observe que docker-ce não está instalado, mas o candidato para instalação é do repositório Docker para Ubuntu
          20.04 (focal)._
          Finalmente, instale o Docker:
            ```shell
            sudo apt install docker-ce
            ```

        - O Docker agora deve estar instalado, o daemon iniciado e o processo habilitado para iniciar na inicialização.
          Verifique se ele está funcionando:
            - **LINUX**:
              ```shell
              sudo systemctl status docker 
              ```
            - **WSL2**:
              ```shell
              sudo /etc/init.d/docker status 
              ```

      #### 1.1.2 — Executando o comando Docker sem Sudo (opcional)

        - Se quiser evitar digitar sudo sempre que executar o comando docker, adicione seu nome de usuário ao grupo
          docker:
          ```shell
          sudo usermod -aG docker ${USER}
          ```

        - Para aplicar a nova associação de grupo, saia do servidor e entre novamente ou digite o seguinte:
          > Você será solicitado a inserir sua senha de usuário para continuar.
          ```shell
          su - ${USER}
          ```
        - Confirme se o seu usuário foi adicionado ao grupo docker digitando:
          ```shell
          id -nG
          ```

          > _**Output**: sammy sudo docker_

        - listar docker e rodar teste:
          ```shell
          docker ps
          ```
          ```shell
          docker run hello-world
          ```
        - Instale também o docker compose (utilizaremos 1.28.2)
          ```shell
          sudo curl -L "https://github.com/docker/compose/releases/download/1.28.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
          ```
        - dando permissão de execução para docker-compose:
          ```shell
          sudo chmod +x /usr/local/bin/docker-compose
          ```
        - Verificando versão:
          ```shell
          docker-compose --version
          ```

  </details>

- ### Instalando Portainer.io:
  <details>
  <summary>Instalando Portainer.io:</summary> 

  ### 2 — Instalando Portainer.io
  Iremos instalar o [portainer.io](https://www.portainer.io) para termos uma visualização dos containers via UI:

    - Criando volume:
      ```shell
        docker volume create portainer_data
      ```
    - Instalando portainer no volume:
      ```shell
        docker run -d -p 8000:8000 -p 9000:9000 --name=portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce
      ```
    - Para acessar: http://localhost:9000/

  </details>

- ### Entendendo e Configurando Docker Composer no projeto:
  <details>
  <summary>Entendendo e Configurando Docker Composer no projeto:</summary>

  ### 3.1. Comandos mais utilizados:

  > Antes de utiliza-los, devemos estar no diretório, no terminal:

    - **Iniciar serviço docker**:
        - **WSL**: `sudo /etc/init.d/docker start`;
        - **Linux**: `sudo systemctl start docker`;
    - **Iniciar**: `docker-compose up -d`;
    - **Listar containers**: `docker ps`;
    - **Derrubar os container e remover os volumes**: `docker-compose down`.

  ### 3.2. Serviços no container:

    - Iremos criar um diretório [docker](./docker) em nosso projeto e criaremos o arquivo de configuração
      [docker-compose.yml](./docker/docker-compose.yml).

    - Antes, temos que identificar o que queremos conteinerizar. Para este projeto será apenas nosso banco de dados;

    - Vamos entender nosso [docker-compose.yml](./docker/docker-compose.yml):

        ````yaml
          version: '3.7'
          services:
            crud-database:
              # image to fetch from docker hub
              image: postgres:latest
  
              # Environment variables for startup script
              # container will use these variables
              # to start the container with these define variables. 
              environment:
                POSTGRES_PASSWORD: admin
                POSTGRES_USER: admin
                POSTGRES_DB: crudDB
              container_name: crud-database
  
              # Mapping of container port to host
              ports:
                - "5432:5432"
        ````

        - `version ‘3.7’`: Isso indica que estamos usando a versão 3.7 do Docker Compose, e o Docker fornecerá os
          recursos apropriados.

        - `services`: Esta seção define todos os diferentes contêineres que criaremos. Em nosso projeto, temos cinco
          serviços (
          dois bancos, kafka, etc).

        - `database-checkout`: Este é o nome do nosso serviço de banco de dados. O Docker Compose criará contêineres com
          o nome que fornecemos.

        - `image`: Se não tivermos um Dockerfile e quisermos executar um serviço usando uma imagem pré-construída,
          especificamos o local da imagem usando a cláusula image. O Compose fará um fork de um contêiner dessa imagem.

        - `ports`: Isso é usado para mapear as portas do contêiner para a máquina host.

        - `environment`: A cláusula nos permite configurar uma variável de ambiente no contêiner. É o mesmo que o
          argumento -e no Docker ao executar um contêiner.

        - Os parâmetros `POSTGRES_PASSWORD`, `POSTGRES_USER`, `POSTGRES_DB`, indicam ao docker, para inicializar nosso
          banco de dados com o usuário de conexão pré-configurado.

  -----

  </details>

- ### Mais Informações:
  > [Docker in 100 Seconds](https://www.youtube.com/watch?v=Gjnup-PuquQ)

-----

## 2. PostgreSQL:

### Banco de Dados Relacional:

> Um banco de dados relacional é um banco de dados que modela os dados de uma forma que eles sejam percebidos pelo
> usuário como tabelas, ou mais formalmente relações..

- ### O que é:
    - **PostgreSQL**, trata-se de um SGBD relacional, orientado a objetos, no qual objetos definidos pelo usuário e a
      abordagem de tabela são combinados para criar estruturas mais complexas de dados. Além disso, o PostgreSQL tem
      muitas semelhanças com o MySQL. Suporta nativamente um grande número de tipos de dados padrão, como JSON, XML,
      etc.
        - É um dos poucos bancos de dados relacionais que **oferece forte suporte para a funcionalidade NoSQL**.
        - Permite que os usuários definam seus **próprios tipos de dados**.
        - A **escalabilidade vertical** é um recurso do PostgreSQL. Como quase todas as soluções de software
          personalizadas tendem a crescer, resultando na expansão do banco de dados, essa opção oferece suporte ao
          crescimento e ao desenvolvimento dos negócios muito bem.
        - Oferece **suporte a ferramentas adicionais**, tanto gratuitas quanto comerciais.

- ### Configurando e conectando PostgreSQL no projeto:
  <details>
  <summary>Configurando e conectando PostgreSQL no projeto:</summary>

  #### 1 - Conectando banco:

    - **Após configurado nosso container seguindo os passo do item anterior, iremos conectar o banco à nossa
      aplicação**:

        - Primeiramente, iremos adicionar as seguinte linhas de dependência em nosso
          arquivo [build.gradle](./build.gradle)

          ```
              dependencies {
                  // PostgreSQL
                  runtimeOnly 'org.postgresql:postgresql'
              }
          ```
        - Em seguida, em [application.yml](./src/main/resources/application.yml), iremos colocar as propriedades com
          dados
          de conexão:
          ```yaml
          spring:
          datasource:
            url: jdbc:postgresql://localhost:5432/crudDB
            username: admin
            password: admin
            driver-class-name: org.postgresql.Driver
            hikari:
              connection-test-query: select 1
          ```
        - Desta forma, com o container inicializado, ao rodar a aplicação, teremos nossa conexão entre aplicação e banco
          de dados.
  -----

  </details>

- ### Mais Informações:
  > [Curso de PostgreSQL - Bóson Treinamentos](https://www.youtube.com/playlist?list=PLucm8g_ezqNoAkYKXN_zWupyH6hQCAwxY)

---



## Tecnologias a serem estudadas em projetos futuros:

- [ ] Json Patch
- [ ] Builder
- [ ] Spring Auth
- [ ] Apache Kafka
- [ ] Hystrix
- [ ] Spark
- [ ] AWS (AWS LocalStack)
    - [ ] S3
    - [ ] EC2
- [ ] Kubernetes
- [ ] Sleuth
- [ ] Zipkin UI
- [ ] Spring Cloud Config (Remote Configuration)
- [ ] Spring Cloud Bus
- [ ] Migrations (FlyWay vs Liquibase)
- [ ] SDKMAN (Windows & Linux)

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