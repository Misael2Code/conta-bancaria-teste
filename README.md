# 🏦 Sistema de Conta Bancária em Java

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Bootcamp](https://img.shields.io/badge/Bootcamp-Itaú%20Java%20com%20IA-orange?style=for-the-badge)](https://web.dio.me/track/0d6c76e7-ab8d-4959-b015-248abde232dc)
[![Platform](https://img.shields.io/badge/DIO-Digital%20Innovation%20One-blueviolet?style=for-the-badge)](https://www.dio.me/)
[![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)](#)

Aplicação interativa via console desenvolvida em **Java** para simulação e gerenciamento de uma conta bancária com regras de negócio para concessão, controle e cobrança de juros de **cheque especial**.

---

## 📌 Contexto do Projeto

Este projeto é um exercício prático desenvolvido durante o **Bootcamp Itaú - Java com Inteligência Artificial**, disponível na plataforma da **[Digital Innovation One (DIO)](https://web.dio.me/track/0d6c76e7-ab8d-4959-b015-248abde232dc)**.

O objetivo do desafio é aplicar e consolidar fundamentos essenciais da linguagem Java e da Programação Orientada a Objetos (POO), tais como:
- Modelagem de classes e encapsulamento de estado (`ContaBancaria`).
- Implementação de regras de negócio financeiras (depósito, saque, pagamento de boletos, limites e juros).
- Controle de fluxo e manipulação de entrada de dados no terminal com `Scanner` (`App`).
- Tratamento de saldo negativo e transição para uso do limite de crédito emergencial (cheque especial).

---

## 🎯 O que a Aplicação Faz

A aplicação oferece uma interface interativa via terminal onde o usuário cria uma conta bancária com um saldo inicial e pode executar diversas operações financeiras em tempo real:

1. **Criação de Conta Bancária**:
   - Define o saldo inicial da conta.
   - Concede automaticamente um limite de cheque especial com base no valor inicial informado.

2. **Consulta de Saldo**:
   - Apresenta o saldo líquido atual da conta (positivo ou devedor).

3. **Consulta de Cheque Especial**:
   - Exibe o limite de crédito disponível no cheque especial no momento da consulta.

4. **Depósito com Quitação Inteligente**:
   - Adiciona fundos à conta bancária.
   - Se o cliente estiver com saldo devedor (utilizando o cheque especial), calcula automaticamente a cobrança da taxa de 20% sobre o valor utilizado e restabelece o limite de cheque especial assim que a dívida for coberta.

5. **Saque de Dinheiro**:
   - Permite a retirada de valores considerando o saldo em conta somado ao limite de cheque especial disponível.
   - Notifica o cliente caso a operação faça uso do cheque especial.

6. **Pagamento de Boleto**:
   - Realiza o pagamento de títulos e contas, consumindo primeiro o saldo disponível e, se necessário, o limite de cheque especial.

7. **Verificação de Uso do Cheque Especial**:
   - Informa imediatamente se a conta está ou não operando com saldo devedor (em cheque especial).

---

## 📋 Regras de Negócio

| Regra | Descrição |
| :--- | :--- |
| **Limite Combinado** | O cliente pode movimentar operações (saque/boleto) até o montante total de `Saldo + Cheque Especial`. |
| **Concessão de Limite** | O limite de cheque especial é estipulado no momento da criação da conta, proporcionalmente ao saldo inicial depositado (para depósitos iniciais até R$ 500,00 ou percentual para valores superiores). |
| **Cobrança de Juros** | Ao utilizar o limite do cheque especial (saldo negativo), incide uma taxa de **20%** sobre o valor utilizado, debitada no momento em que um novo depósito for realizado. |
| **Restauração de Limite** | Quando um depósito for suficiente para quitar a dívida e os juros acumulados, o limite autorizado do cheque especial é restabelecido integralmente. |

---

## 📁 Estrutura de Arquivos

```text
conta-bancaria-test/
├── .vscode/
│   └── settings.json          # Configuração de paths e bibliotecas para o VS Code
├── bin/
│   ├── App.class              # Bytecode compilado da aplicação principal
│   └── ContaBancaria.class    # Bytecode compilado da classe de domínio
├── src/
│   ├── App.java               # Classe principal: fluxo do console, menus e I/O
│   └── ContaBancaria.java     # Regras de negócio, cálculo de juros e estado da conta
└── README.md                  # Documentação do projeto
```

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java (versão 11 ou superior)
- **Paradigma**: Programação Orientada a Objetos (POO)
- **I/O**: `java.util.Scanner` para interação via console
- **Ambiente Recomendado**: VS Code, IntelliJ IDEA, Eclipse ou Terminal puro

---

## 🚀 Como Executar e Testar

### Pré-requisitos
Certifique-se de ter o **Java Development Kit (JDK 11+)** instalado em sua máquina. Para verificar:

```bash
java -version
javac -version
```

---

### Opção 1: Executando pelo Terminal / Prompt de Comando

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/SEU-USUARIO/conta-bancaria-test.git
   cd conta-bancaria-test
   ```

2. **Compile as classes:**
   ```bash
   javac -d bin src/*.java
   ```
   *(No Windows PowerShell ou CMD, você também pode usar: `javac -d bin src/ContaBancaria.java src/App.java`)*

3. **Execute a aplicação:**
   ```bash
   java -cp bin App
   ```

---

### Opção 2: Executando pelo VS Code

1. Abra a pasta do projeto no **Visual Studio Code**.
2. Certifique-se de ter a extensão **Extension Pack for Java** instalada.
3. Abra o arquivo [`src/App.java`](file:///src/App.java).
4. Clique no botão **Run** acima do método `main` ou pressione `F5` (Run Without Debugging: `Ctrl + F5`).
5. Interaja com o programa diretamente pelo painel do **Terminal Integrado**.

---

## 💻 Exemplo de Uso Interativo

```text
=============================================================================
== Olá! Bem-vindo à conta bancária do teste do Bootcamp Itaú - Java com IA ==
=============================================================================
=> Digite "I" para iniciar a aplicação ou "S" para sair.
I
=> Aplicação iniciada!

[ Bem-vindo! Vamos criar sua conta bancária ]
=> Digite o saldo inicial da conta:
1000
Conta criada com sucesso! 

Digite o número para o menu desejado:
1 - Consultar Saldo
2 - Consultar Cheque Especial
3 - Depositar Dinheiro
4 - Sacar Dinheiro
5 - Pagar Boleto
6 - Verificar se Estou Usando Cheque Especial
0 - Sair
```

### Roteiro de Teste Sugerido:
1. **Crie a conta** com saldo inicial de `R$ 1000,00` (limite de cheque especial calculado: `R$ 500,00`).
2. **Execute um saque** de `R$ 1200,00` (opção `4`):
   - O saldo ficará negativo (`-R$ 200,00`), alertando que o cheque especial está sendo usado.
3. **Verifique o status** (opção `6`):
   - Confirmará o uso do cheque especial e informará o limite restante (`R$ 300,00`).
4. **Realize um depósito** de `R$ 300,00` (opção `3`):
   - O sistema descontará os juros de 20% sobre o cheque especial utilizado (`20% de R$ 200,00 = R$ 40,00`) e regularizará a conta.

---

## 👨‍💻 Autor

Desenvolvido por **Misael** como parte do aprendizado prático no **Bootcamp Itaú - Java com IA** pela **DIO**.

---
*Projeto aberto para fins de estudo, portfólio e avaliação técnica.*
