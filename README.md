
# Fluxo de Integração com Arquitetura Hexagonal

Este repositório contém a implementação de um fluxo de integração que utiliza a arquitetura hexagonal (Ports and Adapters) para garantir a separação de preocupações e facilitar a manutenção e testabilidade do código. O sistema é composto por vários módulos que interagem entre si para processar eventos, gerar relatórios e processar pagamentos.

## Diagrama de Fluxo

![ohno](https://github.com/user-attachments/assets/2712f772-2ab5-45d4-ab5b-a84bfa57553d)

## Componentes Principais

- **CodeInBook**: O núcleo da aplicação, que contém a API principal (`cib-api`) responsável por receber as interações do usuário e coordenar as operações.
- **Banco de Dados CIB**: Armazena os dados principais da aplicação.
- **Kafka**: Sistema de mensageria utilizado para publicar e consumir eventos entre os diferentes módulos.
- **ReportAPI**: Módulo responsável por consumir eventos do Kafka e armazenar dados no Banco de Relatórios.
- **PaymentAPI**: Módulo que consome eventos do Kafka e processa pagamentos, armazenando as informações no Banco de Pagamentos.

## Fluxo de Operação

1. **Interação do Usuário**: O usuário interage com a aplicação através da interface fornecida pelo `CodeInBook`.
2. **Chamada API**: A interação do usuário é processada pela `cib-api`, que acessa o Banco de Dados CIB para recuperar ou armazenar informações.
3. **Publicação de Evento**: A `cib-api` publica um evento no Kafka para notificar outros módulos sobre a operação realizada.
4. **Consumo de Evento**:
    - **ReportAPI**: Consome o evento do Kafka e armazena os dados relevantes no Banco de Relatórios.
    - **PaymentAPI**: Consome o mesmo evento e processa o pagamento, armazenando as informações no Banco de Pagamentos.

## Como Executar

Para executar o projeto, siga as instruções no arquivo `README.md` na raiz do repositório. Certifique-se de que todas as dependências estão instaladas e que os serviços necessários (como Kafka e bancos de dados) estão em execução.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests para melhorar o projeto.