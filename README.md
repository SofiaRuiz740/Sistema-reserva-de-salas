# Sistema de reserva de salas

Laboratorio de patrones de diseño de la Corporación Universitaria Empresarial Alexander von Humboldt. Es un prototipo de consola en Java para reservar salas de una biblioteca. Todo funciona en memoria, no hay base de datos ni interfaz gráfica.

Apliqué cinco patrones: Builder, Strategy, Facade, Observer y State.

## Cómo correrlo

Necesita Java 17 o superior. 
Se puede ejecutar el Main directamente desde VS Code.

## Qué hace el Main

Hace una reserva para Laura, la cancela y prueba que no se pueda confirmar una reserva cancelada. Después prueba la sala preferida, una solicitud para 10 personas que no encuentra sala y una reserva que se finaliza. Cada cambio de estado imprime el aviso al estudiante y el registro del evento.

## Ramas

Trabajé una rama por estación, y master tiene todo integrado.

| Estación | Rama |
|---|---|
| 1. Diagrama de flujo | Modelado-de-flujo |
| 2. Estudiante y Sala | Creación-de-clases |
| 3. Builder | Aplicación-de-builder |
| 4. Strategy | Incorporación-de-strategy |
| 5. Repositorios y Facade | Implementación-de-facade |
| 6. Observer | Aplicación-de-observer |
| 7. State | Incorporación-de-state |
| 8. Integración final | Integración-final |

## Autora

Angie Sofía Ruiz
