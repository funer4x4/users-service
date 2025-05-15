# users-service
microservicio para CRUD usuarios

Este proyecto es una API REST para la gestión de usuarios, desarrollada con **Spring Boot** siguiendo la **arquitectura hexagonal** y utilizando una base de datos en memoria **H2**. Incluye validaciones de entrada, documentación con Swagger y una interfaza de la base de datos h2
## Características

- **Spring Boot 3.x**
- **Base de datos en memoria H2**
- **Arquitectura Hexagonal**
- **Validaciones con `spring-boot-starter-validation`**
- **Swagger UI para documentación de la API**

---

## Detalles importantes

### 1. Ejecutar la aplicación
Puedes ejecutarlo de dos formas:

### **Desde IntelliJ IDEA**
1. Abre el proyecto en IntelliJ.
2. Ejecuta la clase principal: **`ExamenLiverpoolApplication.java`**.

#### **Desde la línea de comandos**
```sh
mvn clean install
mvn spring-boot:run
```

### Consultar Swagger
Puedes entrar aqui:
[swagger](http://localhost:8080/swagger-ui/index.html#/)

### Entrar ala consola de H2
1. validar que JDBC URL sea igual a **`jdbc:h2:mem:testdb`**
2. Puedes entrar aqui:
[h2 console]( http://localhost:8080/h2-console)
