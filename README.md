# Customer Service API

Este proyecto es un microservicio de gestión de clientes desarrollado con Spring Boot.

## Características y Tecnologías
- **Java:** 17 (Eclipse Temurin)
- **Framework:** Spring Boot 3.5.14
- **Base de Datos:** H2 (En memoria por defecto)
- **Documentación:** SpringDoc OpenAPI (Swagger)
- **Arquitectura:** Estructura de capas (Controller, Service, Repository, DTO, Mapper)

## Prerrequisitos
- Docker y Docker Compose instalados.
- (Opcional) Java 17 y Maven para ejecución local.

## Cómo correr la aplicación con Docker

La forma más sencilla de ejecutar el proyecto es utilizando Docker Compose, el cual se encarga de compilar el código y levantar el contenedor.

### 1. Levantar con Docker Compose
Desde la raíz del proyecto, ejecuta:
```bash
docker-compose up --build
```

### 2. Acceso a la aplicación
Una vez levantado, puedes acceder a:
- **API Base:** `http://localhost:8082`
- **Swagger UI:** `http://localhost:8082/swagger-ui.html`
- **H2 Console:** `http://localhost:8082/h2-console`
    - **JDBC URL:** `jdbc:h2:mem:customerservicedb`
    - **User:** `sa`
    - **Password:** (vacío)

## Ejecución Local (Sin Docker)
Si prefieres correrlo directamente en tu máquina:
```bash
./mvnw spring-boot:run
```

## Endpoints Principales
- `GET /api/v1/customers`: Listar todos los clientes.
- `POST /api/v1/customers`: Crear un nuevo cliente.
- `GET /api/v1/customers/{id}`: Obtener detalle de un cliente.
- `PUT /api/v1/customers/{id}`: Actualizar un cliente.
- `DELETE /api/v1/customers/{id}`: Eliminar un cliente.

## Notas sobre la Base de Datos
Actualmente, el proyecto utiliza una base de datos **H2 en memoria**. Esto significa que todos los datos registrados se borrarán al detener el contenedor o la aplicación. Si deseas persistencia, consulta las instrucciones en el archivo `application.properties` para cambiar a modo archivo o configurar una base de datos externa.
