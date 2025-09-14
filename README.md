🧾 TaskManager — README Técnico
📌 Descripción General
TaskManager es una aplicación web para la gestión de proyectos y tareas, diseñada con arquitectura modular y roles diferenciados. Utiliza Spring Boot, Thymeleaf, y una base de datos relacional para manejar usuarios, roles, proyectos y tareas con visibilidad controlada.

🧱 Estructura del Proyecto
src/main/java/com/jiraKodigo/taskManager/
├── controllers/         → Controladores API y Web
├── models/              → Entidades y lógica de dominio
│   ├── auth/            → Seguridad y autenticación
│   ├── projects/        → Tipos de proyectos y fábrica
│   ├── tasks/           → Tareas, tipos, estados y fábrica
│   └── user/            → Roles, usuarios y relaciones
├── repository/          → Interfaces JPA
├── services/            → Lógica de negocio
└── TaskManagerApplication.java


👥 Usuarios y Roles
Entidades principales:
- User: representa al usuario autenticado. Tiene username, password, y un Role.
- Role: define el tipo de usuario (Admin, Boss, Minion, etc.).
- RoleTypeTask: relación entre roles y tipos de tareas que pueden visualizar.
Ejemplo:
-- Usuario JohnCena con rol Minion (id = 1)
INSERT INTO users (id, username, password, role_id) VALUES (1, 'JohnCena', '3hhater', 1);

-- Rol Minion puede ver solo tareas de tipo MinionType
INSERT INTO role_type_task (role_id, type_task_id)
SELECT 1, id FROM type_tasks WHERE name = 'MinionType';



📦 Tareas y Tipos
Entidades:
- Task (abstracta o interfaz): base para tareas.
- MinionTask: implementación concreta para tareas tipo Minion.
- TypeTask: define el tipo (MinionType, BossType, etc.).
- Status: enum con estados (PENDING, BLOCKED, COMPLETED).
Ejemplo:
INSERT INTO type_tasks (name) VALUES ('BossType'), ('MinionType');

INSERT INTO tasks (title, status, project_id, type_task_id)
VALUES ('Design combat interface', 'PENDING', 1, 2); -- MinionType

🧠 Metodología del Proyecto
🔹 Arquitectura
- Separación de responsabilidades: controladores web vs. API, servicios para lógica, repositorios para persistencia.
- Factory Pattern: usado para instanciar proyectos y tareas según tipo.
- Backend-driven filtering: los roles determinan qué tareas se ven, no el frontend.
🔹 Seguridad
- Validación de credenciales contra base de datos.
- Filtrado de tareas por rol desde el servicio, no desde la vista.
🔹 Escalabilidad
- Roles y tipos de tareas son extensibles.
- Separación clara entre vistas (Thymeleaf) y lógica (Spring).

🧩 Ejemplo de flujo de visualización de tareas
- Usuario inicia sesión → se obtiene su Role.
- El servicio RoleTypeTaskService devuelve los TypeTask permitidos.
- TaskService filtra las tareas del proyecto por esos tipos.
- El controlador envía las tareas filtradas al modelo.
- Thymeleaf renderiza solo las tareas visibles.

🧪 Testing y Validación
- Validación de entidades con @NotNull, @Size, etc.
- Pruebas unitarias para servicios (TaskService, RoleTypeTaskService).
- Pruebas de integración para flujo completo de visualización.

🚀 Cómo ejecutar
./mvnw spring-boot:run


Accede a la app en http://localhost:8080

📚 Recomendaciones futuras
- Integrar Spring Security para autenticación robusta.
- Agregar asignación directa de tareas a usuarios.
- Implementar dashboard por rol con métricas y filtros.






