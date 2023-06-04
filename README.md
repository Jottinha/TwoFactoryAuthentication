# TwoFactoryAuthentication

Este projeto implementa um sistema de autenticação em duas etapas.

## Descrição
Neste projeto, foi desenvolvida uma solução de autenticação em duas etapas para garantir a segurança do login do usuário. O sistema funciona da seguinte forma:

1° O usuario faz o cadastro no banco de dados.

![image](https://user-images.githubusercontent.com/69482936/175384960-bc8748a5-43a4-469e-b1f4-765a9e36b10e.png)

2° Quando o usuario vai fazer o login no programa, um codigo é enviado no email cadastrado.

![image](https://user-images.githubusercontent.com/69482936/175385063-17e208c6-bde6-4c74-83eb-7f5921703f71.png)

![image](https://user-images.githubusercontent.com/69482936/175385102-90d7238e-c962-44da-9723-4b12f7320ac6.png)

3° O usuario so é logado se o codigo digitado no programa for igual ao do email

![image](https://user-images.githubusercontent.com/69482936/175385133-c0d1d333-d137-41d9-862d-1faaf8917213.png)

Esse projeto foi desenvolvido com fins acadêmicos e teve os seguintes objetivos:

- Aprofundar o conhecimento em bancos de dados e sua integração com a IDE.
- Colocar em prática os conceitos de CRUD (Create, Read, Update, Delete).
- Entender e utilizar o Maven para facilitar o gerenciamento de dependências.

## Instalação

1. Faça o clone deste repositório para o seu ambiente local.

2. Certifique-se de ter o Java e o Maven instalados em seu sistema.

3. Execute o comando `mvn install` para instalar as dependências do projeto.

## Uso

1. Configure as informações do banco de dados no arquivo `application.properties`.

2. Compile e execute o projeto usando o comando `mvn spring-boot:run`.

3. Acesse o programa e siga as instruções para criar um novo usuário e realizar o login com autenticação em duas etapas.

## Contribuição

Este projeto é apenas um exemplo acadêmico e não está aberto para contribuições externas. Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para entrar em contato.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

## Contato

Se você tiver alguma dúvida ou sugestão em relação a este projeto, entre em contato por e-mail: [seu-email@example.com](mailto:seu-email@example.com).
