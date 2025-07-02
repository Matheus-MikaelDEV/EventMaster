# 🎉 Sistema de Gerenciamento de Eventos

## 📋 Descrição

Este projeto é um sistema simples para gerenciar eventos, desenvolvido em Java. Ele permite criar eventos, adicionar participantes, buscar eventos pelo nome e listar todos os eventos cadastrados.

O sistema utiliza conceitos de orientação a objetos, como enumerações, listas, classes e manipulação de datas com `LocalDateTime`.

---

## 🚀 Funcionalidades

- 🆕 Adicionar eventos com informações como nome, local, data, tipo (ex: CONFERENCE, WORKSHOP, etc.) e descrição.
- 👥 Adicionar múltiplos participantes para cada evento, incluindo nome e e-mail.
- 🔍 Buscar um evento pelo nome e exibir seus detalhes, incluindo participantes.
- 📋 Listar todos os eventos cadastrados com seus detalhes e participantes.
- 🖥️ Menu interativo via terminal para escolha das operações.

---

## 🎯 Como usar

1. ▶️ Execute o programa `Program.java`.
2. No menu, escolha uma das opções:
   - **1️⃣ - Add Event:** Adiciona um novo evento. Você deverá informar os dados do evento e seus participantes.
   - **2️⃣ - Search Event:** Pesquisa um evento pelo nome e mostra as informações encontradas.
   - **3️⃣ - List Events:** Exibe todos os eventos cadastrados com detalhes completos.
   - **4️⃣ - Exit:** Encerra o programa.

3. 📝 Siga as instruções no terminal para inserir os dados necessários.

---

## 🛠️ Tecnologias

- ☕ Java 8 ou superior  
- 📦 Pacotes Java padrão (`java.time.LocalDateTime`, `java.util.ArrayList`, etc.)

---

## 🗂️ Estrutura do Projeto

- `application.Program` — Classe principal que contém o menu e interação com o usuário.
- `entities.Event` — Classe que representa um evento, com informações e lista de participantes.
- `entities.Participant` — Classe que representa um participante de um evento.
- `entities.EventType` — Enumeração com os tipos possíveis de eventos.
- `entities.EventSystem` — Classe que gerencia a lista de eventos e fornece métodos para adicionar, buscar e listar eventos.

---

## ⚠️ Observações

- 📅 O formato da data deve ser informado como `YYYY-MM-DDTHH:MM`, por exemplo: `2025-07-02T15:30`.
- 🔤 O tipo do evento deve ser uma das opções definidas no enum `EventType` (ex: CONFERENCE, WORKSHOP, SEMINAR, etc.), digitado em qualquer caso (maiúsculo ou minúsculo).
- 🚫 Caso não existam eventos cadastrados, as opções de busca e listagem retornam uma mensagem adequada.

---

## 💡 Exemplo de Uso

```
Welcome to the Event Management System!
Chose an option:
1 - Add Event
2 - Search Event
3 - List Events
4 - Exit
Enter your choice: 1

Adding an event...
Enter event name: Tech Conference 2025
Enter event location: São Paulo
Enter event date (YYYY-MM-DDTHH:MM): 2025-09-15T09:00
Enter event type: CONFERENCE
Enter event description: Conferência anual de tecnologia
How many participants in Tech Conference 2025? 2
Enter participant 1 name: João Silva
Enter participant email: joao.silva@email.com
Participant added: João Silva
Enter participant 2 name: Maria Oliveira
Enter participant email: maria.oliveira@email.com
Participant added: Maria Oliveira
Event added successfully! 🎉
```
