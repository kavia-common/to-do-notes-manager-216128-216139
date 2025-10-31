# To-Do Notes Backend (Spring Boot)

A simple REST API for managing to-do notes with CRUD operations.

- Port: 3001
- Swagger UI: /swagger-ui.html (or /docs). Also available under /swagger-ui/index.html
- OpenAPI JSON: /openapi.json (springdoc api docs; alternative default is /v3/api-docs)
- Health: /health
- H2 Console: /h2-console (dev/local profile)

## Run

```
./gradlew bootRun
```

## Endpoints

- GET /api/notes?page=0&size=10&sort=createdAt,desc
- GET /api/notes/{id}
- POST /api/notes
- PUT /api/notes/{id}
- DELETE /api/notes/{id}

## Request examples

Create:
```
POST /api/notes
Content-Type: application/json

{
  "title": "Buy groceries",
  "content": "Milk, Eggs",
  "completed": false
}
```

Update:
```
PUT /api/notes/1
Content-Type: application/json

{
  "title": "Buy groceries (updated)",
  "content": "Milk, Eggs, Bread",
  "completed": true
}
```

## Profiles

- dev/local: seeds sample data at startup via `DevDataLoader`.
