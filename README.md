# CRUD: Uma abordagem ["It's Time To Kick *** And Chew Bubblegum"](https://www.youtube.com/watch?v=D0GZ4Y9w6o0)

###### By: [@caiuzu](https://github.com/Caiuzu/)

<!-- Badges -->
<p align="center">
   <a href="https://www.linkedin.com/">
      <img alt="Caio Souza" src="https://img.shields.io/badge/-Caio Souza-black?style=flat&logo=Linkedin&logoColor=white" />
   </a>
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/Caiuzu/crud"/>
  <img alt="Repository size" src="https://views.whatilearened.today/views/github/Caiuzu/crud.svg"/>

   <a href="https://sonarcloud.io/dashboard?id=Caiuzu_crud">
      <img alt="Bugs" src="https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=bugs" />
   </a>
   <a href="https://sonarcloud.io/dashboard?id=Caiuzu_crud">
      <img alt="Bugs" src="https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=bugs" />
   </a>
   <a href="https://sonarcloud.io/dashboard?id=Caiuzu_crud">
      <img alt="Code Smells" src="https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=code_smells" />
   </a>
   <a href="https://sonarcloud.io/dashboard?id=Caiuzu_crud">
      <img alt="Lines of Code" src="https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=ncloc" />
   </a>
   <a href="https://sonarcloud.io/dashboard?id=Caiuzu_crud">
      <img alt="Coverage" src="https://sonarcloud.io/api/project_badges/measure?project=Caiuzu_crud&metric=coverage" />
   </a>
   <a href="https://github.com/Caiuzu/crud/actions/workflows/gradle.yml">
      <img alt="Java CI with Gradle" src="https://github.com/Caiuzu/crud/actions/workflows/gradle.yml/badge.svg?branch=master" />
   </a>
  <img alt="License" src="https://img.shields.io/badge/license-MIT-black"/>
</p>


<!-- Indice-->  
<p align="center">  
 <a href="#resumo">Resumo</a> •
 <a href="#0-spring-initializr">Spring Initializr</a> •  
 <a href="#1-docker">Docker</a> •  
 <a href="#2-postgresql">PostgreSQL</a> •  
 <a href="#3-orm">ORM</a> •  
 <a href="#4-lombok">Lombok</a> •  
 <a href="#5-testes">Testes</a> •  
 <a href="#como-contribuir">Como Contribuir?</a>  
</p>  

---

### Resumo:

> Este projeto tem por intuito introduzir o desenvolvedor a algumas tecnologias e ferramentas complementares, vastamente
> utilizadas no dia-a-dia.
> Através de um CRUD simples, implementaremos os itens descritos abaixo.

### Tecnologias/Ferramentas Utilizadas no Projeto:

<details>
<summary>Tecnologias utilizadas e explicadas previamente no projeto <a href="https://github.com/Caiuzu/hello-world">hello-world</a>:</summary> 

