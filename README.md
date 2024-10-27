# TEAM CONECT

## Descripción

**TEAM CONECT** es una aplicación web que facilita la comunicación y la asignación de tareas entre equipos de trabajo. Permite gestionar usuarios, asignar roles y tareas, y proporciona un chat en tiempo real para la colaboración entre los miembros del equipo.

## Tecnologías Utilizadas

- **Java**: Lenguaje principal de programación.
- **Spring Boot**: Framework para desarrollo backend.
- **Thymeleaf**: Motor de plantillas para vistas.
- **MongoDB**: Base de datos no relacional para almacenamiento de datos.
- **WebSocket**: Comunicación en tiempo real para chat.
- **Maven**: Gestión de dependencias y construcción del proyecto.

## Funcionalidades Principales

1. **Registro de Usuario**: Permite a los usuarios registrarse en la plataforma proporcionando sus datos.
2. **Autenticación de Usuario por SMS**: Verificación mediante código de autenticación enviado por SMS.
3. **Asignación de Roles y Departamentos**: Asigna roles y estructura organizativa a los usuarios.
4. **Chat en Tiempo Real**: Comunicación entre usuarios mediante WebSocket.
5. **Asignación de Tareas**: Asigna tareas a usuarios o departamentos específicos.
6. **Visualización de Tareas**: Lista de tareas asignadas por usuario, departamento y área.
7. **Progreso de Tareas**: Visualización del estado y progreso de cada tarea.

## Estructura del Proyecto

```
TEAM-CONECT/
│
├── src/
│   ├── main/
│   │   ├── java/com/teamconect/
│   │   │   ├── config/                   # Configuración de WebSocket
│   │   │   ├── controllers/              # Controladores para servicios REST
│   │   │   ├── dtos/                     # Objetos de Transferencia de Datos (DTOs)
│   │   │   ├── models/                   # Modelos de entidades
│   │   │   ├── repositories/             # Repositorios de MongoDB
│   │   │   ├── services/                 # Servicios con lógica de negocio
│   │   └── resources/
│   │       ├── static/                   # Archivos estáticos (CSS, JS)
│   │       ├── templates/                # Vistas en Thymeleaf
│   │       └── application.yml           # Configuración de la aplicación
├── README.md                             # Archivo de documentación
└── pom.xml                                # Configuración de Maven
```

## Configuración

### Clonar el Repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd TEAM-CONECT
```

### Configurar MongoDB

Asegúrate de tener MongoDB instalado y en funcionamiento en `localhost:27017`.

### Configurar el Archivo `application.yml`

Configura las credenciales de MongoDB en `src/main/resources/application.yml`:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/teamconect
```

### Ejecutar la Aplicación

Utiliza Maven para ejecutar la aplicación.

```bash
mvn spring-boot:run
```

### Acceso a la Aplicación

Abre el navegador y dirígete a `http://localhost:8080`.

## Endpoints de la API

- **POST /api/users/register** - Registro de usuario.
- **POST /api/auth/sendCode** - Enviar código de verificación por SMS.
- **POST /api/auth/verifyCode** - Verificar código de autenticación.
- **POST /api/tasks/assign** - Asignación de tarea.
- **GET /api/tasks/{userId}** - Obtener tareas por usuario.

## Vistas y Uso

Las vistas se encuentran en `src/main/resources/templates/` y cubren las siguientes funcionalidades:

- **register.html**: Formulario de registro de usuario.
- **auth.html**: Formulario de autenticación.
- **assign-task.html**: Formulario para asignar tareas.
- **task-list.html**: Visualización de la lista de tareas asignadas.
- **chat.html**: Interfaz de chat en tiempo real.

## Contribuciones

Este proyecto está abierto a contribuciones. Si tienes ideas o mejoras, siéntete libre de abrir un pull request o reportar un issue.

