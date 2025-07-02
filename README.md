# 🎉 Event Management System

Este projeto é um **Sistema de Gerenciamento de Eventos** feito em Java, utilizando os conceitos de **POO (Programação Orientada a Objetos)** e **coleções** como `ArrayList`. A aplicação roda no terminal e permite adicionar, buscar, listar, editar eventos e participantes.

## 🚀 Funcionalidades

- Adicionar novos eventos com nome, local, data, tipo e descrição.
- Inserir participantes em cada evento.
- Buscar eventos por nome.
- Listar todos os eventos cadastrados e seus respectivos participantes.
- Editar eventos já existentes.
- Editar ou adicionar participantes em eventos existentes.

## 📦 Estrutura de Pastas

```
src/
├── application/
│   └── Program.java         # Classe principal com o menu de interação
├── entities/
│   ├── Event.java           # Representa um evento
│   ├── EventSystem.java     # Lógica de controle dos eventos e participantes
│   ├── Participant.java     # Representa um participante
│   └── EventType.java       # Enum com os tipos possíveis de evento
```

## 🧠 Tecnologias e Conceitos Utilizados

- Java 8+
- Programação Orientada a Objetos (POO)
- `ArrayList`
- Enumerações
- `LocalDateTime` para manipulação de datas
- Manipulação de entrada de dados com `Scanner`

## 📝 Como usar

1. Compile o projeto:

```bash
javac application/Program.java
```

2. Execute a aplicação:

```bash
java application.Program
```

3. Use o menu interativo para navegar entre as opções:

- `1` para adicionar evento
- `2` para buscar um evento
- `3` para listar todos os eventos
- `4` para editar eventos e participantes
- `5` para sair  
