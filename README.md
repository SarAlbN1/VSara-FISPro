# TEAM CONNECT

## Descripción

**TEAM CONNECT** es una aplicación web diseñada para mejorar la comunicación y la asignación de tareas dentro de equipos de trabajo. La aplicación permite gestionar usuarios, asignar roles y tareas, y proporciona un chat en tiempo real para facilitar la colaboración efectiva entre los miembros del equipo.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje principal de programación.
- **Spring Boot**: Framework para el desarrollo de backend.
- **Thymeleaf**: Motor de plantillas para la generación de vistas HTML.
- **PostgreSQL**: Base de datos relacional utilizada para el almacenamiento de datos.
- **Twilio**: Servicio de mensajería para la autenticación mediante SMS.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **WebSocket**: Protocolo para comunicación en tiempo real en el chat.

## Funcionalidades Principales

1. **Registro de Usuario**: Permite a los usuarios registrarse en la plataforma proporcionando sus datos.
2. **Autenticación de Usuario por SMS**: Verificación mediante un código de autenticación enviado por SMS.
3. **Asignación de Roles y Departamentos**: Asignación de roles y estructura organizativa a los usuarios.
4. **Chat en Tiempo Real**: Comunicación entre usuarios mediante WebSocket.
5. **Asignación de Tareas**: Asigna tareas a usuarios o departamentos específicos.
6. **Visualización de Tareas**: Muestra las tareas asignadas, filtradas por usuario, departamento y área.
7. **Progreso de Tareas**: Visualización del estado y progreso de cada tarea.

## Estructura del Proyecto

```plaintext
TEAM-CONNECT/
│
├── src/
│   ├── main/
│   │   ├── java/com/teamconect/
│   │   │   ├── config/                   # Configuración de WebSocket y seguridad
│   │   │   ├── controllers/              # Controladores para servicios REST
│   │   │   ├── dtos/                     # Objetos de Transferencia de Datos (DTOs)
│   │   │   ├── models/                   # Modelos de entidades
│   │   │   ├── repositories/             # Repositorios de JPA para PostgreSQL
│   │   │   ├── services/                 # Servicios con lógica de negocio
│   │   └── resources/
│   │       ├── static/                   # Archivos estáticos (CSS, JS)
│   │       ├── templates/                # Vistas en Thymeleaf
│   │       └── application.yml           # Configuración de la aplicación
├── README.md                             # Archivo de documentación
└── pom.xml                               # Configuración de Maven
```

## Configuración

### Clonar el Repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd TEAM-CONNECT
```

### Configurar PostgreSQL

Asegúrate de tener PostgreSQL en funcionamiento y crea una base de datos para la aplicación.

### Configurar el Archivo `application.yml`

Configura las credenciales de PostgreSQL y Twilio en `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/teamconnect_db
    username: tu_usuario
    password: tu_contraseña
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

twilio:
  account-sid: tu_account_sid
  auth-token: tu_auth_token
  phone-number: "+1234567890"
```

### Ejecutar la Aplicación

Utiliza Maven para ejecutar la aplicación.

```bash
mvn spring-boot:run
```

### Acceso a la Aplicación

Abre tu navegador y dirígete a `http://localhost:8080`.

## Endpoints de la API

- **POST /api/users/register** - Registro de usuario.
- **POST /api/auth/login** - Iniciar sesión y validar credenciales de usuario.
- **POST /api/auth/send-code** - Enviar código de verificación por SMS.
- **POST /api/auth/verify-code** - Verificar el código de autenticación.
- **POST /api/tasks/assign** - Asignación de tarea.
- **GET /api/tasks/by-user/{userId}** - Obtener tareas asignadas a un usuario.
- **GET /api/tasks/by-department/{departmentId}** - Obtener tareas asignadas a un departamento.
- **GET /api/tasks/by-area/{areaId}** - Obtener tareas asignadas a un área.

## Vistas y Uso

Las vistas están ubicadas en `src/main/resources/templates/` y cubren las siguientes funcionalidades:

- **register.html**: Formulario para el registro de nuevos usuarios.
- **auth.html**: Formulario de autenticación y verificación de código SMS.
- **assign-task.html**: Formulario para asignar tareas a los usuarios.
- **task-list.html**: Muestra la lista de tareas asignadas con filtros de usuario, departamento y área.
- **chat.html**: Interfaz para el chat en tiempo real entre los usuarios.

## Ejemplo de Flujo de Autenticación

1. **Registro de Usuario**: El usuario se registra proporcionando su nombre, correo electrónico, contraseña y número de teléfono.
2. **Inicio de Sesión**: El usuario introduce su correo y contraseña.
3. **Verificación por SMS**: Si el usuario tiene un número de teléfono registrado que coincide, se le envía un código de verificación SMS a través de Twilio.
4. **Acceso**: El usuario ingresa el código recibido y, si es válido, accede a la plataforma.

## Contribuciones

Este proyecto está abierto a contribuciones. Si tienes ideas, mejoras o encuentras problemas, siéntete libre de abrir un pull request o reportar un issue.

## Contacto

Para más información, puedes ponerte en contacto con el equipo de desarrollo.