- [X] [SDKMAN (Windows & Linux)]()
- [x] [Spring Initializr](https://github.com/Caiuzu/hello-world#0-spring-initializr)
- [x] [Spring Boot](https://github.com/Caiuzu/hello-world)
- [X] [Gradle](https://github.com/Caiuzu/hello-world)
- [X] [Actuator](https://github.com/Caiuzu/hello-world#1-actuator)
- [X] [Springfox Swagger](https://github.com/Caiuzu/hello-world#2-springfox-swagger2)
- [X] [JUnit 5](https://github.com/Caiuzu/hello-world#3-junit)
- [X] [Cucumber](https://github.com/Caiuzu/hello-world#4-cucumber)
- [X] [SonarCloud](https://github.com/Caiuzu/hello-world#7-integrações-discord-webhook)
- [X] [CI/CD (GitHub Actions)](https://github.com/Caiuzu/hello-world#7-integrações-discord-webhook)
- [X] [Commit Semântico](https://github.com/Caiuzu/hello-world#como-contribuir)
- [X] [Discord Webhook](https://github.com/Caiuzu/hello-world#7-integrações-discord-webhook)
- [X] [GitHooks (preparando commit lint e garantindo organização)]()

</details>


<details>
<summary>Novas Tecnologias utilizadas neste projeto:</summary> 

- [X] JUnit 5 (Complementando)
    - Considerar a utilização do Teste Unitário para tudo, menos entidades e controller( nos controllers utilizar teste
      de integração com cucumber)

- [X] Docker
    - [X] Docker Composer
    - [X] Portainer.io
    - [X] PostgreSQL

- [ ] ORM
    - [X] JPA
        - [ ] Audited JPA Envers
        - [ ] Hibernate Envers
    - [X] Hibernate

- [X] Testes
    - [X] Mockito
    - [X] Factory

- [X] Core
    - [X] Lombok
    - [ ] Pagination
    - [ ] VO
    - [ ] Validator
    - [ ] Tratamento de Exceptions
    - [ ] Builder

- [ ] AWS
- [ ] New Relic

</details>

---

## 0. Spring Initializr:

- ### O que é:
    - **Spring Initializr** fornece uma interface web bem simples para o usuário. Podendo gerar seu projeto a partir de
      uma estrutura de configurações pré-moldadas. São configurações de versões do java/spring boot, grupo/nome do
      projeto, série de lista de dependências, etc.

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
    - >
      Source: [Tutorial DigitalOcean](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04)

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
    - **PostgreSQL**, trata-se de um SGBD relacional, orientado a objetos, em que objetos definidos pelo usuário e a
      abordagem de tabela são combinados para criar estruturas mais complexas de dados. Além disso, o PostgreSQL tem
      muitas semelhanças com o MySQL. Suporta nativamente um grande número de categorias de dados padrão, como JSON,
      XML, etc.
        - É um dos poucos bancos de dados relacionais que **oferece forte suporte para a funcionalidade NoSQL**.
        - Permite que os usuários definam seus **próprios tipos de dados**.
        - A **escalabilidade vertical** é um recurso do PostgreSQL. Como quase todas as soluções de ‘software’
          personalizadas tendem a crescer, resultando na expansão do banco de dados, essa opção oferece suporte ao
          crescimento e ao desenvolvimento dos negócios muito bem.
        - Oferece **suporte a ferramentas adicionais**, tanto gratuitas quanto comerciais.

- ### Configurando e conectando PostgreSQL no projeto:
  <details>
  <summary>Configurando e conectando PostgreSQL no projeto:</summary>

  #### 1 - Conectando banco:

    - **Após configurado nosso container seguindo os passos do item anterior, iremos conectar o banco à nossa
      aplicação**:

        - Primeiramente, iremos adicionar as seguintes linhas de dependência em nosso
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

## 3. ORM:

- ### O que é:
    - **ORM** é um acrônimo para "Object-Relational Mapping", sendo uma categoria de tecnologia que permite que um
      aplicativo manipule dados em uma base de dados de maneira mais simples e intuitiva, usando objetos e classes em
      vez de instruções SQL diretas.
        - **JPA(Java Persistence API)**: É uma especificação de persistência de objetos que pode ser usada para
          implementar uma ORM. Ela define uma maneira de mapear objetos do Java para tabelas em uma base de dados,
          bem como uma maneira de recuperar e armazenar esses objetos de volta na base de dados. JPA é uma especificação
          e não fornece uma implementação concreta dessa API.
        - **Hibernate**: Já o Hibernate é uma biblioteca que fornece uma implementação concreta da API JPA, permitindo
          que os desenvolvedores usem o Hibernate para mapear objetos do Java para tabelas em uma base de dados e
          recuperar e armazenar esses objetos de volta na base de dados. Ou seja, pode ser usada como uma ORM. Hibernate
          é uma das opções mais populares e amplamente utilizadas.


- ### Configurando e Implementando JPA no projeto:
  <details>
  <summary>Configurando e Implementando JPA no projeto:</summary>

  Para configurar o JPA com Hibernate em nosso projeto, seguiremos os seguintes passos:
    - Adicionaremos as dependências do JPA e do PostgreSQL ao arquivo [build.gradle](./build.gradle) do projeto.
    ```yaml
        dependencies {
          // Spring Boot
          implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  
          // PostgreSQL
          runtimeOnly 'org.postgresql:postgresql'
        }
    ```
    - Criaremos um arquivo [application.yml](./src/main/resources/application.yml) na raiz do projeto com as
      configurações de conexão com o banco de dados.
    ```yaml
        spring:
          datasource:
            url: jdbc:postgresql://localhost:5432/crudDB
            username: admin
            password: admin
            driver-class-name: org.postgresql.Driver
            hikari:
              connection-test-query: select 1
          jpa:
            hibernate:
              ddl-auto: create
            properties:
              hibernate:
                dialect: org.hibernate.dialect.PostgreSQLDialect
                format_sql: true
                show_sql: true
                use_sql_comments: true
                jdbc:
                  lob:
                    non_contextual_creation: true
    ```
    - Em seguida criamos nossa [entidade](./src/main/java/br/com/simple/crud/domain/entity/Student.java) que será
      nossa camada responsável por mapear os objetos do Java para tabelas no banco de dados.
        - Anotaremos a classe com `@Entity` e iremos mapear os atributos para as colunas da tabela usando anotações como
          `@Column`.
    ```java
        @Entity
        public class Student {
      
        @Id
        @Column(nullable = false)
        @GeneratedValue(strategy = SEQUENCE, generator = "STUDENT_SEQ")
        @EqualsAndHashCode.Include
        private Long id;
        
            @Column(nullable = false)
            @NotEmpty(message = "Nome não informado")
            @Length(max = 10, message = "Nome muito extenso")
            private String name;
        // Getters e setters serão gerados pelo lombok (@Getter e @Setter)
        //[...]
        }

    ```
    - Agora, vamos criar a camada de [repository](./src/main/java/br/com/simple/crud/repository/StudentRepository.java),
      que será responsável por acessar os dados no banco de dados. Para isso, crie uma interface que estenda
      JpaRepository e especifique o tipo de entidade e o tipo de chave que ela utiliza. Por exemplo:
    ```java
        public interface StudentRepository extends JpaRepository<Student, Long> {
        }
    ```

    - Para utilizar iremos realizar a injeção no Service desejado via construtor parametrizado.
        - Como estamos utilizando lombok anotaremos nosso Service com @RequiredArgsConstructor;
    ```java
        @Service
        @RequiredArgsConstructor
        @Slf4j
        public class StudentService {
            private final StudentRepository studentRepository;
            //[...]
        }
    ```
    - Com essas etapas configuradas, o JPA estará pronto para ser usado no projeto Spring Boot com Gradle. Você poderá
      acessar os dados no banco de dados usando os métodos do repositório, como `findById()`, `findAll()`, `save()`
      e `delete()`. Além disso, você também pode criar consultas personalizadas usando a anotação `@Query` na interface
      de repositório. Por exemplo:
    ```java
        public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
          @Query("SELECT p FROM Pessoa p WHERE p.nome = :nome")
          List<Pessoa> findByNome(@Param("nome") String nome);
        }
    ```

    - Essa consulta personalizada pode ser usada da seguinte maneira:
    ```java
        List<Pessoa> pessoas = repository.findByNome("Robson");
    ```
    - É importante lembrar ser necessário criar as tabelas no banco de dados manualmente ou automático (ddl-auto =
      create) antes de tentar acessá-las usando o JPA.

  </details>

- ### Mais Informações:
  > [Learn JPA & Hibernate](https://www.baeldung.com/learn-jpa-hibernate)

---

## 4. LOMBOK:

- ### O que é:
    - **Lombok** é uma biblioteca de código aberto para Java que fornece uma série de anotações para gerar
      automaticamente código boilerplate, como getters, setters, construtores e métodos `toString()`, `equals()` e
      `hashCode()`. Isso pode tornar o processo de desenvolvimento de aplicativo Java mais rápido e mais fácil, pois
      permite que os desenvolvedores evitem escrever código repetitivo manualmente.


- ### Configurando e Implementando Lombok no projeto:
  <details>
  <summary>Configurando e Implementando Lombok no projeto:</summary>

  Para adicionar o Lombok ao projeto, basta adicionar a dependência do Lombok ao arquivo [build.gradle](./build.gradle)
  do projeto da seguinte forma:
    ```yaml
        dependencies {
          // Lombok
          compileOnly 'org.projectlombok:lombok'
          annotationProcessor 'org.projectlombok:lombok'
        }
    ```
    - Desta forma podemos usar as anotações do Lombok em nossas classes. Por exemplo, como em nossa
      classe [Student](src/main/java/br/com/simple/crud/domain/entity/Student.java), para gerar `getters` e `setters`
      automaticamente, adicionaremos a anotação `@Getter` e `@Setter` (removendo o Setter apenas do id):
    ```java
    //[...] outras anotações
    @Getter
    @Setter
    public class Student {
  
        @Setter(AccessLevel.NONE)
        private Long id;
  
        private String name;
  
        private String lastName;
  
        private Integer age;
  
    }
    ```

    </details>

- ### Entendendo um pouco mais sobre Lombok:
  <details>
  <summary>Anotações mais utilizadas do Lombok:</summary>

  Abaixo temos algumas das anotações mais utilizadas do Lombok:
    - `@Getter`: Gera getters automaticamente para todos os atributos da classe.
    - `@Setter`: Gera setters automaticamente para todos os atributos da classe.
    - `@ToString`: Gera um método toString() automaticamente que retorna uma ‘string’ com os valores de todos os
      atributos da classe.
    - `@EqualsAndHashCode`: Gera os métodos equals() e hashCode() automaticamente conforme as regras padrão do Java.
    - `@NoArgsConstructor`: Gera um construtor sem argumentos automaticamente.
    - `@AllArgsConstructor`: Gera um construtor com argumentos para todos os atributos da classe.
    - `@RequiredArgsConstructor`: Gera um construtor com argumentos apenas para os atributos marcados com @NonNull.
    - `@Data`: Inclui todas as anotações @Getter, @Setter, @ToString, @EqualsAndHashCode e @RequiredArgsConstructor
      em uma só, permitindo gerar getters, ‘setters’, um método toString(), métodos equals() e hashCode() e um
      construtor com argumentos para os atributos marcados com @NonNull automaticamente.
    - `@Value`: Similar à anotação @Data, mas cria uma classe imutável em vez de uma classe mutável. Isso significa
      que os ‘setters’ não são gerados e os atributos só podem ser atribuídos no construtor.
    - `@Builder`: Gera um builder para a classe, permitindo criar objetos da classe de forma fluida.
    - `@SneakyThrows`: Permite lançar exceções checked de forma silenciosa, sem precisar declará-las no método.
    - `@Synchronized`: Adiciona sincronização a um método, permitindo que ele seja chamado por apenas uma thread de
      cada vez.
    - `@Log`: Gera uma variável de log para a classe, permitindo logar mensagens usando o log4j ou outro framework
      de log.
  </details>

- ### Mais Informações:
  > [Project Lombok](https://projectlombok.org)
  
  > [Java 14 Record vs. Lombok](https://www.baeldung.com/java-record-vs-lombok) 

  > [Introduction to Project Lombok](https://www.baeldung.com/intro-to-project-lombok)
---

## 5. Testes:

- ### Retomando o assunto:
    - No [projeto anterior](https://github.com/Caiuzu/hello-world) abordamos as configurações do Junit5 e Cucumber.
      Neste, iremos entrar em alguns detalhes de implementação que nos leva a um novo passo devido o aumento da
      complexidade da aplicação em questão.

- ### Mergulhando no JUnit5 | Mockito:
  <details>
  <summary>Um pouco sobre Mockito:</summary>

  **Mockito** é uma biblioteca de mocks para Java que permite criar objetos "falsos" ou "simulados" para testar o
  código. Os
  mocks são usados para simular o comportamento de dependências ou colaboradores de uma classe, permitindo que os testes
  sejam isolados e focados em uma única unidade de código.

  Isso é especialmente útil quando precisamos testar código
  que depende de outras classes ou componentes que não estão disponíveis ou são difíceis de testar, como banco de dados,
  APIs externas ou componentes de sistema.
    - Para usar o Mockito em um projeto JUnit 5, basta adicionar a dependência do Mockito ao arquivo build.gradle do
      projeto e importar a classe MockitoExtension no seu arquivo de teste. Por exemplo:
    - Podemos observar a utilização do mock em nossa classe de
      teste [StudentServiceTest](src/test/java/br/com/simple/crud/service/StudentServiceTest.java)
  </details>

- ### Mergulhando no JUnit5 | Factory:
  <details>
  <summary>Um pouco sobre Factory:</summary>

  **Factory** são classes que criam objetos de outras classes de acordo com alguns parâmetros ou configurações. Isso é
  útil para evitar a repetição de código na criação de objetos e para facilitar a configuração de objetos para testes.
    - Temos algumas factories criadas no projeto como: `StudentFactory`, `StudentRequestDtoFactory`
      e `StudentResponseDtoFactory`.
    - Podemos observar a utilização do factory em nossa classe de
      teste [StudentServiceTest](src/test/java/br/com/simple/crud/service/StudentServiceTest.java)

  </details>

- ### Mergulhando no Cucumber ( ͡° ͜ʖ ͡°) | Datatable:
  <details>
  <summary>Um pouco sobre Datatable:</summary>

  Anteriormente no projeto [hello-world](https://github.com/Caiuzu/hello-world), vimos como configurar o cucumber no
  projeto. Agora iremos complementar com uma técnica de passagem de dados, principalmente quando queremos representar
  tableas ou objetos, o Datatable.

  Sempre devemos utilizar o datable para passagem de dados/ "variaveis", pois o cucumber é na teoria vizualizado pela
  equipe de QA e Negócios.
    - Desta forma facilitando a leitura e mudança de dados para teste
    - Pode também ser integrado com algumas ferramentas como, por exemplo, o jira cucucmber integration

  No projeto podemos ver como é montado um [cenário de teste](src/test/resources/features/CrudFeatures.feature)
  utilizando datatable:
  ```gherkin
  Cenário: Adiciona dado de um novo estudante
    Dado que possuo as informações do estudante
      | name   | last_name | age |
      | Ragnar | L         | 18  |
    Quando envio as informações do meu estudante
    Então deverá ser cadastrado com sucesso
  ```
  Como o datatable é uma entrada de dado crua, precisamos criar um adaptador para utilizar esses dados. Desta forma,
  criamos na
  classe [StudentDataTableAdapter](src/test/java/br/com/simple/crud/cucumber/adapter/StudentDataTableAdapter.java) um
  tratamento para
  criar um StudentRequestDto apartir dos dados informados. Assim podendo ser utilizado normalmente na implementação
  dos [Steps](src/test/java/br/com/simple/crud/cucumber/step/Steps.java).

  ```java
    public List<StudentRequestDto> createStudentList(final DataTable dataTable) {
        return dataTable
                .asMaps(String.class, String.class)
                .stream()
                .map(column -> {
                    return new StudentRequestDto(column.get(NAME), column.get(LAST_NAME), Integer.parseInt(column.get(AGE)));
                }).collect(Collectors.toList());
    }
  ```
  </details>


- ### Mais Informações:
  > [Complete JUnit 5 Mockito Tutorial For Unit Testing](https://www.lambdatest.com/blog/junit5-mockito-tutorial/)

  > [Cucumber Data Tables - baeldung](https://www.baeldung.com/cucumber-data-tables)

---

## Tecnologias a serem estudadas em projetos futuros:

- [ ] Json Patch
- [ ] Spring Auth
- [ ] Apache Kafka
- [ ] Hystrix
- [ ] Spark ( e TDD para RDD)
- [ ] AWS (AWS LocalStack)
    - [ ] S3
    - [ ] EC2
- [ ] Kubernetes
- [ ] Sleuth
- [ ] Zipkin UI
- [ ] Spring Cloud Config (Remote Configuration)
- [ ] Spring Cloud Bus
- [ ] Migrations (FlyWay vs Liquibase)
- [ ] Aplicar separação da camada de ORM(framework) da Entidade

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