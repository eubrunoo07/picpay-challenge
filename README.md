
# PicPay Challenge

Este projeto é um desafio técnico que simula um sistema de pagamento inspirado no PicPay. Ele permite realizar transferências entre usuários e envia emails de notificação tanto para o remetente quanto para o destinatário após a transação ser concluída.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **MongoDB**
- **Serviço de Envio de Emails**
- **Docker**

## Funcionalidades

- **Transferência entre usuários**: Realize transferências financeiras entre contas de usuários.
- **Envio de email**: Após uma transação, tanto o remetente quanto o destinatário recebem um email de confirmação.
- **Integração com MongoDB**: Armazenamento dos dados das transações e usuários no banco de dados NoSQL.
- **Docker**: O projeto pode ser facilmente containerizado e executado usando Docker.

## Como Executar o Projeto

### Pré-requisitos

Certifique-se de ter instalado:

- **Java 17+**
- **Maven**
- **Docker** (caso deseje rodar a aplicação em containers)

### Executando o Projeto Localmente

1. Clone o repositório:

   ```bash
   git clone https://github.com/eubrunoo07/picpay-challenge.git
   ```

2. Acesse o diretório do projeto:

   ```bash
   cd picpay-challenge
   ```

3. Execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

### Executando com Docker

Se preferir usar Docker, siga os passos:

1. Certifique-se de que o Docker está instalado e em execução.

2. Construa a imagem Docker:

   ```bash
   docker build -t picpay-challenge .
   ```

3. Execute o container:

   ```bash
   docker run -p 8080:8080 picpay-challenge
   ```

## Estrutura do Projeto

- `src/main/java`: Contém o código-fonte principal.
- `src/main/resources`: Contém arquivos de configuração, como `application.yml` e templates de email.
- `docker/docker-compose.yml`: Arquivo para construir a imagem Docker da aplicação.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais informações.
