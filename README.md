# 📝 To-Do API

API REST para gerenciamento de tarefas desenvolvida com **Spring Boot**, aplicando o padrão de projeto **State Pattern** para controle de ciclo de vida das tarefas.

Projeto desenvolvido como desafio final do módulo de **Padrões de Projeto (Design Patterns)** da DIO.

---

## 🎯 Design Pattern — State Pattern

O **State Pattern** permite que um objeto altere seu comportamento quando seu estado interno muda. Neste projeto, ele é aplicado no ciclo de vida de uma tarefa:

```
PENDENTE ──► EM_PROGRESSO ──► CONCLUÍDA
```

Cada estado é uma classe independente que implementa a interface `TarefaState`. A tarefa delega para o estado atual a responsabilidade de saber qual é o próximo estado. Ao atingir `CONCLUÍDA`, a tarefa não avança mais.

### Estrutura do padrão

```
state/
├── TarefaState.java        ← interface (getNome, avancar)
├── PendenteState.java      ← estado inicial
├── EmProgressoState.java   ← estado intermediário
└── ConcluidaState.java     ← estado final
```

---

## 🛠️ Tecnologias

- Java 17+
- Spring Boot 3
- Maven

---

## 📁 Estrutura do Projeto

```
src/main/java/com/todoapi/todoapi/
│
├── controllers/
│   └── TarefaController.java
│
├── models/
│   └── Tarefa.java
│
├── services/
│   └── TarefaService.java
│
└── state/
    ├── TarefaState.java
    ├── PendenteState.java
    ├── EmProgressoState.java
    └── ConcluidaState.java
```

> ⚠️ Os dados são armazenados em memória. Ao reiniciar a aplicação, as tarefas são perdidas.

---

## 🚀 Como executar

**Pré-requisitos:** Java 17+ e Maven instalados.

```bash
# Clone o repositório
git clone https://github.com/JDeyvisson/To-Do-API.git
cd To-Do-API

# Execute a aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 📡 Endpoints

| Método   | Rota                      | Descrição                                   |
|----------|---------------------------|---------------------------------------------|
| `GET`    | `/tarefas`                | Lista todas as tarefas                      |
| `POST`   | `/tarefas/criar`          | Cria uma nova tarefa                        |
| `PATCH`  | `/tarefas/{id}/avancar`   | Avança o estado da tarefa (State Pattern)   |
| `PUT`    | `/tarefas/{id}/atualizar` | Atualiza a descrição da tarefa              |
| `DELETE` | `/tarefas/{id}/deletar`   | Remove uma tarefa                           |

---

## 🧪 Testando com REST Client (VS Code)

Instale a extensão [REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) no VS Code, abra o arquivo `endpoints.http` na raiz do projeto e clique em **Send Request** acima de cada requisição.

### Exemplos

**Criar uma tarefa**
```http
POST http://localhost:8080/tarefas/criar?descricao=Estudar Design Patterns
```

**Avançar o estado** *(PENDENTE → EM_PROGRESSO → CONCLUÍDA)*
```http
PATCH http://localhost:8080/tarefas/1/avancar
```

**Resposta esperada**
```json
{
  "id": 1,
  "descricao": "Estudar Design Patterns",
  "estado": "EM_PROGRESSO"
}
```

---

## 👨‍💻 Autor

Feito por **Deyvisson** — [GitHub](https://github.com/JDeyvisson)
