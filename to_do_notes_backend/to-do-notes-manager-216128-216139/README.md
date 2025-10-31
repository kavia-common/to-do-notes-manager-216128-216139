# To-Do Notes Manager

Backend: Spring Boot REST API providing CRUD for to-do notes.

- Port: 3001
- Swagger UI: /swagger-ui.html (or navigate to /docs which redirects)
- OpenAPI JSON: /openapi.json
- Health: /health
- H2 Console: /h2-console (dev or local profile)

Workspace structure:
- to_do_notes_backend: Spring Boot backend

## Run locally

Using Gradle wrapper:

```
cd to_do_notes_backend
./gradlew bootRun
```

The app uses in-memory H2 by default and seeds sample data in `dev` profile.

## API

Base URL: http://localhost:3001

- List notes (paginated):
  GET /api/notes?page=0&size=10&sort=createdAt,desc

- Get by id:
  GET /api/notes/{id}

- Create:
  POST /api/notes
  Content-Type: application/json
  {
    "title": "Buy groceries",
    "content": "Milk, Eggs",
    "completed": false
  }

- Update:
  PUT /api/notes/{id}
  Content-Type: application/json
  {
    "title": "Buy groceries (updated)",
    "content": "Milk, Eggs, Bread",
    "completed": true
  }

- Delete:
  DELETE /api/notes/{id}

Validation errors return 400 with a ProblemDetail body. Missing resources return 404.

## Environment variables

See .env.example for optional overrides. By default, the server runs on port 3001.

## Notes

- Uses H2 in-memory DB for development and preview environments.
- The data model includes: id (Long), title (required), content (optional), completed (boolean), createdAt/updatedAt timestamps.
