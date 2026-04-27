# Sistema de Biblioteca — Proyecto Educativo SOLID

Proyecto Java sencillo para enseñar los **cinco principios SOLID** con un ejemplo
concreto y un proceso de **linting automático** con Checkstyle.

---

## Cómo ejecutar

```bash
# Verificar estilo + compilar + tests
mvn verify

# Solo linting
mvn checkstyle:check

# Solo tests
mvn test
```

---

## Los principios SOLID en este proyecto

### S — Single Responsibility Principle
> *Una clase debe tener una sola razón para cambiar.*

| Clase | Su única responsabilidad |
|---|---|
| `Libro` | Representar los datos de un libro |
| `LibroRepositorioEnMemoria` | Guardar y recuperar libros |
| `ServicioPrestamo` | Lógica de préstamos y devoluciones |
| `VistaLibrosConsola` | Mostrar información al usuario |

Si el formato de pantalla cambia, solo se modifica `VistaLibrosConsola`.
Si la lógica de negocio cambia, solo se modifica `ServicioPrestamo`.

---

### O — Open/Closed Principle
> *Abierto para extensión, cerrado para modificación.*

Para agregar persistencia en base de datos:
```
LibroRepositorioEnMemoria  →  LibroRepositorioPostgres
```
Se crea una nueva clase que implemente `LibroRepositorio`. El servicio
**no se modifica**. Lo mismo aplica para notificaciones:
```
ServicioNotificacionConsola  →  ServicioNotificacionEmail
```

---

### L — Liskov Substitution Principle
> *Las subclases deben poder sustituir a sus clases base.*

Cualquier implementación de `VistaLibros` se puede usar en lugar de otra
sin romper el código. Una `VistaLibrosHtml` funciona igual que `VistaLibrosConsola`
desde el punto de vista del consumidor.

---

### I — Interface Segregation Principle
> *Los clientes no deben depender de métodos que no usan.*

- `LibroRepositorio`: solo operaciones sobre libros.
- `ServicioNotificacion`: solo una operación `notificar()`.
- `VistaLibros`: solo presentación.

Ninguna interfaz mezcla responsabilidades distintas.

---

### D — Dependency Inversion Principle
> *Depender de abstracciones, no de implementaciones concretas.*

`ServicioPrestamo` recibe sus dependencias por el constructor:
```java
// Correcto — depende de interfaces
public ServicioPrestamo(LibroRepositorio repositorio,
                        ServicioNotificacion notificacion) { ... }

// Incorrecto — acoplado a una implementación concreta
public ServicioPrestamo() {
    this.repositorio = new LibroRepositorioEnMemoria(); // ❌
}
```
Esto permite cambiar implementaciones **sin tocar el servicio** y facilita
enormemente los tests unitarios.

---

## Estructura del proyecto

```
biblioteca/
├── config/
│   └── checkstyle.xml          # Reglas de estilo
├── src/
│   ├── main/java/com/ejemplo/biblioteca/
│   │   ├── modelo/
│   │   │   └── Libro.java
│   │   ├── repositorio/
│   │   │   ├── LibroRepositorio.java           # Interfaz (DIP)
│   │   │   └── LibroRepositorioEnMemoria.java  # Implementación (OCP)
│   │   ├── servicio/
│   │   │   ├── ServicioNotificacion.java       # Interfaz (ISP)
│   │   │   ├── ServicioNotificacionConsola.java
│   │   │   └── ServicioPrestamo.java           # Lógica (SRP + DIP)
│   │   ├── ui/
│   │   │   ├── VistaLibros.java               # Interfaz (LSP + ISP)
│   │   │   └── VistaLibrosConsola.java
│   │   └── Aplicacion.java                    # Composition Root
│   └── test/java/com/ejemplo/biblioteca/
│       └── ServicioPrestamoTest.java
├── .github/workflows/
│   └── ci.yml                  # CI automático en GitHub
└── pom.xml
```

---

## Linting con Checkstyle

Las reglas en `config/checkstyle.xml` verifican automáticamente:

- Nombres en `camelCase` y `PascalCase`
- Javadoc en clases y métodos públicos
- Sin `import *` (imports explícitos)
- Métodos de máximo **30 líneas** (favorece SRP)
- Máximo **5 parámetros** por método
- Llaves siempre obligatorias en `if`/`for`/`while`
- Máximo **120 caracteres** por línea
- Sin tabs (solo espacios)

En GitHub, el workflow de CI falla automáticamente si hay violaciones de estilo.
